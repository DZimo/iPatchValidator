package org.passau.CodeExamples.OriginalCode;

public class classB extends classA{

    public classB(int a) {
        super(a);
    }

    public void methodB(int a){
        classA classAinstance = new classA(0);
        classAinstance.methodA(0);
    }

}

