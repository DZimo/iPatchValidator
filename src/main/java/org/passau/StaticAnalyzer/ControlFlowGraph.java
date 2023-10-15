package org.passau.StaticAnalyzer;
/*
import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
 */

import org.passau.Writer.IPatchWriter;
import sootup.core.graph.StmtGraph;
import sootup.core.jimple.common.stmt.Stmt;
import sootup.core.model.SootClass;
import sootup.java.core.JavaSootClassSource;

import java.util.List;

public class ControlFlowGraph {

  private ControlFlowGraph controlFlowGraph; // Class that build CFG

  private StmtGraph statementGraph; // Statement graph that contains predecessors and successors

  private List<Stmt> allStatements; // All retrieved statements

  private SootClass<JavaSootClassSource> sootClass;

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

  public void printTheControlFlowGraph(IPatchWriter iPatchWriter)
  {
    System.out.println("====== Start ======");
    System.out.println("====== JIMPL CODE ======");

    iPatchWriter.write("====== Start ======", false);
    iPatchWriter.write("====== JIMPL CODE ======", false);

    System.out.println(statementGraph);
    iPatchWriter.write(statementGraph, false);

    System.out.println("====== GRAPH DEPENDENCE ======");
    iPatchWriter.write("====== GRAPH DEPENDENCE ======", false);

    for (int i = 0; i < allStatements.size(); i++) {
      Stmt statement = allStatements.get(i);
      System.out.println("V" + i + ": " + "Successors : " + statementGraph.getAllSuccessors(statement));
      iPatchWriter.write("V" + i + ": " + "Successors : " + statementGraph.getAllSuccessors(statement), false);
    }

    iPatchWriter.write("====== End ======", false);
    System.out.println("====== End ======");
  }

  public void printPackagName (String packageName, IPatchWriter iPatchWriter)
  {
    System.out.println("WORKING ON THIS PACKAGE :" + packageName + "............");
    iPatchWriter.write("WORKING ON THIS PACKAGE :" + packageName + "............" , false);

  }

  public void printMethodName (String methodName, IPatchWriter iPatchWriter)
  {
    System.out.println("WORKING ON THIS METHOD :" + methodName + "............");
    iPatchWriter.write("WORKING ON THIS METHOD :" + methodName + "............" , false);

  }
}
