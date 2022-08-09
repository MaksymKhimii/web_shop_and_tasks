package com.epam.khimii.task4.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Basket {
    public static final HashMap<String, Integer> basket = new HashMap<>();

    public int size() {
        return basket.size();
    }

    public boolean isEmpty() {
        return basket.isEmpty();
    }

    public void put(String key, Integer value) {
        basket.put(key, value);
    }

    public Set<Map.Entry<String, Integer>> entrySet() {
        return basket.entrySet();
    }

    public void clear() {
        basket.clear();
    }

    public static void print(Basket map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Product{" +
                    "name='" + entry.getKey() + '\'' +
                    ", quantity='" + entry.getValue() +
                    '\'' +
                    '}');
        }
    }
}