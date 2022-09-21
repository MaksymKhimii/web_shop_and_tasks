package com.epam.khimii.task8.searchingSimpleNumbers;

public class NumberUtil {
    public static int getNumber(String string) {
        String regex = "[0-9]+";
        if (!string.matches(regex)) {
            try {
                throw new NumberFormatException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return Integer.parseInt(string);
    }
}