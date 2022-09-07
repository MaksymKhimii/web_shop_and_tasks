package com.epam.khimii.task7.proxy.products;

import java.math.BigDecimal;

public interface IProduct {
    void setName(String name);

    void setPrice(BigDecimal price);

    void setCountry(String country);

    BigDecimal getPrice();

    String getCountry();

    String getName();
}
