package com.epam.khimii.task7.proxy.factory;

import com.epam.khimii.task7.proxy.handlers.ProductImplInvocationHandler;
import com.epam.khimii.task7.proxy.products.IProduct;
import com.epam.khimii.task7.proxy.products.ProductImpl;

import java.lang.reflect.Proxy;

public class UnmodifiableProductFactory implements ProductProxyCreator {
    @Override
    public IProduct createProxyProduct(IProduct product) {
        return (IProduct) Proxy.newProxyInstance(
                ProductImpl.class.getClassLoader(),
                ProductImpl.class.getInterfaces(),
                new ProductImplInvocationHandler(product));
    }
}
