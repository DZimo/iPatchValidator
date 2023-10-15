package org.passau.PatchExamples;

import org.passau.SourceCode.Packet;

public class PatchIFcondition {
    public void method ( int a )
    {
        Packet packet = new Packet(a);
        int valueInt = 1;
        float valueFloat = 1.0f;
        if ( a == 0 )
        {
            valueInt = -1;
            valueFloat = -1.0f;
        }

        else {
            valueInt = 2;
            valueFloat = 2.0f;
        }
        if(packet != null )
        {
            packet.value = a; // Fixed null pointer bug
        }
    }
}
