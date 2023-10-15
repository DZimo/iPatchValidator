package org.passau.PatchExamples;

import org.passau.SourceCode.Packet;

public class PatchDelete {
    public void method ( int a )
    {
        Packet packet = new Packet(a);
        int valueInt = 1;
        float valueFloat = 1.0f;
        // Fixed null pointer by delete
        packet.value = a;
    }
}
