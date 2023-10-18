package org.passau.Jacoco;
import org.jacoco.core.analysis.*;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.instr.Instrumenter;
import org.jacoco.core.runtime.IRuntime;
import org.jacoco.core.runtime.LoggerRuntime;
import org.jacoco.core.runtime.RuntimeData;
import org.jacoco.report.*;
import org.jacoco.report.xml.XMLFormatter;
import org.passau.CodeExamples.OriginalCode.classA;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static org.passau.Jacoco.HelperMethods.*;

public class JacocoReport {
    /**
     * 1. Initializing JaCoCo runtime and data structures:
     * 2. Instrument the provided test class to enable coverage collection:
     * 3. Execute the instrumented class:
     * 4. Collect coverage data after execution:
     * 5. Generate the coverage report:
     * 6. Return the generated report:
     * @param testClass
     * @return
     * @throws Exception
     */
    public static String generateCoverageReport(Class<?> testClass) throws Exception {

        // Create a new runtime which logs all events for debugging purposes.
        IRuntime runtime = new LoggerRuntime();
        // Create an instrumented which modifies the bytecode of a class to enable coverage collection.
        Instrumenter instrumenter = new Instrumenter(runtime);
        // Create a data structure to hold runtime data (e.g., which lines of code were executed).
        RuntimeData data = new RuntimeData();
        // Start the runtime with the provided data structure.
        runtime.startup(data);


        // Instrument the original bytecode of the test class.
        final byte[] instrumented = instrumenter.instrument(
                getTargetClass(testClass),
                testClass.getName());
        // Load the instrumented class into the JVM using a custom class loader.
        final Class<?> instrumentedClass = new CustomClassLoader().defineClass(testClass.getName(), instrumented);



        // Invoke the method named "testMethodWithZero" on the instrumented class. Adjustments might be needed for other method names.
        instrumentedClass.getMethod("methodA", int.class).invoke(instrumentedClass.newInstance(), 5);




        // Create structures to hold the execution data and session information.
        ExecutionDataStore executionData = new ExecutionDataStore();
        SessionInfoStore sessionInfos = new SessionInfoStore();
        // Collect the data from the runtime.
        data.collect(executionData, sessionInfos, false);
        // Shutdown the runtime now that we've collected all needed data.
        runtime.shutdown();



        // Create a report visitor. The exact type and configuration will depend on how the createReportVisitor() method is implemented.
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        final IReportVisitor visitor = createReportVisitor(baos);
        // Start the report with session information and execution data.
        visitor.visitInfo(sessionInfos.getInfos(), executionData.getContents());
        // Analyze the structure of the class and add its coverage information to the report.
        final CoverageBuilder coverageBuilder = analyzeStructure(testClass, executionData);
        // Here we're assuming the source files are located in the provided directory. Adjust path accordingly.
        visitor.visitBundle(coverageBuilder.getBundle(testClass.getName()), new DirectorySourceFileLocator(
                new File("/Users/shifatsahariar/Downloads/java/iPatchValidator"), "utf-8", 4));
        // End the report generation.
        visitor.visitEnd();


        // This assumes the report visitor writes to a ByteArrayOutputStream. The report is returned as a string in XML format.
        return baos.toString(StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        try {
            String reportXml = generateCoverageReport(classA.class);

            // Print the XML report to console:
            System.out.println(reportXml);

            // Optionally, you can write the report to a file:
            try (FileWriter writer = new FileWriter("coverage_report.xml")) {
                writer.write(reportXml);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
