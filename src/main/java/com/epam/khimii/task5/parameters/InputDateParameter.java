package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.chain.FileDateFilter;
import com.epam.khimii.task5.chain.IFilter;
import com.epam.khimii.task5.util.Util;

import java.text.ParseException;
import java.util.Scanner;

public class InputDateParameter implements InputParameter {
    private final Scanner scanner;

    public InputDateParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public IFilter execute(IFilter filter) throws ParseException {
        System.out.println("Search by file date? Input 1");
        int find = Util.getNumber(scanner.nextLine());
        if (find == 1) {
            System.out.println("Input file creation date (min and max) in format 'dd-MM-yyyy'");
            return new FileDateFilter(Util.getInputTime(scanner), Util.getInputTime(scanner), filter);
        }
        return filter;
    }
}