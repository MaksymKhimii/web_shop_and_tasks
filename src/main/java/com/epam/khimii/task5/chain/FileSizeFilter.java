package com.epam.khimii.task5.chain;

import java.io.File;

public class FileSizeFilter extends FileParameterFilter {
    private final int minSize;
    private final int maxSize;

    public FileSizeFilter(int minSize, int maxSize, IFilter filter) {
        super(filter);
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    @Override
    public boolean handle(File file) {
        return file.length() >= minSize && file.length() <= maxSize;
    }
}