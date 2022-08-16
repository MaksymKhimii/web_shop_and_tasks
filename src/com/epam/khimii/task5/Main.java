package com.epam.khimii.task5;

import com.epam.khimii.task5.searchingFiles.FileSearchApp;

public class Main {
    public static void main(String[] args) {
        //here must be directory where this program
        // should find or not find needed file
        FileSearchApp.searchingFilesByPath("D:\\epam\\LabMain\\");
    }
}