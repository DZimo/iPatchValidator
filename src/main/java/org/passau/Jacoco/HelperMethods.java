package org.passau.Jacoco;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.report.IMultiReportOutput;
import org.jacoco.report.IReportVisitor;
import org.jacoco.report.xml.XMLFormatter;
import org.passau.CodeExamples.OriginalCode.classA;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Objects;

import static org.passau.Jacoco.JacocoReport.generateCoverageReports;

public class HelperMethods {
    /**
     * Fetches the compiled bytecode of the provided class.
     *
     * @param clazz The class for which the bytecode is to be fetched.
     * @return The bytecode of the class in the form of a byte array.
     * @throws IOException If there's an issue reading the class resource.
     */
    static byte[] getTargetClass(Class<?> clazz) throws IOException {
        final String resourceName = "/" + clazz.getName().replace('.', '/') + ".class";
        return Objects.requireNonNull(clazz.getResourceAsStream(resourceName)).readAllBytes();
    }

    /**
     * Creates and initializes an XML report visitor for JaCoCo.
     *
     * @return An initialized instance of IReportVisitor with XML format settings.
     * @throws IOException If there's an issue creating the XML report visitor.
     */
    static IReportVisitor createReportVisitor(ByteArrayOutputStream baos) throws IOException {
        return new XMLFormatter().createVisitor(baos);
    }



    /**
     * Analyzes the structure of the provided class to generate code coverage data.
     *
     * @param clazz The class to be analyzed.
     * @param executionData Data store that holds runtime execution data.
     * @return A CoverageBuilder containing information about the class's coverage.
     * @throws IOException If there's an issue analyzing the class structure.
     */
    static CoverageBuilder analyzeStructure(Class<?> clazz, ExecutionDataStore executionData) throws IOException {
        final CoverageBuilder coverageBuilder = new CoverageBuilder();
        final Analyzer analyzer = new Analyzer(executionData, coverageBuilder);

        // Convert byte[] to InputStream using ByteArrayInputStream
        try (InputStream targetClassStream = new ByteArrayInputStream(getTargetClass(clazz))) {
            analyzer.analyzeAll(targetClassStream, clazz.getName());
        }

        return coverageBuilder;
    }

    /**
     * A custom class loader designed to load instrumented classes.
     * This allows JaCoCo to perform code coverage analysis on them.
     */
    static class CustomClassLoader extends ClassLoader {
        /**
         * Defines a new class from its bytecode representation.
         *
         * @param name The expected fully-qualified name of the class.
         * @param b The bytecode representation of the class.
         * @return The newly defined class.
         */
        public Class<?> defineClass(String name, byte[] b) {
            return defineClass(name, b, 0, b.length);
        }
    }

    /**
     * Generates coverage reports for the specified source directory and saves them as XML files.
     *
     * @param sourceDirectory The directory where the compiled test classes are located.
     */
    public static void generateAndSaveCoverageReports(String sourceDirectory) {
        try {
            // Convert the source directory path to a URI for class loading
            URI uri = new URI("file", sourceDirectory + "/target/test-classes/", null);
            URL[] urls = new URL[]{uri.toURL()};

            // Create a class loader to load the test class from the specified directory
            ClassLoader loader = new URLClassLoader(urls);

            // Load the test class using the custom class loader
            Class<?> testClass = Class.forName("CodeExamples.classATest", true, loader);

            // Generate coverage reports using the specified method and test class
            List<String> reportXml = generateCoverageReports(classA.class, "methodA", testClass);

            // Print the generated XML reports to the console
            for (String report : reportXml) {
                System.out.println(report);
            }

            // Define the path where the reports will be saved
            String folderPath = sourceDirectory + "/Coverage_Reports/";

            // Create the directory if it doesn't exist
            File folder = new File(folderPath);
            if (!folder.exists()) {
                boolean dirsCreated = folder.mkdirs();
                if (!dirsCreated) {
                    throw new IOException("Failed to create directories: " + folder.getAbsolutePath());
                }
            }

            // Iterate through the generated reports and save each as an XML file
            for (int i = 0; i < reportXml.size(); i++) {
                String report = reportXml.get(i);
                String fileName = "coverage_report_" + (i + 1) + ".xml";
                File reportFile = new File(folder, fileName);

                // Write the XML content to the file
                try (FileWriter writer = new FileWriter(reportFile)) {
                    writer.write(report);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void copyClassFromXMLReportInDirectory(String xmlReportsDirectory, String baseDirectory, String targetDirectory) throws Exception {
        // Navigate to the XML reports directory and get the first XML file
        File directory = new File(xmlReportsDirectory);
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(xmlReportsDirectory + " is not a valid directory.");
        }

        // Get XML files from the directory
        File[] xmlFiles = directory.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xml");
            }
        });

        if (xmlFiles == null || xmlFiles.length == 0) {
            throw new IllegalArgumentException("No XML files found in the directory: " + xmlReportsDirectory);
        }

        File firstXmlFile = xmlFiles[0];

        // Parse the XML file
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        configureFactoryToIgnoreDTD(factory);

        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(firstXmlFile);

        // Extract class location from XML
        NodeList classNodes = document.getElementsByTagName("class");
        if (classNodes.getLength() == 0) {
            throw new IllegalArgumentException("No <class> element found in the XML report.");
        }
        Node classNode = classNodes.item(0);
        String classLocation = classNode.getAttributes().getNamedItem("name").getNodeValue();
        classLocation = classLocation.replace('.', '/') + ".java";  // Convert package structure to path and append ".class"

        // Copy the .class file
        Path sourcePath = Paths.get(baseDirectory, classLocation);
        Path targetPath = Paths.get(targetDirectory, sourcePath.getFileName().toString());
        if (Files.exists(targetPath)) {
            System.out.println("File already exists: " + targetPath.toString());
            // Uncomment the following line if you want to replace the existing file
            // Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
        } else {
            Files.copy(sourcePath, targetPath);
        }
    }

    private static void configureFactoryToIgnoreDTD(DocumentBuilderFactory factory) {
        factory.setValidating(false);
        factory.setNamespaceAware(true);
        try {
            factory.setFeature("http://xml.org/sax/features/namespaces", false);
            factory.setFeature("http://xml.org/sax/features/validation", false);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
            factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
