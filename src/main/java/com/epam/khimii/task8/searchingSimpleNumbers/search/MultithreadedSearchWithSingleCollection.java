package com.epam.khimii.task8.searchingSimpleNumbers.search;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.threads.ThreadForSearchWithSingleCollection;

/**
 * MultithreadedSearch with one container for saving data
 */
public class MultithreadedSearchWithSingleCollection implements Search {
    private final int min;
    private final int max;
    private int threadCount;
    private final ResultContainer result;

    public MultithreadedSearchWithSingleCollection(int min, int max, int threadCount, ResultContainer result) {
        this.min = min;
        this.max = max;
        this.threadCount = threadCount;
        this.result = result;
    }

    public int getSize() {
        return max - min;
    }

    @Override
    public void startSearching() {
        int size = getSize();
        int step = size / threadCount;
        int localMin = min;
        int localMax = min + step;
        while (threadCount != 0 && size != 0) {
            int finalLocalMin = localMin;
            int finalLocalMax = localMax;
            ThreadForSearchWithSingleCollection t = new ThreadForSearchWithSingleCollection(finalLocalMin, finalLocalMax, result);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            threadCount--;
            localMin += step;
            localMax += Math.min(size, step);
            size -= step;
        }
    }
}