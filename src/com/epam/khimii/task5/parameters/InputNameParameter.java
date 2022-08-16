package com.epam.khimii.task5.parameters;

import com.epam.khimii.task5.util.Parameter;
import java.util.Map;
import java.util.Scanner;

public class InputNameParameter implements InputParameter {
    @Override
    public void execute(Map<Parameter, String> parameters) {
        System.out.println("Search by file name? Input 1");
        Scanner sc = new Scanner(System.in);
        int find = sc.nextInt();
        if (find == 1) {
            System.out.println("Input file name");
            sc.nextLine();
            parameters.put(Parameter.NAME,sc.nextLine());
        }
    }
}