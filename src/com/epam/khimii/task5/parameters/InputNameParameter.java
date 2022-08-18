package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.util.Parameter;
import java.util.Map;
import java.util.Scanner;

public class InputNameParameter implements InputParameter {
    private Scanner scanner;

    public InputNameParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(Map<Parameter, String> parameters) {
        System.out.println("Search by file name? Input 1");
        int find = scanner.nextInt();
        if (find == 1) {
            System.out.println("Input file name");
            scanner.nextLine();
            parameters.put(Parameter.NAME,scanner.nextLine());
        }
    }
}