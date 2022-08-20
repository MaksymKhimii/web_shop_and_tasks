package com.epam.khimii.task5.chain;

import java.io.File;

public class FileExtensionFilter extends FileParameterFilter {
    private final String extension;

    public FileExtensionFilter(String extension, IFilter filter) {
        super(filter);
        this.extension = extension;
    }

    @Override
    public boolean handle(File file) {
        return getFileExtension(file).equals(extension);
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".") + 1);
        else return "";
    }
}