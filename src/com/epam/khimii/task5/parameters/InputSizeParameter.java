package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.util.Parameter;

import java.util.Map;
import java.util.Scanner;

public class InputSizeParameter implements InputParameter {
    private Scanner scanner;

    public InputSizeParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(Map<Parameter, String> parameters) {
        System.out.println("Search by size? Input 1");
        int find = scanner.nextInt();
        if (find == 1) {
            System.out.println("Input file size (min and max)");
            parameters.put(Parameter.SIZE, "" + scanner.nextInt() + "/" + scanner.nextInt());
        }
    }
}