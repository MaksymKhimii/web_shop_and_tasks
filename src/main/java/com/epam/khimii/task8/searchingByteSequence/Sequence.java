package com.epam.khimii.task8.searchingByteSequence;

public class Sequence {
    private final String sequence;
    private final int firstIndex;
    private final int lastIndex;

    public Sequence(String sequence, int firstIndex, int lastIndex) {
        this.sequence = sequence;
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
    }

    public synchronized String getSequence() {
        return sequence;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public int getLastIndex() {
        return lastIndex;
    }

    @Override
    public String toString() {
        return "Sequence{" +
                "sequence='" + sequence + '\'' +
                ", firstIndex=" + firstIndex +
                ", lastIndex=" + lastIndex +
                '}';
    }
}