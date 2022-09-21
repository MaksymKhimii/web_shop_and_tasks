package com.epam.khimii.task8.searchingSimpleNumbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ResultContainer {
    private final List<Integer> result = new ArrayList<>();

    public synchronized List<Integer> getResult() {
        return result;
    }

    public void add(int number) {
        result.add(number);
    }

    public void addAll(Collection<? extends Integer> numbers) {
        result.addAll(numbers);
    }
}
