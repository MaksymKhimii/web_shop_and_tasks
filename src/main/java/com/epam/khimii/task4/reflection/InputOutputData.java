package com.epam.khimii.task4.reflection;

import java.util.Scanner;

public class InputOutputData {
    private final Scanner sc;

    public InputOutputData() {
        sc = new Scanner(System.in);
    }

    public Integer inputCodeOfProductClass(String classes) {
        System.out.println("Input code");
        System.out.println(classes);
        return Integer.parseInt(inputString());
    }

    public String getInput(String text) {
        System.out.println(text);
        return inputString();
    }

    public static void printField(String field, Resource resource) {
        System.out.println(resource.getInputString(field));
    }

    public String inputString() {
        return sc.nextLine();
    }
}
