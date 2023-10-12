package org.passau.Parser;

import java.util.ArrayList;
import java.util.List;

public class ParseTest {
    static String className ;
    // Test MethodExtractor functionality
    public static void main(String[] args) throws Exception {
        ClassParser classParser = new ClassParser();
        // make a loop for the set of classes
        // so for each class if iterate over the given path and store all methods infos as MethodModel to the List
        /**
         *          // go to a folder
         *         // take each filepath as item
         *         // add that filepath in this list
         */
        List<String>  classPaths = new ArrayList<>();
        classPaths.add("src/main/java/org/passau/Parser/Test/TestClass.java");


        for (String filePath : classPaths){
            List<MethodModel> methods = classParser.extractMethods(filePath);

           className =   ClassParser.extractClassName(filePath);;
            ClassModel classModel = new ClassModel(methods,className);
            /**
             * Print extracted method info
             */
            for (MethodModel method : methods) {
                System.out.println("Method: " + method.getMethodName());
                System.out.println("Return Type: " + method.getMethodReturnType());
                System.out.println("Parameters: " + method.getListOfParamType());
                System.out.println("-------------------");
            }

            /**
             * Print Class Information for Each Class
             */
            System.out.println("ClassName: " + classModel.getClassName());
            System.out.println("Methods Belongs to Class " + classModel.getMethodModelList());
            System.out.println("\n");
        }





    }
}
