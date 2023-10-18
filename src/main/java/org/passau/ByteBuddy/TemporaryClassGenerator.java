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
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.bytebuddy.matcher.ElementMatchers.named;

public class TemporaryClassGenerator {

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


    public static void main(String[] args) throws Exception {
        byte[] tempClassBytes = generateTempClassFromXML(new File("coverage_report.xml"), classA.class);

        System.out.println(Arrays.toString(tempClassBytes));

//        Files.write( Path , tempClassBytes, new File("test1.class"));
        FileUtils.writeByteArrayToFile(new File("test.class"), tempClassBytes);
    }


}
