package com.epam.khimii.task8.searchingByteSequence;

import com.epam.khimii.task8.searchingSimpleNumbers.FileUtil;
import com.epam.khimii.task8.searchingSimpleNumbers.NumberUtil;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FindSequence {
    private static final Scanner scanner = new Scanner(System.in);

    public void findSequence() {
        ReadByteSequence readByteSequence = new ReadByteSequence();
        String myChoice;
        while (true) {
            System.out.println("Enter the file name:");
            String fileName = scanner.nextLine();
            File file = FileUtil.getFile(fileName);
            String line = null;
            try {
                line = readByteSequence.readFile(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            readByteSequence.findLongestSequence(line);
            Sequence resultSequence = readByteSequence.getSequence();
            System.out.println("The longest byte sequence is: " + resultSequence.getSequence() + "\n" +
                    "first occurrence index: " + resultSequence.getFirstIndex() + "\n" +
                    "last occurrence index: " + resultSequence.getLastIndex() + "\n" +
                    "sequence size is " + resultSequence.getSequence().length());
            System.out.println("Are you wont to continue the searching?(1/0)");
            myChoice = scanner.nextLine();
            int numberOfCommand = NumberUtil.getNumber(myChoice);
            if (numberOfCommand == 0) {
                return;
            }
        }
    }
}