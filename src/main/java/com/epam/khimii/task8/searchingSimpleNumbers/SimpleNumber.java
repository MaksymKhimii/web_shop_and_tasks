package com.epam.khimii.task8.searchingSimpleNumbers;

public class SimpleNumber {
    public static boolean isSimple(int number) {
        if (number < 1) {
            return false;
        }
        double size = Math.sqrt(number);
        for (int i = 2; i <= size; i++) {
            if (number % i == 0)
                return false;
        }
        return true;
    }
}
