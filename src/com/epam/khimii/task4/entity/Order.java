package com.epam.khimii.task4.entity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Order {
    private static final TreeMap<LocalDateTime, HashMap<String, Integer>> order = new TreeMap<>();

    public void put(LocalDateTime key, HashMap<String, Integer> value) {
        order.put(key, value);
    }

    public Set<Map.Entry<LocalDateTime, HashMap<String, Integer>>> entrySet() {
        return order.entrySet();
    }

    @Override
    public String toString() {
        if (order.isEmpty()) {
            return "Empty order(";
        }
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(string);
        for (Map.Entry<LocalDateTime, HashMap<String, Integer>> entry : order.entrySet()) {
            stringBuilder.append("Product{" + "name='").append(entry.getKey()).append('\'').append(", quantity='").append(entry.getValue()).append('\'').append('}').append("\r\n");
        }
        return stringBuilder.toString();
    }
}
