package com.epam.khimii.task7.proxy.products;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ProductOnMap implements IProduct {
    private final Map<String, Object> fields = new HashMap<>();

    @Override
    public void setName(String name) {
        fields.put("name", name);
    }

    @Override
    public void setPrice(BigDecimal price) {
        fields.put("price", price);
    }

    @Override
    public void setCountry(String country) {
        fields.put("country", country);
    }

    @Override
    public BigDecimal getPrice() {
        return new BigDecimal(String.valueOf(fields.get("price")));
    }

    @Override
    public String getCountry() {
        return String.valueOf(fields.get("country"));
    }

    @Override
    public String getName() {
        return String.valueOf(fields.get("name"));
    }
}
