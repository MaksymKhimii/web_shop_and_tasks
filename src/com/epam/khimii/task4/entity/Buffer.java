package com.epam.khimii.task4.entity;


import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Buffer {
    private static final LinkedHashMap<String, Integer> buffer =
            new LinkedHashMap<>();

    public int size() {
        return buffer.size();
    }

    public void put(String key, Integer value) {
        buffer.put(key, value);
    }

    public void remove(Object name) {
        buffer.remove(name);
    }

    public Set<Map.Entry<String, Integer>> entrySet() {
        return buffer.entrySet();
    }

    public static String getFirstInBuffer() {
        for (Map.Entry<String, Integer> entry : buffer.entrySet()) {
            return entry.getKey();
        }
        return null;
    }

    public static void print(Buffer map) {
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Product{" +
                    "name='" + entry.getKey() + '\'' +
                    ", quantity='" + entry.getValue() +
                    '\'' +
                    '}');
        }
    }
}
