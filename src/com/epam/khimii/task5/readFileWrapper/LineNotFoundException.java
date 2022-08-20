package com.epam.khimii.task5.readFileWrapper;

import java.io.IOException;

public class LineNotFoundException extends IOException {
    public LineNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
