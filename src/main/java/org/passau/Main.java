package org.passau;

import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import sootup.analysis.interprocedural.icfg.*;
import sootup.callgraph.CallGraph;
import sootup.callgraph.CallGraphAlgorithm;
import sootup.callgraph.ClassHierarchyAnalysisAlgorithm;
import sootup.core.Project;
import sootup.core.graph.*;
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

public class Main {
    // PATH TO JAVA SOURCE CODE
    private static final String INPUT_LOCATION_ENV = "iPatchValidator"; // Please add your target/classes to path with the name of this variable ( // compiled ones )

    private static final String classToBuildName = "org.passau.CodeExamples.SourceCodeSimple"; // Class that we want to build CFG for

    private static final String methodToBuildName = "method"; // Name of method we want to build

    private static final String typeToBuildName = "void"; // Type of method we want to build


    public static void main(String[] args) {
        // Retrieve the input location path from the environment variable
        String inputLocationPath = System.getenv(INPUT_LOCATION_ENV);
        File file = new File(inputLocationPath);

        // Check if the environment variable is set
        if (inputLocationPath == null) {
            throw new IllegalStateException("Environment variable " + INPUT_LOCATION_ENV + " is not set.");

        }
        if (!file.exists()) {
            throw new IllegalStateException("iPatchValidator is set to a wrong path Shifat :D");
        }

        AnalysisInputLocation<JavaSootClass> inputLocation = new JavaClassPathAnalysisInputLocation(inputLocationPath); // Input for binary code
        JavaLanguage language = new JavaLanguage(17);
        Project project =  JavaProject.builder(language).addInputLocation(inputLocation).build();

        ClassType classType =
                project.getIdentifierFactory().getClassType(classToBuildName); // Set the class we want to work on

        MethodSignature methodSignature = project.getIdentifierFactory().getMethodSignature( methodToBuildName , classToBuildName, typeToBuildName, Collections.singletonList("int")); // Set the method we want to work on

        View view = project.createView();// Create a view for the created project


        SootClass<JavaSootClassSource> sootClass = (SootClass<JavaSootClassSource>) view.getClass(classType).get(); // Get the class itself

        Optional<? extends SootMethod> opt = sootClass.getMethod(methodSignature.getSubSignature());
        SootMethod method = opt.get();
        List<Stmt> allStatements = method.getBody().getStmts();
        StmtGraph statementGraph = method.getBody().getStmtGraph();

        MutableStmtGraph graph = new MutableBlockStmtGraph();
        graph.setStartingStmt(statementGraph.getStartingStmt());


        Iterator<Stmt> iterator = statementGraph.iterator();

        int indexOfNode = 0;
        while(iterator.hasNext()){
            graph.addNode(iterator.next());
        }

        System.out.println("====== Start ======");
        System.out.println("====== JIMPL CODE ======");

        System.out.println(statementGraph);

        System.out.println("====== GRAPH DEPENDENCE ======");

        for (int i = 0; i < allStatements.size(); i++) {
            Stmt statement = allStatements.get(i);
            System.out.println("V" + i + ": " + "Successors : " + statementGraph.getAllSuccessors(statement));
        }

        System.out.println("====== End ======");
        CallGraphAlgorithm cha =
                new ClassHierarchyAnalysisAlgorithm(view);

        CallGraph cg =
                cha.initialize(Collections.singletonList(methodSignature));

        System.out.println(allStatements);

        Body body = method.getBody();

        Stmt stmt1, stmt2, stmt3, stmt4, stmt5;
        MutableStmtGraph controlFlowGraph = new MutableBlockStmtGraph();
        int i = 0;
        for(Stmt statement:allStatements)
        {
            if (i==0){
                graph.setStartingStmt(statement);
            }
            else{
           //     if(statement.)
                graph.addNode(statement);
            }
        }
       // graph.addNode(stmt2);


        //CalleeMethodSignature abs = new CalleeMethodSignature(methodSignature, cg. , method.getBody().getThisStmt()));

  }
}
