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

import static org.passau.SootPathFinder.SootPathSetter.INPUT_LOCATION_PATH;

public class XMLParsing {
    /**
     * Parses the provided XML coverage report to extract the line numbers of the missed lines.
     *
     * @param xmlFilePath The path to the XML coverage report file.
     * @return A list of integers representing the line numbers of the missed lines.
     * @throws Exception If there's an error during XML parsing or file reading.
     */
    public static List<Integer> getMissedLinesFromXML(String xmlFilePath) throws Exception {
        List<Integer> missedLines = new ArrayList<>();

        // Load and parse the XML document
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();

        // Disable loading of external DTD to avoid potential network calls or access to local files
        dbFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);

        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);

        // Normalize the parsed XML structure for easier traversal
        doc.getDocumentElement().normalize();

        // Iterate over all "line" elements in the XML document
        NodeList nodeList = doc.getElementsByTagName("line");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;

                // Check if the line has missed instructions
                int missedInstructions = Integer.parseInt(element.getAttribute("mi"));

                // If the line has missed instructions, add it's number to the list
                if (missedInstructions > 0) {
                    missedLines.add(Integer.parseInt(element.getAttribute("nr")));
                }
            }
        }

        return missedLines;
    }

    /**
     * Removes the lines from the source file that are indicated as missed, and writes the modified
     * content to the specified output file. If the output file does not exist, it will be created.
     *
     * @param sourceFilePath Path to the original source file.
     * @param missedLines    List of line numbers that should be removed.
     * @param outputFilePath Path where the modified source content should be written.
     * @throws IOException If there's an error during file reading or writing.
     */
    public static void removeMissedLinesFromSourceFile(String sourceFilePath, List<Integer> missedLines, String outputFilePath) throws IOException {
        // Read all lines from the source file into a list
        List<String> lines = Files.readAllLines(Paths.get(sourceFilePath));
        StringBuilder modifiedSource = new StringBuilder();

        // Iterate over each line of the source file
        for (int i = 0; i < lines.size(); i++) {
            // Check if the current line (adjusted for 0-based index) is not in the list of missed lines
            if (!missedLines.contains(i + 1)) { // +1 because line numbers start from 1
                modifiedSource.append(lines.get(i)).append("\n");
            }
        }

        // Ensure that the directories leading up to the output file exist, creating them if necessary
        Path path = Paths.get(outputFilePath);
        Files.createDirectories(path.getParent());

        // Write the modified source content to the specified output file.
        // This will create the file if it doesn't exist or overwrite it if it does.
        Files.write(path, modifiedSource.toString().getBytes());
    }

    /**
     * Compiles a Java file and stores the resulting bytecode (.class file) in the same directory as the source file.
     *
     * @param filePath Path to the Java file to be compiled.
     * @return {@code true} if the compilation was successful, {@code false} otherwise.
     */
    public static boolean compileJavaFile(String filePath) {
        // Obtain a JavaCompiler instance, which provides facilities for compiling Java source files
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();

        // Get a StandardJavaFileManager instance, which provides access to file-based Java FileObjects
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);

        // Convert the provided file path into an iterable collection of file objects
        Iterable<? extends JavaFileObject> sources = fileManager.getJavaFileObjectsFromStrings(Arrays.asList(filePath));

        // Specify the directory where the generated .class files should be saved, which in this case
        // is the same directory as the source .java file
        String outputDir = new File(filePath).getParent() + "/target/";

        // Set the compilation options, particularly specifying the output directory
        Iterable<String> options = Arrays.asList(outputDir);

        // Prepare a compilation task. This doesn't actually execute the compilation yet.
        JavaCompiler.CompilationTask task = compiler.getTask(null, fileManager, null, null, null, sources);

        // Execute the compilation and return the result (true if successful, false otherwise)
        return task.call();
    }

    public static void main(String[] args) throws Exception {
        // THIS IS JUST TEST PURPOSE IMPLEMENTATION SO STILL WE HAVE SOME HARD CODE HERE
        // LATER WHEN WE WILL AUTOMATE THE PROCESS INSIDE THE LOOP >> WE WILL AUTOMATICALLY GET THE JAVA FILE AND OTHER FILES AS WELL
        String sourceFilePath = INPUT_LOCATION_PATH + "/src/main/java/org/passau/CodeExamples/OriginalCode/classA.java";
        String xmlFilePath = INPUT_LOCATION_PATH+"/Coverage_Reports/coverage_report_2.xml";
        List<Integer> missedLines = getMissedLinesFromXML(xmlFilePath);
        String outputDirectory = INPUT_LOCATION_PATH + "/TemporaryClasses/SourceCode/";
        String outputFileName = "classA.java";
        String outputFilePath = outputDirectory + outputFileName;
        removeMissedLinesFromSourceFile(sourceFilePath, missedLines, outputFilePath);

        String javaFilePath = INPUT_LOCATION_PATH+"/TemporaryClasses/SourceCode/classA.java";
        if(compileJavaFile(javaFilePath)) {
            System.out.println("Compilation successful!");
        } else {
            System.out.println("Compilation failed!");
        }

    }
}
