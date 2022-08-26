package com.epam.khimii.task4.parts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Scanner;

public class InputCheck {
    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static LocalDateTime getInputTime(Scanner scanner) {
        String date = scanner.nextLine();
        if (!isDateValid(date)) {
            return null;
        }
        System.out.println(date);
        return LocalDateTime.parse(date);
    }

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static int getNumber(Scanner scanner) {
        String string = scanner.nextLine();
        if (!isDigit(string)) {
            return -1;
        }
        int answer = Integer.parseInt(string);
        if (answer < 0) {
            return -1;
        }
        return answer;
    }

    public static int getStrategyCodeNumber(Scanner scanner) {
        String string = scanner.nextLine();
        if (!isDigit(string)) {
            return -1;
        }
        int answer = Integer.parseInt(string);
        if (answer < 0 || answer > 1) {
            return -1;
        }
        return answer;
    }
}
