package com.epam.khimii.task5.chain;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileNameFilter extends FileParameterFilter {
    private String name;

    public FileNameFilter(String name) {
        this.name = name;
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(f -> f.getName().contains(this.name))
                .collect(Collectors.toList());
    }
}