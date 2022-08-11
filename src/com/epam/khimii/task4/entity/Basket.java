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

    public static boolean isExists(String name) {
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            if (entry.getKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, Integer value) {
        if (isExists(key)) {
            int newValue = basket.get(key) + value;
            basket.put(key, newValue);
            return;
        }
        basket.put(key, value);
    }

    public Set<Map.Entry<String, Integer>> entrySet() {
        return basket.entrySet();
    }

    public void clear() {
        basket.clear();
    }

    @Override
    public String toString() {
        if (basket.isEmpty()) {
            return "Empty basket(";
        }
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(string);
        for (Map.Entry<String, Integer> entry : basket.entrySet()) {
            stringBuilder.append("Product{" + "name='").append(entry.getKey()).append('\'').append(", quantity='").append(entry.getValue()).append('\'').append('}').append("\r\n");
        }
        return stringBuilder.toString();
    }
}