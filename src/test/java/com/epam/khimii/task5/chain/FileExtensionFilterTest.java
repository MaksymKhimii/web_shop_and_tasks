package com.epam.khimii.task5.chain;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileExtensionFilterTest {
    File file = new File("D:\\epam\\LabMain\\file1.txt");
    private final IFilter filter = new DefaultFilter();

    @Test
    public void findByExtensionTest() {
        String extension = "txt";
        FileExtensionFilter fileExtensionFilter = new FileExtensionFilter(extension, filter);
        Assert.assertTrue(fileExtensionFilter.handle(file));
    }
}
