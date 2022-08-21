package com.epam.khimii.task5.searchingFiles;

import com.epam.khimii.task5.chain.DefaultFilter;
import com.epam.khimii.task5.chain.IFilter;
import com.epam.khimii.task5.container.ParametersContainer;
import com.epam.khimii.task5.parameters.InputParameter;

import java.io.File;
import java.text.ParseException;
import java.util.List;


public class FileSearchApp {
    public static void main(String[] args) throws ParseException {
        //here must be directory where this program
        // should find or not find needed file
        FileSearchApp.searchingFilesByPath("D:\\epam\\LabMain\\");
    }

    public static void searchingFilesByPath(String path) throws ParseException {
        IFilter filter = new DefaultFilter();
        for (InputParameter parameter : new ParametersContainer().getParameters()) {
            filter = parameter.execute(filter);
        }
        FileFilterByParameters fileFilter = new FileFilterByParameters(filter);
        List<File> list = fileFilter.searchFilesByFilter(path);
        System.out.println("Found files:");
        printFiles(list);
    }

    public static void printFiles(List<File> files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}