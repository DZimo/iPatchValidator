package org.passau.Parser;

import java.util.List;

public class ParseTest {
    // Test MethodExtractor functionality
    public static void main(String[] args) throws Exception {
        ClassParser methodExtractor = new ClassParser();
        String filePath = "src/main/java/org/passau/Parser/Test/TestClass.java"; // Specify your file path

        List<MethodModel> methods = methodExtractor.extractMethods(filePath);

        // Print extracted method info
        for (MethodModel method : methods) {
            System.out.println("Method: " + method.getMethodName());
            System.out.println("Return Type: " + method.getMethodReturnType());
            System.out.println("Parameters: " + method.getListOfParamType());
            System.out.println("-------------------");
        }
    }
}
