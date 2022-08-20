package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.chain.FileSizeFilter;
import com.epam.khimii.task5.chain.IFilter;
import com.epam.khimii.task5.util.Util;

import java.util.Scanner;

public class InputSizeParameter implements InputParameter {
    private final Scanner scanner;

    public InputSizeParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public IFilter execute(IFilter filter) {
        System.out.println("Search by size? Input 1");
        int find = Util.getNumber(scanner.nextLine());
        if (find == 1) {
            System.out.println("Input file size (min and max)");
            int minSize = Util.getNumber(scanner.nextLine());
            int maxSize = Util.getNumber(scanner.nextLine());
            return new FileSizeFilter(minSize, maxSize, filter);
        }
        return filter;
    }
}