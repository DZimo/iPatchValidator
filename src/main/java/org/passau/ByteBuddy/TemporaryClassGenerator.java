package org.passau.ByteBuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import org.apache.commons.io.FileUtils;
import org.passau.CodeExamples.OriginalCode.classA;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class TemporaryClassGenerator {
    static String sourceDirectory = System.getenv("iPatchValidator");
    public static void main(String[] args) throws Exception {

        // ITERATE OVER THE FOLDER AND GET THE CLASS BYTECODE FOR EACH REPORT
        List<byte[]> tempClassBytesList = generateByteArrayListFromReports(sourceDirectory+"/Coverage_Reports", classA.class);
        storeByteArrayListAsClasses(tempClassBytesList, sourceDirectory + "/TemporaryClasses");

        System.out.println(Arrays.toString(tempClassBytesList.iterator().next()));


    }



    public static byte[] generateTempClassFromXML(File xmlFile, Class<?> originalClass) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        factory.setValidating(false);
        factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        DocumentBuilder documentBuilder = factory.newDocumentBuilder();
        Document doc = documentBuilder.parse(xmlFile);

        NodeList methodNodes = doc.getElementsByTagName("method");
        List<String> uncoveredMethods = new ArrayList<>();

        // Identify uncovered methods
        for (int i = 0; i < methodNodes.getLength(); i++) {
            Element methodElement = (Element) methodNodes.item(i);
            Element counterElement = (Element) methodElement.getElementsByTagName("counter").item(0);
            String missed = counterElement.getAttribute("missed");

            // For simplicity, if missed is more than 0, we consider the method as uncovered.
            if (Integer.parseInt(missed) > 0) {
                uncoveredMethods.add(methodElement.getAttribute("name"));
            }
        }

        DynamicType.Builder<?> byteBuddyBuilder = new ByteBuddy().subclass(originalClass);

        // Handle uncovered methods
        for (String uncoveredMethod : uncoveredMethods) {
            try {
                Method method = originalClass.getDeclaredMethod(uncoveredMethod);
                Class<?> returnType = method.getReturnType();

                if (returnType.equals(int.class)) {
                    byteBuddyBuilder = byteBuddyBuilder.method(named(uncoveredMethod)).intercept(FixedValue.value(-1));
                } else if (returnType.equals(String.class)) {
                    byteBuddyBuilder = byteBuddyBuilder.method(named(uncoveredMethod)).intercept(FixedValue.value("uncovered"));
                } else if (returnType.equals(boolean.class)) {
                    byteBuddyBuilder = byteBuddyBuilder.method(named(uncoveredMethod)).intercept(FixedValue.value(false));
                }
                // ... Handle other return types as needed

            } catch (NoSuchMethodException e) {
                // Handle or log the error
            }
        }

        DynamicType.Unloaded<?> unloadedClass = byteBuddyBuilder.make();

        return unloadedClass.getBytes();
    }




    /**
     * Generates byte arrays for all report.xml files in the specified directory using the provided class.
     *
     * @param directoryPath The directory where the report.xml files are located.
     * @param targetClass The class to be used in the generation process.
     * @return A list of byte arrays.
     * @throws IOException If there's an issue accessing the files.
     */
    public static List<byte[]> generateByteArrayListFromReports(String directoryPath, Class<?> targetClass) throws Exception {
        List<byte[]> byteArrayList = new ArrayList<>();

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            throw new IOException("The specified path is not a valid directory: " + directoryPath);
        }

        // Filter files with name matching
        File[] reportFiles = directory.listFiles((dir, name) -> name.matches("coverage_report_.*\\.xml"));

        assert reportFiles != null;
        for (File reportFile : reportFiles) {
            byte[] tempClassBytes = generateTempClassFromXML(reportFile, targetClass);
            byteArrayList.add(tempClassBytes);
        }

        return byteArrayList;
    }

    /**
     * Saves each byte array from the list as a class file within the specified directory.
     *
     * @param tempClassBytesList List of byte arrays representing class data.
     * @param directoryPath Directory where the class files will be stored.
     * @throws IOException If there's an issue writing the byte arrays to the class files.
     */
    public static void storeByteArrayListAsClasses(List<byte[]> tempClassBytesList, String directoryPath) throws IOException {
        // Ensure the specified directory exists
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean dirsCreated = directory.mkdirs();
            if (!dirsCreated) {
                throw new IOException("Failed to create directories: " + directory.getAbsolutePath());
            }
        }

        // Save each byte[] as a class file within the directory
        int classCounter = 1;
        for (byte[] classBytes : tempClassBytesList) {
            String classFileName = "tempClass_" + classCounter + ".class";
            File classFile = new File(directory, classFileName);
            FileUtils.writeByteArrayToFile(classFile, classBytes);
            classCounter++;
        }
    }


}
