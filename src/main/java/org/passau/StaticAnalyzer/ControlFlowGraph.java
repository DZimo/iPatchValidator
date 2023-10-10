package org.passau.StaticAnalyzer;
/*
import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;
 */

public class ControlFlowGraph {

  String scriptCode;

  // private ExceptionalUnitGraph cfg;

  public ControlFlowGraph() {}

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
}
