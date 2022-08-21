package com.epam.khimii.task5.chain;

import java.io.File;

public abstract class FileParameterFilter implements IFilter {
    private final IFilter nextHandler;

    public FileParameterFilter(IFilter nextHandler) {
        this.nextHandler = nextHandler;
    }

    public abstract boolean handle(File file);

    @Override
    public boolean filter(File file) {
        if (handle(file)) {
            return nextHandler.filter(file);
        }
        return false;
    }
}