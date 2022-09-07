package com.epam.khimii.task7.proxy.factory;

import com.epam.khimii.task7.proxy.products.IProduct;

public interface ProductProxyCreator {
    IProduct createProxyProduct(IProduct products);
}
