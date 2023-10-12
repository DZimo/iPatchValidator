package org.passau.Parser;

import java.util.List;

public class ClassModel {
    private final List<MethodModel> methodModelList;
    private final String ClassName;

    public ClassModel(List<MethodModel> methodModelList, String className) {

        this.methodModelList = methodModelList;
        ClassName = className;
    }

    public List<MethodModel> getMethodModelList() {
        return methodModelList;
    }

    public String getClassName() {
        return ClassName;
    }

    @Override
    public String toString() {
        return "ClassModel{" +
                "methodModelList=" + methodModelList +
                ", ClassName='" + ClassName + '\'' +
                '}';
    }
}
