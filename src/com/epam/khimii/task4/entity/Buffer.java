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

    public boolean isEmpty() {
        return buffer.isEmpty();
    }

    public static boolean isExists(String name) {
        for (Map.Entry<String, Integer> entry : buffer.entrySet()) {
            if (entry.getKey().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void put(String key, Integer value) {
        if (isExists(key)) {
            int newValue = buffer.get(key) + value;
            buffer.put(key, newValue);
            return;
        }
        buffer.put(key, value);
    }

    public void remove(Object name) {
        buffer.remove(name);
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
