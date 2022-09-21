package com.epam.khimii.task8.searchingByteSequence;

import java.util.HashSet;
import java.util.TreeMap;

public class ThreadForSearch implements Runnable {
    private final String line;
    private String sequenceString;
    private int firstIndex;
    private int lastIndex;
    private Sequence sequence;
    private int currentSize;

    public ThreadForSearch(String line) {
        this.line = line;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public synchronized Sequence getSequence() {
        return sequence;
    }

    private Sequence generateSequence() {
        return new Sequence(sequenceString, firstIndex, lastIndex);
    }

    @Override
    public synchronized void run() {
        TreeMap<Integer, HashSet<String>> map = new TreeMap<>();
        for (int j = 0; j < line.length(); j++) {
            for (int i = 0; i < line.length(); i++) {
                String seq1 = line.substring(j, j + i);
                if (line.indexOf(seq1) != line.lastIndexOf(seq1)) {
                    map.computeIfAbsent(seq1.length(), (key) -> new HashSet<>()).add(seq1);
                    currentSize = map.size();
                }
                if (j + i >= line.length()) {
                    break;
                }
            }
        }
        if (map.isEmpty()) {
            sequenceString = "";
            firstIndex = 0;
            lastIndex = 0;
        } else {
            sequenceString = map.get(map.lastKey()).iterator().next();
            firstIndex = line.indexOf(sequenceString);
            lastIndex = line.lastIndexOf(sequenceString);
        }
        sequence = generateSequence();
    }
}