package com.epam.khimii.task8.searchingSimpleNumbers.threads;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.SimpleNumber;

import java.util.List;

/**
 * MyRunnable2 with saving data in different containers
 */
public class RunnableForSearchWithMultipleCollection implements Runnable {
    private final int min;
    private final int max;
    private ResultContainer resultContainer = new ResultContainer();

    public RunnableForSearchWithMultipleCollection(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public synchronized List<Integer> getResultContainer() {
        return resultContainer.getResult();
    }

    @Override
    public synchronized void run() {
        for (int n = min; n < max; n++) {
            if (SimpleNumber.isSimple(n)) {
                resultContainer.add(n);
            }
        }
    }
}