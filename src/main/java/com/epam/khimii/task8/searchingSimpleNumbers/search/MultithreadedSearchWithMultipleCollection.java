package com.epam.khimii.task8.searchingSimpleNumbers.search;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.threads.ThreadForSearchWithMultipleCollection;

/**
 * MultithreadedSearch2 with saving data in different containers
 */
public class MultithreadedSearchWithMultipleCollection implements Search {
    private final int min;
    private final int max;
    private int threadCount;
    private final ResultContainer result;

    public MultithreadedSearchWithMultipleCollection(int min, int max, int threadCount, ResultContainer result) {
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
            ThreadForSearchWithMultipleCollection t = new ThreadForSearchWithMultipleCollection(finalLocalMin, finalLocalMax);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.addAll(t.getResult());
            threadCount--;
            localMin += step;
            localMax += Math.min(size, step);
            size -= step;
        }
    }
}