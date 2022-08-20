package com.epam.khimii.task5.chain;

import java.io.File;
import java.util.Date;

public class FileDateFilter extends FileParameterFilter {
    private final Date minDate;
    private final Date maxDate;

    public FileDateFilter(Date minDate, Date maxDate, IFilter filter) {
        super(filter);
        this.minDate = minDate;
        this.maxDate = maxDate;
    }

    @Override
    public boolean handle(File file) {
        return new Date(file.lastModified()).after(minDate) && new Date(file.lastModified()).before(maxDate);
    }
}
