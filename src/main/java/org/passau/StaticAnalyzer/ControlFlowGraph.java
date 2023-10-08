package org.passau.StaticAnalyzer;

import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.toolkits.graph.ExceptionalUnitGraph;
import soot.toolkits.graph.UnitGraph;

public class ControlFlowGraph {

    String scriptCode;

    /**
     *
     * @param className - source code or patched code
     *
     */
    public ControlFlowGraph (String className){
        this.scriptCode=className;
        CFGBuilder(this.scriptCode);
    }

    /**
     *
     * @param scriptCode - source code or patched code
     * @Return CFG
     */
    public UnitGraph CFGBuilder(String scriptCode) {
        String mainClass = "MainCode";
        String cp = "target/classes";
        Scene.v().setSootClassPath(cp);
        SootClass sootClass = Scene.v().loadClassAndSupport(mainClass);
        sootClass.setApplicationClass();
        Scene.v().setMainClass(sootClass);
        SootMethod method = sootClass.getMethodByName("add");
        Body body = method.retrieveActiveBody();

        return new ExceptionalUnitGraph(body);
    }
}
