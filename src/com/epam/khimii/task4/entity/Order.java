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

    public static <K, V> void print(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Product{" +
                    "name='" + entry.getKey() + '\'' +
                    ", quantity='" + entry.getValue() +
                    '\'' +
                    '}');
        }
    }
}
