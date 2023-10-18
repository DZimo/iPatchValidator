package org.passau.Jacoco;

import org.jacoco.core.analysis.Analyzer;
import org.jacoco.core.analysis.CoverageBuilder;
import org.jacoco.core.data.ExecutionDataStore;
import org.jacoco.report.IMultiReportOutput;
import org.jacoco.report.IReportVisitor;
import org.jacoco.report.xml.XMLFormatter;

import java.io.*;
import java.util.Objects;

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

}
