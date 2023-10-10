package org.passau;

import org.passau.CodeExamples.SourceCodeNullPointer;
import org.passau.SourceCode.Packet;
import org.passau.StaticAnalyzer.ControlFlowGraph;
import sootup.callgraph.CallGraph;
import sootup.callgraph.CallGraphAlgorithm;
import sootup.callgraph.ClassHierarchyAnalysisAlgorithm;
import sootup.core.Project;
import sootup.core.graph.StmtGraph;
import sootup.core.inputlocation.AnalysisInputLocation;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.Body;
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
import sootup.java.core.views.JavaView;
import sootup.analysis.interprocedural.icfg.*;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class Main {

    // PATH TO JAVA SOURCE CODE
    private static final String INPUT_LOCATION_ENV = "iPatchValidator"; // Please add your target/classes to path with the name of this variable ( compiled ones )

    public static void main(String[] args) {
        // Retrieve the input location path from the environment variable
        String inputLocationPath = System.getenv(INPUT_LOCATION_ENV);
        File file = new File(inputLocationPath);

        // Check if the environment variable is set
        if (inputLocationPath == null) {
            throw new IllegalStateException("Environment variable " + INPUT_LOCATION_ENV + " is not set.");

        }
        if (!file.exists()) {
            throw new IllegalStateException("iPatchValidator is set to a wrong path Shifat.");
        }

        AnalysisInputLocation<JavaSootClass> inputLocation = new JavaClassPathAnalysisInputLocation(inputLocationPath); // Input for binary code
        JavaLanguage language = new JavaLanguage(17);
        Project project =  JavaProject.builder(language).addInputLocation(inputLocation).build();

        ClassType classType =
                project.getIdentifierFactory().getClassType("org.passau.CodeExamples.SourceCodeNullPointer"); // Set the class we want to work on

        MethodSignature methodSignature = project.getIdentifierFactory().getMethodSignature( "method", "org.passau.CodeExamples.SourceCodeNullPointer", "void", Collections.singletonList("int")); // Set the method we want to work on

        View view = project.createOnDemandView();// Create a view for the created project


        SootClass<JavaSootClassSource> sootClass = (SootClass<JavaSootClassSource>) view.getClass(classType).get(); // Get the class itself

        Optional<? extends SootMethod> opt = sootClass.getMethod(methodSignature.getSubSignature());
        SootMethod method = opt.get();
        List<Stmt> allStatements = method.getBody().getStmts();
        StmtGraph statementGraph = method.getBody().getStmtGraph();

        CallGraphAlgorithm cha =
                new ClassHierarchyAnalysisAlgorithm(view, view.getTypeHierarchy());

        CallGraph cg =
                cha.initialize(Collections.singletonList(methodSignature));

        System.out.println(allStatements);

        Body body = method.getBody();

        //CalleeMethodSignature abs = new CalleeMethodSignature(methodSignature, cg. , method.getBody().getThisStmt()));


        // Create a CFG for the method
        //UnitGraph graph = new BriefUnitGraph(body);


        System.out.println(cg);


    }


}