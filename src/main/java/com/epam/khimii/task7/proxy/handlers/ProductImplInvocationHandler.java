package com.epam.khimii.task7.proxy.handlers;

import com.epam.khimii.task7.proxy.products.IProduct;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProductImplInvocationHandler implements InvocationHandler {
    private IProduct proxiedProductImpl;

    public ProductImplInvocationHandler(IProduct proxiedProductImpl) {
        this.proxiedProductImpl = proxiedProductImpl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().startsWith("set")) {
            throw new UnsupportedOperationException();
        } else {
            return method.invoke(proxiedProductImpl, args);
        }
    }
}
