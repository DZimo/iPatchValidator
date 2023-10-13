package org.passau;

import java.io.File;
import java.util.*;

import org.passau.Parser.ClassModel;
import org.passau.Parser.ClassParser;
import org.passau.Parser.FilePathFinder;
import org.passau.Parser.MethodModel;
import org.passau.SootPathFinder.SootPathSetter;
import org.passau.StaticAnalyzer.ControlFlowGraph;
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

public class Main {
    // PATH TO JAVA SOURCE CODE
    private static final String INPUT_LOCATION_ENV = "iPatchValidator"; // Please add your target/classes to path with the name of this variable ( // compiled ones )

    private static String INPUT_LOCATION_PATH; // The path that we will get from the INPUT_LOCATION_ENV

    //private static final String pathToClasses = "/src/main/java/org/passau/CodeExamples";

    private static final String pathToClasses = "/SpoonLibrary/main/java/spoon";


    private static String classToBuildName; // Class that we want to build CFG for

    private static String methodToBuildName; // Name of method we want to build

    private static List<String> paramToBuildType; // Types of all parameters we want to build

    private static String typeToBuildName; // Type of method we want to build

    private static ControlFlowGraph controlFlowGraph; // Class that build CFG

    private static StmtGraph statementGraph; // Statement graph that contains predecessors and successors

    private static List<Stmt> allStatements; // All retrieved statements

    private static SootClass<JavaSootClassSource> sootClass; // The class that we want to build CFG for


    /**
     * Main Constructor
     * @param className the class we want to build CFG for
     * @param methodName the method we want to build CFG for
     * @param typeName the type of method we want to build CFG for
     * @param typeParameters the list of type of parameters we want to build CFG for
     */

    public Main(String className, String methodName, String typeName, List<String> typeParameters) {
        constructMethodInformation(className, methodName, typeName, typeParameters);
        buildGraph(); // Constructor for main to initialize variables
    }


    /**
     * Constructor for main to initialize variables that we will use to build CFG of Sootup
     */
    public void constructMethodInformation(String classToBuildName, String methodToBuildName, String typeToBuildName, List<String> typeParameters){
        this.classToBuildName = classToBuildName;
        this.methodToBuildName= methodToBuildName;
        this.typeToBuildName = typeToBuildName;
        this.paramToBuildType = typeParameters;
    }


    /**
     * Build Graph for SOOTUP
     */

    private void buildGraph() {

        AnalysisInputLocation<JavaSootClass> inputLocation = new JavaClassPathAnalysisInputLocation(INPUT_LOCATION_PATH);  // Input for binary code
        JavaLanguage language = new JavaLanguage(17);
        Project project =  JavaProject.builder(language).addInputLocation(inputLocation).build();
        ClassType classType = project.getIdentifierFactory().getClassType(classToBuildName);  // Set the class we want to work on
        MethodSignature methodSignature =
                project.getIdentifierFactory().
                        getMethodSignature(methodToBuildName, classToBuildName, typeToBuildName, paramToBuildType); // Set the method we want to work on

        View view = project.createView(); // Create a view for the created project
        sootClass = (SootClass<JavaSootClassSource>) view.getClass(classType).get(); // Get the class itself
        // Sometimes we cannot find the method ( empty )
        Optional<? extends SootMethod> opt = sootClass.getMethod(methodSignature.getSubSignature());
        SootMethod method = opt.get();
        allStatements = method.getBody().getStmts();
        statementGraph = method.getBody().getStmtGraph();
        controlFlowGraph = new ControlFlowGraph(controlFlowGraph, statementGraph, allStatements, sootClass);  // Class that build CFG
    }

    public static void main(String[] args) throws Exception {
        MutableStmtGraph graph = new MutableBlockStmtGraph();
        SootPathSetter sootPathSetter = new SootPathSetter();  // We first set the path and then validate it
        INPUT_LOCATION_PATH = sootPathSetter.INPUT_LOCATION_PATH;
        ClassParser classParser = new ClassParser();
        FilePathFinder filePathFinder = new FilePathFinder();
        List<String> classPaths = filePathFinder.findJavaFilePaths(INPUT_LOCATION_PATH + pathToClasses);
        for (String filePath : classPaths) {
            List<MethodModel> methods = classParser.extractMethods(filePath);
            classToBuildName = classParser.extractPackageName(filePath) + "." + classParser.extractClassNameFromPath(filePath); // We concatenate package name with class name
            ClassModel classModel = new ClassModel(methods, classToBuildName);
            for (MethodModel method : methods) {
                methodToBuildName = method.getMethodName() ;
                typeToBuildName = method.getMethodReturnType();
                paramToBuildType = method.getListOfParamType();
                Main mainInstanceSourceCode = new Main("target.classes." + classToBuildName , methodToBuildName, typeToBuildName, paramToBuildType);  // This will initialize the variables
                graph.setStartingStmt(statementGraph.getStartingStmt());
                Iterator<Stmt> iterator = statementGraph.iterator();
                System.out.println("CFG for SOURCE CODE : " + sootClass.getName());
                controlFlowGraph.printTheControlFlowGraph(); // Print the CFG
            }
        }
  }
}
