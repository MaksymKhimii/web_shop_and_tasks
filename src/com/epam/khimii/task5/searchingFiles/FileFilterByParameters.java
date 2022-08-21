package com.epam.khimii.task5.searchingFiles;

import com.epam.khimii.task5.chain.IFilter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class FileFilterByParameters {
    private final IFilter filter;

    public FileFilterByParameters(IFilter filter) {
        this.filter = filter;
    }

    public List<File> searchFilesByFilter(String path) {
        List<File> files = new ArrayList<>();
        File[] newFiles = new File(path).listFiles();
        assert newFiles != null;
        for (File file : newFiles) {
            if (file.isDirectory()) {
                files.addAll(searchFilesByFilter(file.getAbsolutePath()));
            } else {
                if (filter.filter(file)) {
                    files.add(file);
                }
            }
        }
        return files;
    }
}