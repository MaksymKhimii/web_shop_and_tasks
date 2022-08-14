package com.epam.khimii.task4.entity;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Order {
    private static final TreeMap<LocalDateTime, Map<String, Integer>> order = new TreeMap<>();

    public void put(LocalDateTime key, Map<String, Integer> value) {
        order.put(key, value);
    }

    public Set<Map.Entry<LocalDateTime, Map<String, Integer>>> entrySet() {
        return order.entrySet();
    }

    public Map<String, Integer> get(LocalDateTime key) {
        return order.get(key);
    }


    @Override
    public String toString() {
        if (order.isEmpty()) {
            return "Empty order(";
        }
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(string);
        for (Map.Entry<LocalDateTime, Map<String, Integer>> entry : order.entrySet()) {
            stringBuilder.append("Product{" + "name='").append(entry.getKey()).append('\'').append(", quantity='").append(entry.getValue()).append('\'').append('}').append("\r\n");
        }
        return stringBuilder.toString();
    }
}
