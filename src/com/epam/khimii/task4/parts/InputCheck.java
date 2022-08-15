package com.epam.khimii.task4.parts;

public class InputCheck {

    public static int check(String сhoice) {
        if (!isDigit(сhoice)) {
            return -1;
        }
        int number = Integer.parseInt(сhoice);
        if (number < 0 || number > 8) {
            return -1;
        }
        return number;
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
