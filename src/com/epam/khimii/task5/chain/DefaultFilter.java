package com.epam.khimii.task5.chain;

import java.io.File;

public class DefaultFilter implements IFilter {

    @Override
    public boolean filter(File file) {
        return true;
    }
}
