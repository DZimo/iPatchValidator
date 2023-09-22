package org.passau.Patcher;

import org.passau.StaticAnalyzer.ControlFlowGraph;

public class PatchCode {
    String patchScript;
    ControlFlowGraph controlFlowGraph;

    public PatchCode (String patchScript) {
        this.patchScript=patchScript;
        this.controlFlowGraph = new ControlFlowGraph(patchScript);

    }

}
