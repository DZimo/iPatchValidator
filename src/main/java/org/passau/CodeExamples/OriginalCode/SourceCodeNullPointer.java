package org.passau.CodeExamples.OriginalCode;

import org.passau.SourceCode.Packet;

public class SourceCodeNullPointer {
    public void method ( int a )
    {
        Packet packet = new Packet(a); // N1
        int valueInt = 1; // N2
        float valueFloat = 1.0f; // N3
        if ( a == 0 )  // N4
        {
            packet = null; // Faulty Localization that will cause Null pointer exception if (a != 0) later // N5
            valueInt = -1;
            valueFloat = -1.0f;
        }

        else {
            valueInt = 2; //N6
            valueFloat = 2.0f;
        }
        packet.value = a; // Null pointer exception if (a != 0)
    }
}
