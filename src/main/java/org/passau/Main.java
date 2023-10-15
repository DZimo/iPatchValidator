package org.passau;

import java.io.IOException;
import java.util.*;

import org.passau.Parser.ClassModel;
import org.passau.Parser.ClassParser;
import org.passau.Parser.FilePathFinder;
import org.passau.Parser.MethodModel;
import org.passau.SootPathFinder.SootPathSetter;
import org.passau.StaticAnalyzer.ControlFlowGraph;
import org.passau.Writer.IPatchWriter;
import sootup.core.Project;
import sootup.core.graph.*;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.SootClass;
import sootup.core.model.SootMethod;
import sootup.core.signatures.MethodSignature;
import sootup.core.types.ClassType;
import sootup.core.views.View;
import sootup.java.bytecode.inputlocation.JavaClassPathAnalysisInputLocation;
import sootup.java.core.JavaProject;
import sootup.java.core.JavaSootClass;
import sootup.java.core.JavaSootClassSource;
import sootup.java.core.language.JavaLanguage;

public class Main implements Runnable {
    // PATH TO JAVA SOURCE CODE
    private static final String INPUT_LOCATION_ENV = "iPatchValidator"; // Please add your target/classes to path with the name of this variable ( // compiled ones )

    private static String INPUT_LOCATION_PATH; // The path that we will get from the INPUT_LOCATION_ENV

    public String logName; // The name of the log file

    //private static final String pathToClasses = "/src/main/java/org/";

    private String pathToClasses;

    private String classToBuildName; // Class that we want to build CFG for

    private String methodToBuildName; // Name of method we want to build

    private List<String> paramToBuildType; // Types of all parameters we want to build

    private String typeToBuildName; // Type of method we want to build

    private ControlFlowGraph controlFlowGraph; // Class that build CFG

    private StmtGraph statementGraph; // Statement graph that contains predecessors and successors

    private List<Stmt> allStatements; // All retrieved statements

    private SootClass<JavaSootClassSource> sootClass; // The class that we want to build CFG for


    /**
     * Main Constructor
     * @param className the class we want to build CFG for
     * @param methodName the method we want to build CFG for
     * @param typeName the type of method we want to build CFG for
     * @param typeParameters the list of type of parameters we want to build CFG for
     */

    public Main(String className, String methodName, String typeName, List<String> typeParameters) {
        constructMethodInformation(className, methodName, typeName, typeParameters);
    }

    public Main(String pathToSourceCode, String LogName) {
        this.pathToClasses = pathToSourceCode;
        this.logName = LogName;
    }


    /**
     * Constructor for main to initialize variables that we will use to build CFG of Sootup
     */
    public void constructMethodInformation(String classToBuildName, String methodToBuildName, String typeToBuildName, List<String> typeParameters){
        this.classToBuildName = classToBuildName;
        this.methodToBuildName = methodToBuildName;
        this.typeToBuildName = typeToBuildName;
        this.paramToBuildType = typeParameters;
    }

    /**
     * Build Graph for SOOTUP
     */

    private boolean buildGraph() {
       // INPUT_LOCATION_PATH ="/Users/shifatsahariar/Downloads/java/iPatchValidator/target/classes/spoon/compiler/builder/AnnotationProcessingOptions.class";
        if(typeToBuildName.equals("T"))
        {
            // WE HAVE TO DO SOMETHING TO CHANGE THE NAME OF THE TYPE AS IT IS GENERIC
            //typeToBuildName = "";
        }
        AnalysisInputLocation<JavaSootClass> inputLocation = new JavaClassPathAnalysisInputLocation(INPUT_LOCATION_PATH);  // Input for binary code
        JavaLanguage language = new JavaLanguage(17);
        Project project =
                JavaProject.builder(language)
                        .addInputLocation(inputLocation).build();

        ClassType classType = project.getIdentifierFactory().getClassType(classToBuildName);  // Set the class we want to work on
        //paramToBuildType.stream().toList()
        MethodSignature methodSignature =
                project.getIdentifierFactory().
                        getMethodSignature(methodToBuildName, classToBuildName, typeToBuildName, paramToBuildType);  // Define the method we want to work on

        View view = project.createView(); // Create a view for the created project
        Optional<JavaSootClass> optClass = view.getClass(classType);

        if (optClass.isPresent()) {
            sootClass = optClass.get();
            /**
             * OUR CURRENT ISSUE STARTS HERE
             */
            Optional<SootMethod> opt = (Optional<SootMethod>) view.getMethod(methodSignature);

            if(opt.isPresent()){
                SootMethod method = opt.get();
                if(method.isConcrete())
                {
                    allStatements = method.getBody().getStmts();
                    statementGraph = method.getBody().getStmtGraph();
                    controlFlowGraph = new ControlFlowGraph(controlFlowGraph, statementGraph, allStatements, sootClass);// Class that build CFG
                }
                else {
                    // IF METHOD IS NOT CONCRETE THEN WE SKIP IT
                    return false;
                }
            }
            Optional<? extends SootMethod> optMethod = sootClass.getMethod(methodSignature.getSubSignature());
            // HERE WE ALREADY GETTING NO METHOD
            if (optMethod.isPresent() && ( allStatements == null || statementGraph == null || controlFlowGraph == null) ) { // We try to get them again if null
                SootMethod method = optMethod.get();
                if(method.isConcrete())
                {
                    allStatements = method.getBody().getStmts();
                    statementGraph = method.getBody().getStmtGraph();
                    controlFlowGraph = new ControlFlowGraph(controlFlowGraph, statementGraph, allStatements, sootClass);// Class that build CFG
                }
                else {
                    // IF METHOD IS NOT CONCRETE THEN WE SKIP IT
                    return false;
                }
            }
        }
        else {
           // System.err.println("Class not found: " + classType.getClassName());
            return false; // Class not found
        }
        return true;
    }

    public void run () {
        try{
            MutableStmtGraph graph = new MutableBlockStmtGraph();
            IPatchWriter iPatchWriter = new IPatchWriter(logName);
            SootPathSetter sootPathSetter = new SootPathSetter();  // We first set the path and then validate it
            INPUT_LOCATION_PATH = SootPathSetter.INPUT_LOCATION_PATH;
            String lastClassName = null;
            ClassParser classParser = new ClassParser();
            FilePathFinder filePathFinder = new FilePathFinder();
            List<String> classPaths = filePathFinder.findJavaFilePaths(INPUT_LOCATION_PATH + pathToClasses);
            for (String filePath : classPaths) {
                List<MethodModel> methods = classParser.extractMethods(filePath);
                classToBuildName = ClassParser.extractPackageName(filePath) + "." + ClassParser.extractClassNameFromPath(filePath); // We concatenate package name with class name
                if (ClassParser.extractPackageName(filePath) != lastClassName && controlFlowGraph!=null)
                {
                    lastClassName = ClassParser.extractPackageName(filePath); // We only print the package when it changes
                    controlFlowGraph.printPackagName(lastClassName, iPatchWriter);
                }
                ClassModel classModel = new ClassModel(methods, classToBuildName);
                for (MethodModel method : methods) {
                    methodToBuildName = method.getMethodName() ;
                    typeToBuildName = method.getMethodReturnType();
                    paramToBuildType = method.getListOfParamType();
                    constructMethodInformation("target.classes." + classToBuildName , methodToBuildName, typeToBuildName, paramToBuildType);  // This will initialize the variables
                    if(!buildGraph())
                    {
                        continue; // Skip to next method if there is no graph
                    }
                    if (statementGraph != null) {
                        graph.setStartingStmt(statementGraph.getStartingStmt());
                        Iterator<Stmt> iterator = statementGraph.iterator();
                        System.out.println("CFG for SOURCE CODE : " + sootClass.getName());
                        controlFlowGraph.printTheControlFlowGraph(iPatchWriter); // Print the CFG
                        controlFlowGraph.printMethodName(methodToBuildName, iPatchWriter);
                    }
//                else {
//                    System.err.println("Error: statementGraph is null for " + methodToBuildName + " in class " + classToBuildName);
//                }

                }
            }
            System.out.println("WORK DONE!");
            //iPatchWriter.closeFiles();
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main (String[] args) {
        try {

            Main mainInstanceOriginalPassau = new Main("/src/main/java/org/passau/CodeExamples","OriginalCodeLogPassau"); // Instance for the original code
            Thread t1 = new Thread(mainInstanceOriginalPassau, "originalCodePassau");

            Main mainInstancePatchedPassau = new Main("/src/main/java/org/passau/CodeExamples","PatchedlCodeLogPassau"); // Instance for the original code
            Thread t2 = new Thread(mainInstancePatchedPassau, "patchedCodePassau");

            Main mainInstanceOriginaldSpoon = new Main("/src/main/java/spoon","SourceCodeLogSpoon"); // Instance for the patched code
            Thread t3 = new Thread(mainInstanceOriginaldSpoon, "originalCodeSpoon");

            Main mainInstancePatchedSpoon = new Main("/src/main/java/spoon","PatchedCodeLogSpoon"); // Instance for the patched code
            Thread t4 = new Thread(mainInstancePatchedSpoon, "patchedCodeSpoon");

            t1.start(); // Start Original code passau thread
            t2.start(); // Start Patched code passau thread

            t3.start(); // Start Original code spoon thread
            t4.start(); // Start Patched code spoon thread

            t1.join();
            t2.join();

            t3.join();
            t4.join();
        } catch (InterruptedException e) {
            System.out.println("Error with threads:" + e.getMessage());
        }
    }


}
