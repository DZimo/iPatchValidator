package org.passau;

import org.passau.SourceCode.Packet;

public class Main {
    public static void main(String[] args) {
        method(1);

    }

    public static void method(int a)
    {
        Packet packet = new Packet(a);
        int valueInt = 1;
        float valueFloat = 1.0f;
        if ( a == 0 )
        {
            packet = null;
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