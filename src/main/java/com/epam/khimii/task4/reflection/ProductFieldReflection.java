package com.epam.khimii.task4.reflection;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task4.fieldAnnotaions.FieldTittle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class ProductFieldReflection {
    public Product fillProduct(Class<? extends Product> prod, Resource resource)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Product product = prod.newInstance();
        Field[] fields = getAnnotatedFields(prod);
        String data;
        for (Field field : fields) {
            field.setAccessible(true);
            InputOutputData.printField(field.getName(), resource);
            data = resource.getInputString(field.getName());
            Constructor constructorField = field.getType().getDeclaredConstructor(String.class);
            field.set(product, constructorField.newInstance(data));
        }
        return product;
    }

    private Field[] getAnnotatedFields(Class<?> prod) {
        List<Field> fields = new ArrayList<>();
        while (prod.getSuperclass() != null) {
            List<Field> filteredFields = new ArrayList<>();
            for (Field field : prod.getDeclaredFields()) {
                if (field.isAnnotationPresent(FieldTittle.class)) {
                    filteredFields.add(field);
                }
            }
            fields.addAll(0, filteredFields);
            prod = prod.getSuperclass();
        }
        return fields.toArray(new Field[0]);
    }
}