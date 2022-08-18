package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.util.DateUtil;
import com.epam.khimii.task5.util.Parameter;

import java.util.Map;
import java.util.Scanner;

public class InputDateParameter implements InputParameter {
    private Scanner scanner;

    public InputDateParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute(Map<Parameter, String> parameters) {
        System.out.println("Search by file date? Input 1");

        int find = scanner.nextInt();
        if (find == 1) {
            System.out.println("Input file creation date (min and max) in format 'dd-MM-yyyy'");
            parameters.put(Parameter.DATE, DateUtil.inputDateInString() + "/" + DateUtil.inputDateInString());
        }
    }
}