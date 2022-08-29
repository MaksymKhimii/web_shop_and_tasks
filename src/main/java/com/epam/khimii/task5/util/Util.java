package com.epam.khimii.task5.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Util {
    public static Date getInputTime(Scanner scanner) throws ParseException {
        String date = scanner.nextLine();
        if (!isDateValid(date)) {
            return null;
        }
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.parse(date);
    }

    public static boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            df.setLenient(false);
            df.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static int getNumber(String s) {
        if (!isDigit(s)) {
            return -1;
        }
        return Integer.parseInt(s);
    }

    public static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
