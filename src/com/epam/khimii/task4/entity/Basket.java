package com.epam.khimii.task4.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Basket implements Serializable {
    private static final Map<String, Integer> basket = new HashMap<>();

    public Map<String, Integer> getBasket() {
        return basket;
    }

    public int size() {
        return basket.size();
    }

    public boolean isEmpty() {
        return basket.isEmpty();
    }

    public static boolean isExists(String name) {
        return basket.get(name) != null;
    }

    public Set<Map.Entry<String, Integer>> entrySet() {
        return basket.entrySet();
    }

    public Integer get(String key) {
        return basket.get(key);
    }

    public void put(String key, Integer value) {
        basket.put(key, value);
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