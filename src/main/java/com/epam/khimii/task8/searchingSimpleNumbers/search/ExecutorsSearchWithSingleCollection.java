package com.epam.khimii.task8.searchingSimpleNumbers.search;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.threads.RunnableForSearchWithSingleCollection;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorsSearch with one container for saving data
 */
public class ExecutorsSearchWithSingleCollection implements Search {
    private final int min;
    private final int max;
    private int threadCount;
    private final ResultContainer resultContainer;

    public ExecutorsSearchWithSingleCollection(int min, int max, int threadCount, ResultContainer resultContainer) {
        this.min = min;
        this.max = max;
        this.threadCount = threadCount;
        this.resultContainer = resultContainer;
    }

    public int getSize() {
        return max - min;
    }

    @Override
    public synchronized void startSearching() {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        int step = getSize() / threadCount;
        int localMin = min;
        int localMax = min + step;
        Future<?> future;
        while (threadCount != 0) {
            future =
                    executorService.submit(new RunnableForSearchWithSingleCollection(localMin, localMax, resultContainer));
            threadCount--;
            localMin += step;
            localMax += step;
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}