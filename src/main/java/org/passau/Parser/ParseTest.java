package org.passau.Parser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParseTest {
    static String ClassName ;
    // Test MethodExtractor functionality
    public static void main(String[] args) throws Exception {
        ClassParser classParser = new ClassParser();
        // make a loop for the set of classes
        // so for each class if iterate over the given path and store all methods infos as MethodModel to the List

        FilePathFinder filePathFinder = new FilePathFinder();
        /**
         * We Have to Change this FOLDER_PATH according our need.
         */
        String FOLDER_PATH = "src/main/java/org/passau/Parser/Test";
        List<String> classPaths = filePathFinder.findJavaFilePaths(FOLDER_PATH);

        for (String filePath : classPaths){
            List<MethodModel> methods = classParser.extractMethods(filePath);

           ClassName =   ClassParser.extractClassName(filePath);;
            ClassModel classModel = new ClassModel(methods,ClassName);
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
