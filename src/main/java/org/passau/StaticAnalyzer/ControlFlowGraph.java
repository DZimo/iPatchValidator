package org.passau.StaticAnalyzer;
/*
import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
 */

import sootup.core.graph.StmtGraph;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.SootClass;
import sootup.java.core.JavaSootClassSource;

import java.util.List;

public class ControlFlowGraph {

  private static ControlFlowGraph controlFlowGraph; // Class that build CFG

  private static StmtGraph statementGraph; // Statement graph that contains predecessors and successors

  private static List<Stmt> allStatements; // All retrieved statements

  private static SootClass<JavaSootClassSource> sootClass;

  String scriptCode;

  // private ExceptionalUnitGraph cfg;

  public ControlFlowGraph(ControlFlowGraph controlFlowGraph, StmtGraph statementGraph, List<Stmt> allStatements, SootClass<JavaSootClassSource> sootClass) {
    this.controlFlowGraph = controlFlowGraph;
    this.statementGraph = statementGraph;
    this.allStatements = allStatements;
    this.sootClass= sootClass;
  }

  /*public UnitGraph getCfg() {
      return cfg;
  }*/

  public void buildCFG(String className, String methodName, String inputPath) {
    /*
           Scene.v().setSootClassPath(inputPath);
           SootClass sootClass = Scene.v().loadClassAndSupport(className);
           sootClass.setApplicationClass();
           Scene.v().setMainClass(sootClass);
           SootMethod method = sootClass.getMethodByName(methodName);
           Body body = method.retrieveActiveBody();

           cfg = new ExceptionalUnitGraph(body);

    */
  }

  public void printTheControlFlowGraph()
  {
    System.out.println("====== Start ======");
    System.out.println("====== JIMPL CODE ======");

    System.out.println(statementGraph);

    System.out.println("====== GRAPH DEPENDENCE ======");

    for (int i = 0; i < allStatements.size(); i++) {
      Stmt statement = allStatements.get(i);
      System.out.println("V" + i + ": " + "Successors : " + statementGraph.getAllSuccessors(statement));
    }

    System.out.println("====== End ======");
  }
}
