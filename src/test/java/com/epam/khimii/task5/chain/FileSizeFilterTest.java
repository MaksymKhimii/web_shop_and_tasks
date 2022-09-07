package com.epam.khimii.task5.chain;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class FileSizeFilterTest {
    File file = new File("file1.txt");
    private final IFilter filter = new DefaultFilter();

    @Test
    public void findBySizeTest() {
        FileSizeFilter fileSizeFilter = new FileSizeFilter((int) file.length(), (int) file.length(), filter);
        Assert.assertTrue(fileSizeFilter.handle(file));
    }
}
