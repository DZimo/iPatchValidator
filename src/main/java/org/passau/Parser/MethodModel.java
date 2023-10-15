package org.passau.Parser;

import java.util.List;

public class MethodModel {
    private final String methodName;
    private final String methodReturnType;
    private final List<String> listOfParamType;

    public MethodModel(String methodName, String methodReturnType, List<String> listOfParamType) {
        this.methodName = methodName;
        this.methodReturnType = methodReturnType;
        this.listOfParamType = listOfParamType;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public String getMethodReturnType() {
        return this.methodReturnType;
    }

    public List<String> getListOfParamType() {
        return this.listOfParamType;
    }

    @Override
    public String toString() {
        return "MethodModel{" +
                "MethodName='" + this.methodName + '\'' +
                ", MethodReturnType='" + this.methodReturnType + '\'' +
                ", ListOfParamType=" + this.listOfParamType +
                '}';
    }
}
