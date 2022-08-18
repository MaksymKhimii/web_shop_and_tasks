package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.util.Parameter;

import java.util.Map;
import java.util.Scanner;

public class InputExtensionParameter implements InputParameter {
    private Scanner scanner;

    public InputExtensionParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(Map<Parameter, String> parameters) {
        System.out.println("Search by file extension? Input 1");
        int find = scanner.nextInt();
        if (find == 1) {
            System.out.println("Input file extension");
            scanner.nextLine();
            parameters.put(Parameter.EXTENSION, scanner.nextLine());
        }
    }
}