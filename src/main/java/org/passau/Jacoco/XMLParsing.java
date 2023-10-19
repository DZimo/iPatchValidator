package org.passau.Jacoco;

import org.w3c.dom.*;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class XMLParsing {
    public static List<Integer> getMissedLinesFromXML(String xmlFilePath) throws Exception {
        List<Integer> missedLines = new ArrayList<>();

        // Parse XML
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        // Extract missed line numbers
        NodeList nodeList = doc.getElementsByTagName("line");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                int missedInstructions = Integer.parseInt(element.getAttribute("mi"));
                if (missedInstructions > 0) {
                    missedLines.add(Integer.parseInt(element.getAttribute("nr")));
                }
            }
        }

        return missedLines;
    }
    public static void removeMissedLinesFromSourceFile(String sourceFilePath, List<Integer> missedLines, String outputFilePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(sourceFilePath));
        StringBuilder modifiedSource = new StringBuilder();

        for (int i = 0; i < lines.size(); i++) {
            if (!missedLines.contains(i + 1)) { // +1 because line numbers start from 1
                modifiedSource.append(lines.get(i)).append("\n");
            }
        }

        // Ensure that the directories leading up to the file exist
        Path path = Paths.get(outputFilePath);
        Files.createDirectories(path.getParent());

        // This will create the file if it doesn't exist or overwrite it if it does
        Files.write(path, modifiedSource.toString().getBytes());
    }
    public static boolean compileJavaFile(String filePath) {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        Iterable<? extends JavaFileObject> sources = fileManager.getJavaFileObjectsFromStrings(Arrays.asList(filePath));

        // Define the compilation options (in this case, specifying the directory where the class files should be saved)
        String outputDir = new File(filePath).getParent();
        Iterable<String> options = Arrays.asList("-d", outputDir);

        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, options, null, sources);
        return task.call();
    }

    public static void main(String[] args) throws Exception {
        String sourceFilePath = "/Users/shifatsahariar/Downloads/java/iPatchValidator/src/main/java/org/passau/CodeExamples/OriginalCode/classA.java";
        String xmlFilePath = "/Users/shifatsahariar/Downloads/java/iPatchValidator/Coverage_Reports/coverage_report_2.xml";
        List<Integer> missedLines = getMissedLinesFromXML(xmlFilePath);
        String outputDirectory = "/Users/shifatsahariar/Downloads/java/iPatchValidator/TemporaryClasses/";
        String outputFileName = "classA.java";
        String outputFilePath = outputDirectory + outputFileName;
        removeMissedLinesFromSourceFile(sourceFilePath, missedLines, outputFilePath);

        String javaFilePath = "/Users/shifatsahariar/Downloads/java/iPatchValidator/TemporaryClasses/classA.java";
        if(compileJavaFile(javaFilePath)) {
            System.out.println("Compilation successful!");
        } else {
            System.out.println("Compilation failed!");
        }

    }
}
