package org.passau.Parser;

import java.util.List;

public class MethodModel {
    private final String MethodName;
    private final String MethodReturnType;
    private final List<String> ListOfParamType;

    public MethodModel(String methodName, String methodReturnType, List<String> listOfParamType) {
        MethodName = methodName;
        MethodReturnType = methodReturnType;
        ListOfParamType = listOfParamType;
    }

    public String getMethodName() {
        return MethodName;
    }

    public String getMethodReturnType() {
        return MethodReturnType;
    }

    public List<String> getListOfParamType() {
        return ListOfParamType;
    }

    @Override
    public String toString() {
        return "MethodModel{" +
                "MethodName='" + MethodName + '\'' +
                ", MethodReturnType='" + MethodReturnType + '\'' +
                ", ListOfParamType=" + ListOfParamType +
                '}';
    }
}
