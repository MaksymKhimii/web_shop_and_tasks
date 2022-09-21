package com.epam.khimii.task8.searchingSimpleNumbers;

import java.io.File;

public class FileUtil {
    public static File getFile(String fileName) {
        File file = new File(fileName);
        if (file.exists() && file.isDirectory()) {
            throw new IllegalArgumentException("Incorrect file name(");
        }
        return file;
    }
}
