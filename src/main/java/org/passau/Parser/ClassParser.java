package org.passau.Parser;

import com.github.javaparser.JavaParser;
import com.github.javaparser.StaticJavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import org.objectweb.asm.MethodVisitor;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClassParser {
    /**
     * Extracts and returns method information from a specified Java file.
     *
     * @param filePath A string representing the path to the Java file.
     * @return A List of MethodModel objects containing details of methods found within the Java file.
     * @throws Exception If an issue occurs during file reading or parsing.
     */

    public List<MethodModel> extractMethods(String filePath) throws Exception {
        CompilationUnit cu;

        try (FileInputStream in = new FileInputStream(filePath)) {
            // parse the file
            cu = StaticJavaParser.parse(in);
        }

        List<MethodModel> methods = new ArrayList<>();
        // visit and print the methods names
        new MethodVisitor().visit(cu, methods);

        return methods;
    }
    /**
     * A visitor class extending the VoidVisitorAdapter to explore method declarations
     * within the Abstract Syntax Tree (AST) of a parsed Java file, utilizing the JavaParser library.
     * @see com.github.javaparser.ast.visitor.VoidVisitorAdapter
     */
    private static class MethodVisitor extends VoidVisitorAdapter<List<MethodModel>> {
        @Override
        public void visit(MethodDeclaration n, List<MethodModel> arg) {
            // Ensure that the visitation proceeds to child nodes in the AST.
            // This is crucial for traversing and visiting nested elements within the current method node.
            super.visit(n, arg);

            /*
              1. Extract Method Details
             */

            // Get the name of the method from the method declaration node.
            String methodName = n.getName().asString();

            // Get the return type of the method as a string.
            String returnType = n.getType().asString();

            // Extract the types of the parameters of the method and store them in a list.
            // Stream API is utilized to iterate over the parameters, convert their types to string, and collect them into a list.
            List<String> paramTypes = n.getParameters().stream()
                    .map(p -> p.getType().asString())
                    .collect(Collectors.toList());

            // 2. Populate and Store Method Details

            // Create a new MethodModel instance with the extracted details and
            // add this instance to the provided list 'arg', which stores the method models.
            arg.add(new MethodModel(methodName, returnType, paramTypes));
        }
    }

}
