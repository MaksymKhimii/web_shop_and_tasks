package com.epam.khimii.task4.controller;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        OnlineStore store = new OnlineStore();
        store.choice();
    }
}
