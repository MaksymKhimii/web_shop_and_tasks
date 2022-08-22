package com.epam.khimii.task6.factory;

import com.epam.khimii.task1.entity.Product;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create product from input string.
 * Use pattern to find field.
 */
public class ProductCreator {
    protected Matcher matcher;

    public Product createProductFromString(String line) {
        this.matcher = Pattern.compile("'[\\w,\\s]*'").matcher(line);
        return new Product(this.getField(this.matcher), new BigDecimal(this.getField(this.matcher)), this.getField(this.matcher));
    }

    protected String getField(Matcher matcher) {
        return matcher.find() ? matcher.group().replace("'","") : null;
    }
}

