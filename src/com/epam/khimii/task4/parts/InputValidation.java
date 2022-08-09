package com.epam.khimii.task4.parts;

import java.util.Scanner;

public class InputValidation {
    // Method for checking the validity of the selected operation
    public static int check() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Это не число");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 0 || choice > 8);
        return choice;
    }
}
