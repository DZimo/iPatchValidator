package org.passau.StaticAnalyzer;

public class ControlFlowGraph {

    String scriptCode;

    public ControlFlowGraph (String scriptCode){
        this.scriptCode=scriptCode;
        CFGbuilder(this.scriptCode);
    }

    public void CFGbuilder (String scriptCode) {

    }
}
