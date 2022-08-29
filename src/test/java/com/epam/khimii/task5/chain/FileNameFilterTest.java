package com.epam.khimii.task5.chain;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileNameFilterTest {
    File file = new File("file1.txt");
    private final IFilter filter = new DefaultFilter();

    @Test
    public void findByNameAndExtensionTest() {
        String fileName = "file1";
        FileNameFilter fileNameFilter = new FileNameFilter(fileName, filter);
        Assert.assertTrue(fileNameFilter.handle(file));
    }
}