package com.company;

import Part2.*;

public class Main {

    public static void main(String[] args) {
        TestGenericBinaryTree1();


        System.out.println();

        TestGenericBinaryTree2();
        System.out.println();
        TestGenericBinaryTree3();
        System.out.println();
        TestMultiDimensionalTree2dimension();
        System.out.println();
        TestMultiDimensionalTree3dimension();

    }


    public static void TestGenericBinaryTree1() {
        System.out.println("sample 1");
        GeneralBinaryTree<String> gbt = new GeneralBinaryTree<>();
        gbt.add("William I", "Robert");
        gbt.add("Robert", "William");
        gbt.add("William I", "William II");
        gbt.add("William I", "Adela");
        gbt.add("William I", "Henry I");
        gbt.add("Adela", "Stephan");
        gbt.add("Henry I", "William III");
        gbt.add("Henry I", "Matilda");
        gbt.add("Matilda", "Henry II");

        System.out.println(gbt.toString());

    }

    public static void TestGenericBinaryTree2() {
        System.out.println("sample 2");
        GeneralBinaryTree<String> gbt2 = new GeneralBinaryTree<>();
        gbt2.add("C", "ProgramFiles");
        gbt2.add("C", "users");
        gbt2.add("C", "Windows");
        gbt2.add("ProgramFiles", "Java");
        gbt2.add("ProgramFiles", "JetBrains");
        gbt2.add("ProgramFiles", "Intel");
        gbt2.add("ProgramFiles", "Realtek");
        gbt2.add("Users", "Public");
        gbt2.add("Users", "Zeyneb");
        gbt2.add("Windows", "Boot");
        gbt2.add("Windows", "Help");
        gbt2.add("Windows", "Logs");



        System.out.println(gbt2.toString());

    }

    public static void TestGenericBinaryTree3() {
        System.out.println("sample 3");
        GeneralBinaryTree<String> gbt = new GeneralBinaryTree<>();
        gbt.add("1", "2");
        gbt.add("1", "4");
        gbt.add("1", "7");
        gbt.add("2", "3");
        gbt.add("2", "6");
        gbt.add("3", "5");
        gbt.toString();
    }

    public static void TestMultiDimensionalTree2dimension() {
        System.out.println("MultiDimensionalTree Sample for 2 dimensions");
        MultiDimensionalTree mdt = new MultiDimensionalTree(2);
        mdt.add(new double[]{40, 45});
        mdt.add(new double[]{15, 70});
        mdt.add(new double[]{70, 10});
        mdt.add(new double[]{69, 50});
        mdt.add(new double[]{85, 90});
        mdt.add(new double[]{66, 85});

        System.out.println(mdt.toString());
    }

    public static void TestMultiDimensionalTree3dimension() {
        System.out.println("MultiDimensionalTree Sample for 3 dimensions");
        MultiDimensionalTree mdt = new MultiDimensionalTree(); //default dimension count 3
        try {
            mdt.add(new double[]{40, 45, 35});      //1. ya baktı 15 küçük olduğundan
            mdt.add(new double[]{15, 70, 20});
            mdt.add(new double[]{70, 10, 18});
            mdt.add(new double[]{69, 50, 10});
            mdt.add(new double[]{85, 90, 30});
            mdt.add(new double[]{66, 85, 25});
            mdt.add(new double[]{55, 15, 5});
        } catch (IllegalArgumentException exp) {
            System.out.println(exp.getMessage());
        }
        System.out.println(mdt.toString());
    }
}
