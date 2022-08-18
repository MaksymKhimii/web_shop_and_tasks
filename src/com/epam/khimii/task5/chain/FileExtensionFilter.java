package com.epam.khimii.task5.chain;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileExtensionFilter extends FileParameterFilter {
    private String extension;

    public FileExtensionFilter(String extension) {
        this.extension = extension;
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(file -> file.getAbsolutePath().endsWith(extension))
                .collect(Collectors.toList());
    }
}