package com.epam.khimii.task4.entity;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Buffer implements Serializable {
    private static final int MAX = 5;
    private static Map<String, Integer> buffer =
            new LinkedHashMap<>() {
                protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                    return size() > MAX;
                }
            };

    public int size() {
        return buffer.size();
    }

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public static boolean isExists(String name) {
        return buffer.get(name) != null;
    }

    public Integer get(String key) {
        return buffer.get(key);
    }

    public void put(String key, Integer value) {
        buffer.put(key, value);
    }

    public Set<Map.Entry<String, Integer>> entrySet() {
        return buffer.entrySet();
    }

    @Override
    public String toString() {
        if (buffer.isEmpty()) {
            return "Empty buffer(";
        }
        String string = "";
        StringBuilder stringBuilder = new StringBuilder(string);
        for (Map.Entry<String, Integer> entry : buffer.entrySet()) {
            stringBuilder.append("Product{" + "name='").append(entry.getKey()).append('\'').append(", quantity='").append(entry.getValue()).append('\'').append('}').append("\r\n");
        }
        return stringBuilder.toString();
    }
}
