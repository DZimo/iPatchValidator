package org.passau.SourceCode;

public class MainCode {

    public void method ( int a )
    {
        Packet packet = new Packet(a);
        int valueInt = 1;
        float valueFloat = 1.0f;
        if ( a == 0 )
        {
            packet = null; // Faulty Localization that will cause Null pointer exception if (a != 0) later
            valueInt = -1;
            valueFloat = -1.0f;
        }

        else {
            valueInt = 2;
            valueFloat = 2.0f;
        }
        packet.value = a; // Null pointer exception if (a != 0)
    }
}
