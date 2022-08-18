package com.epam.khimii.task5.chain;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class FileSizeFilter extends FileParameterFilter {
    private int minSize;
    private int maxSize;

    public FileSizeFilter(String sizes) {
        int[] size = parseStringToGetSizes(sizes);
        this.minSize = size[0];
        this.maxSize = size[1];
    }

    public FileSizeFilter(int minSize, int maxSize) {
        this.minSize = minSize;
        this.maxSize = maxSize;
    }

    private int[] parseStringToGetSizes(String sizes) {
        String[] size = sizes.split("/");
        return new int[]{Integer.parseInt(size[0]), Integer.parseInt(size[1])};
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(file -> file.length() >= minSize && file.length() <= maxSize)
                .collect(Collectors.toList());
    }
}