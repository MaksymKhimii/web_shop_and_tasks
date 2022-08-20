package com.epam.khimii.task5.chain;

import java.io.File;

public class FileNameFilter extends FileParameterFilter {
    private final String name;

    public FileNameFilter(String name, IFilter filter) {
        super(filter);
        this.name = name;
    }

    @Override
    public boolean handle(File file) {
        return getFileName(file).equals(this.name);
    }

    private String getFileName(File file) {
        return file.getName().replaceFirst("[.][^.]+$", "");
    }
}