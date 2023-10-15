package org.passau.Parser;

import java.util.List;

public class ClassModel {
    private final List<MethodModel> methodModelList;
    private final String className;

    public ClassModel(List<MethodModel> methodModelList, String className) {

        this.methodModelList = methodModelList;
        this.className = className;
    }

    public List<MethodModel> getMethodModelList() {
        return this.methodModelList;
    }

    public String getClassName() {
        return this.className;
    }

    @Override
    public String toString() {
        return "ClassModel{" +
                "methodModelList=" + this.methodModelList +
                ", ClassName='" + this.className + '\'' +
                '}';
    }
}
