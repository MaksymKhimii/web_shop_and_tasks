package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.chain.FileExtensionFilter;
import com.epam.khimii.task5.chain.IFilter;
import com.epam.khimii.task5.util.Util;

import java.util.Scanner;

public class InputExtensionParameter implements InputParameter {
    private final Scanner scanner;

    public InputExtensionParameter(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public IFilter execute(IFilter filter) {
        System.out.println("Search by file extension? Input 1");
        int find = Util.getNumber(scanner.nextLine());
        if (find == 1) {
            System.out.println("Input file extension");
            String extension = scanner.nextLine();
            return new FileExtensionFilter(extension, filter);
        }
        return filter;
    }
}