package com.epam.khimii.task7.proxy.handlers;

import com.epam.khimii.task7.proxy.products.IProduct;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProductOnMapInvocationHandler implements InvocationHandler {
    private Map<String, Object> fieldNameToValue = new HashMap<>();

    public ProductOnMapInvocationHandler(IProduct product) {
        Field[] fields = product.getClass().getDeclaredFields();
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                fieldNameToValue.put(f.getName(), f.get(product));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) {
        if (method.getName().startsWith("set")) {
            fieldNameToValue.put(MethodParsing.getDeclaredNameFromMethod(method), args[0]);
            return null;
        } else if (method.getName().startsWith("get")) {
            return fieldNameToValue.get(MethodParsing.getDeclaredNameFromMethod(method));
        }
        throw new UnsupportedOperationException();
    }
}
