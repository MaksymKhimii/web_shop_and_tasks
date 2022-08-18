package com.epam.khimii.task5.chain;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FileDateFilter extends FileParameterFilter {
    private Date minDate;
    private Date maxDate;

    public FileDateFilter(String dates) {
        Date[] date = parseStringToGetDates(dates);
        this.minDate = date[0];
        this.maxDate = date[1];
    }

    public FileDateFilter(Date minDate, Date maxDate) {
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    private Date[] parseStringToGetDates(String sizes) {
        String[] date = sizes.split("/");
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            return new Date[]{format.parse(date[0]), format.parse(date[1])};
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<File> handle(List<File> files) {
        return files.stream()
                .filter(file -> new Date(file.lastModified()).after(minDate) && new Date(file.lastModified()).before(maxDate))
                .collect(Collectors.toList());
    }
}
