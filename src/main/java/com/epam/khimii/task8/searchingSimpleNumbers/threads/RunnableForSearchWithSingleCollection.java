package com.epam.khimii.task8.searchingSimpleNumbers.threads;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.SimpleNumber;

/**
 * MyRunnable  with one container for saving data
 */
public class RunnableForSearchWithSingleCollection implements Runnable {
    private final int min;
    private final int max;
    private ResultContainer resultContainer;

    public RunnableForSearchWithSingleCollection(int min, int max, ResultContainer resultContainer) {
        this.min = min;
        this.max = max;
        this.resultContainer = resultContainer;
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