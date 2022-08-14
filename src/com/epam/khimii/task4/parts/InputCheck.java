package com.epam.khimii.task4.parts;

import java.util.Scanner;

public class InputCheck {
    public static Scanner scanner = new Scanner(System.in);

    public static int check() {
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("It's not a number");
                scanner.next();
            }
            choice = scanner.nextInt();
        } while (choice < 0 || choice > 8);
        return choice;
    }
}
