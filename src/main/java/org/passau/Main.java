package org.passau;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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

    private static String classToBuildName; // Class that we want to build CFG for

    private static String methodToBuildName; // Name of method we want to build

    private static String typeToBuildName; // Type of method we want to build

    private static ControlFlowGraph controlFlowGraph; // Class that build CFG

    private static StmtGraph statementGraph; // Statement graph that contains predecessors and successors

    private static List<Stmt> allStatements; // All retrieved statements

    private static SootClass<JavaSootClassSource> sootClass; // The class that we want to build CFG for


    // Constructor
    public Main(String className, String methodName, String typeName) {
        constructMethodInformation(className, methodName, typeName);
        initializeVariables(); // Constructor for main to initialize variables
    }

    public void constructMethodInformation(String classToBuildName, String methodToBuildName, String typeToBuildName){
        this.classToBuildName = classToBuildName;
        this.methodToBuildName= methodToBuildName;
        this.typeToBuildName = typeToBuildName;
    }

    private void initializeVariables() {

        // Retrieve the input location path from the environment variable
        String inputLocationPath = System.getenv(INPUT_LOCATION_ENV);
        validatePath(inputLocationPath);

        AnalysisInputLocation<JavaSootClass> inputLocation = new JavaClassPathAnalysisInputLocation(inputLocationPath);  // Input for binary code
        JavaLanguage language = new JavaLanguage(17);
        Project project =  JavaProject.builder(language).addInputLocation(inputLocation).build();

        ClassType classType = project.getIdentifierFactory().getClassType(classToBuildName);  // Set the class we want to work on

        MethodSignature methodSignature =
                project.getIdentifierFactory().
                        getMethodSignature(methodToBuildName, classToBuildName, typeToBuildName, Collections.singletonList("int")); // Set the method we want to work on

        View view = project.createView(); // Create a view for the created project

        sootClass = (SootClass<JavaSootClassSource>) view.getClass(classType).get(); // Get the class itself
        Optional<? extends SootMethod> opt = sootClass.getMethod(methodSignature.getSubSignature());
        SootMethod method = opt.get();
        allStatements = method.getBody().getStmts();
        statementGraph = method.getBody().getStmtGraph();
        controlFlowGraph = new ControlFlowGraph(controlFlowGraph, statementGraph, allStatements, sootClass);  // Class that build CFG
    }

    private void validatePath(String path) {
        File file = new File(path);
        if (path == null) {
            throw new IllegalStateException("Environment variable " + INPUT_LOCATION_ENV + " is not set.");
        }
        if (!file.exists()) {
            throw new IllegalStateException("iPatchValidator is set to a wrong path Shifat :D");
        }
    }

    public static void main(String[] args) {

        // Build CFG for source code
        Main mainInstanceSourceCode = new Main("org.passau.CodeExamples.SourceCodeNullPointer", "method", "void");  // This will initialize the variables
        MutableStmtGraph graph = new MutableBlockStmtGraph();
        graph.setStartingStmt(statementGraph.getStartingStmt());
        Iterator<Stmt> iterator = statementGraph.iterator();
        System.out.println("CFG for SOURCE CODE : " + sootClass.getName());
        controlFlowGraph.printTheControlFlowGraph(); // Print the CFG


        // Build CFG for patch code
        Main mainInstancePatchCode = new Main("org.passau.CodeExamples.PatchIFcondition", "method", "void");  // This will initialize the variables
        graph.setStartingStmt(statementGraph.getStartingStmt());
        System.out.println("CFG for PATCH CODE : " + sootClass.getName());
        controlFlowGraph.printTheControlFlowGraph(); // Print the CFG
  }
}
