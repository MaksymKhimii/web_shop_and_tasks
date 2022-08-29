package com.epam.khimii.task5.chain;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDateFilterTest {
    File file = new File("D:\\epam\\LabMain\\file1.txt");
    private final IFilter filter = new DefaultFilter();

    @Test
    public void findByDateTest() throws ParseException {
        String firstDate = "10-08-2022";
        String secondDate = "19-08-2022";
        SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
        Date dateBefore = s.parse(firstDate);
        Date dateAfter = s.parse(secondDate);
        FileDateFilter fileDateFilter = new FileDateFilter(dateBefore, dateAfter, filter);
        Assert.assertTrue(fileDateFilter.handle(file));
    }
}
