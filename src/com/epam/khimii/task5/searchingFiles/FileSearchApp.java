package com.epam.khimii.task5.searchingFiles;

import com.epam.khimii.task5.container.ParametersContainer;
import com.epam.khimii.task5.parameters.InputParameter;
import com.epam.khimii.task5.util.Parameter;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class FileSearchApp {
    public static void main(String[] args) {
        //here must be directory where this program
        // should find or not find needed file
        FileSearchApp.searchingFilesByPath("D:\\epam\\LabMain\\");
        
    }
    public static void searchingFilesByPath(String path) {
        Map<Parameter, String> parameters = new LinkedHashMap<>();
        for (InputParameter parameter : new ParametersContainer().getParameters()) {
            parameter.execute(parameters);
        }
        FileFilterByParameters file = new FileFilterByParameters();
        file.addParameters(parameters);
        System.out.println("Found files:");
        printFiles(file.search(path));
    }

    public static void printFiles(List<File> files) {
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}