package org.passau.Parser.Test;

public class TestClass {


        public void methodOne() {
            System.out.println("Executing methodOne with no parameters");
        }

        public String methodTwo(String name, int age) {
            return "Name: " + name + ", Age: " + age;
        }

        public void methodThree(int[] ids, double... values) {
            System.out.print("IDs: ");
            for (int id : ids) {
                System.out.print(id + " ");
            }

            System.out.println();

            System.out.print("Values: ");
            for (double val : values) {
                System.out.print(val + " ");
            }

            System.out.println();
        }
    public String methodFour(String name, double age) {
        return "Name: " + name + ", Age: " + age;
    }

    }


