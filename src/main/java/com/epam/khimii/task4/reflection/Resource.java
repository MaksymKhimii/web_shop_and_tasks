package com.epam.khimii.task4.reflection;

import java.util.Locale;
import java.util.ResourceBundle;

public class Resource {
    private Locale locale;
    private ResourceBundle resourceBundle;
    private static final String INPUT = "input.";
    private static final String RESOURCES = "resources";

    public Resource(String localeName) {
        this.locale = new Locale(localeName);
        this.resourceBundle = ResourceBundle.getBundle(RESOURCES, locale);
    }

    public String getInputString(String tittle) {
        return resourceBundle.getString(INPUT + tittle);
    }
}
