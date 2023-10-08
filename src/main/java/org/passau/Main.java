package org.passau;

import org.passau.SourceCode.Packet;
import org.passau.StaticAnalyzer.ControlFlowGraph;

public class Main {
    public static void main(String[] args) {
        ControlFlowGraph controlFlowGraph = new ControlFlowGraph();
        controlFlowGraph.buildCFG("org.passau.SourceCode.MainCode","method");
        System.out.println(controlFlowGraph.getCfg());



    }


}