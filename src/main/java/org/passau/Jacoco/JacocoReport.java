package org.passau.Jacoco;
import org.jacoco.core.analysis.*;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.core.data.SessionInfoStore;
import org.jacoco.core.instr.Instrumenter;
import org.jacoco.core.runtime.IRuntime;
import org.jacoco.core.runtime.LoggerRuntime;
import org.jacoco.core.runtime.RuntimeData;
import org.jacoco.report.*;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.passau.Jacoco.HelperMethods.*;

public class JacocoReport {
    static String sourceDirectory = System.getenv("iPatchValidator");
    /**
     * 1. Initializing JaCoCo runtime and data structures:
     * 2. Instrument the provided test class to enable coverage collection:
     * 3. Execute the instrumented class:
     * 4. Collect coverage data after execution:
     * 5. Generate the coverage report:
     * 6. Return the generated report:
     *
     *
     *
     .. +++++++++++++++++++++++++++++++++++++++ IMPORTANT +++++++++++++++++++++++++++++++++++++++
// >>>>>>>>>>>>>>>>>>>>>>> FOR NOW WE ARE NOT TAKING THE METHOD <<<
     WE ARE DIRECTLY TAKING THE TEST CASES ON WHOLE CLASS TO CHECK WHICH LINES ARE COVERING IN THE WHOLE CLASS ></>
     */
    public static List<String> generateCoverageReports(Class<?> originalClass, String methodName, Class<?> providedTestClass) throws Exception {
        List<String> reports = new ArrayList<>();

        // Discover test methods from the provided test class
        List<Method> testMethods = Arrays.stream(providedTestClass.getMethods())
                .filter(m -> m.isAnnotationPresent(Test.class)).toList();


        for (Method testMethod : testMethods) {
            // Freshly initialize the runtime and Instrumented for each test method
            IRuntime runtime = new LoggerRuntime();
            Instrumenter instrumenter = new Instrumenter(runtime);

            // Freshly create RuntimeData for each test method
            RuntimeData data = new RuntimeData();
            runtime.startup(data);

            final byte[] instrumented = instrumenter.instrument(
                    getTargetClass(originalClass),
                    originalClass.getName());

            CustomClassLoader customClassLoader = new CustomClassLoader();
            final Class<?> instrumentedClass = customClassLoader.defineClass(originalClass.getName(), instrumented);

            final byte[] testClassBytes = getTargetClass(providedTestClass);
            Class<?> loadedTestClass = customClassLoader.defineClass(providedTestClass.getName(), testClassBytes);

            // Create an instance of the loaded test class and invoke the current test method
            Object testInstance = loadedTestClass.getDeclaredConstructor().newInstance();
            Method loadedTestMethod = loadedTestClass.getMethod(testMethod.getName());
            loadedTestMethod.setAccessible(true);
            loadedTestMethod.invoke(testInstance);

            // Collect coverage data
            ExecutionDataStore executionData = new ExecutionDataStore();
            SessionInfoStore sessionInfos = new SessionInfoStore();
            data.collect(executionData, sessionInfos, false);
            runtime.shutdown();

            // Generate coverage report
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final IReportVisitor visitor = createReportVisitor(baos);
            visitor.visitInfo(sessionInfos.getInfos(), executionData.getContents());
            final CoverageBuilder coverageBuilder = analyzeStructure(originalClass, executionData);

            if (sourceDirectory != null) {
                visitor.visitBundle(coverageBuilder.getBundle(loadedTestClass.getName()), new DirectorySourceFileLocator(new File(sourceDirectory), "utf-8", 4));
            } else {
                System.err.println("The 'iPatchValidator' environment variable is not set.");
            }
            visitor.visitEnd();
            reports.add(baos.toString(StandardCharsets.UTF_8));
        }

        return reports;
    }



    public static void main(String[] args) {
        // Generate Report for each test cases for the Class
        // will record lines for each test cases from the class
        generateAndSaveCoverageReports(sourceDirectory);

    }




}
