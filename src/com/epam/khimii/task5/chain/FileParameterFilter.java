package com.epam.khimii.task5.chain;

import java.io.File;
import java.util.List;

public abstract class FileParameterFilter {
    private FileParameterFilter nextHandler;

    public abstract List<File> handle(List<File> files);

    public void setNextHandler(FileParameterFilter nextHandler) {
        this.nextHandler = nextHandler;
    }

    public List<File> handlerManager(List<File> files) {
        files = handle(files);
        if (nextHandler != null) {
            files = nextHandler.handlerManager(files);
        }
        return files;
    }
}