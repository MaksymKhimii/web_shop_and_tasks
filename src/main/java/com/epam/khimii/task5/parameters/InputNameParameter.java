package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.chain.FileNameFilter;
import com.epam.khimii.task5.chain.IFilter;
import com.epam.khimii.task5.util.Util;

import java.util.Scanner;

public class InputNameParameter implements InputParameter {
    private final Scanner scanner;

    public InputNameParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public IFilter execute(IFilter filter) {
        System.out.println("Search by file name? Input 1");
        int find = Util.getNumber(scanner.nextLine());
        if (find == 1) {
            System.out.println("Input file name");
            String name = scanner.nextLine();
            return new FileNameFilter(name, filter);
        }
        return filter;
    }
}