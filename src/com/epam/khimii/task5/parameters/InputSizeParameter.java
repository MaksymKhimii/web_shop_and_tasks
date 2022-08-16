package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.util.Parameter;

import java.util.Map;
import java.util.Scanner;

public class InputSizeParameter implements InputParameter {
    @Override
    public void execute(Map<Parameter, String> parameters) {
        System.out.println("Search by size? Input 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            System.out.println("Input file size (min and max)");
            parameters.put(Parameter.SIZE, "" + sc.nextInt() + "/" + sc.nextInt());
        }
    }
}