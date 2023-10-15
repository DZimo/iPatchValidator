package org.passau.PatchExamples;

public class classA <T extends classB> {
    int a;

    public classA(int a) {
        this.a = a;
    }


    public T methodA(int a){
        a = 4;
        return null;
    }
}
