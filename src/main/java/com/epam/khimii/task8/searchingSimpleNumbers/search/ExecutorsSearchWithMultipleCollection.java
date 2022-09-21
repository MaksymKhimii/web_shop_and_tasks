package com.epam.khimii.task8.searchingSimpleNumbers.search;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.threads.RunnableForSearchWithMultipleCollection;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * ExecutorsSearch2 with saving data in different containers
 */
public class ExecutorsSearchWithMultipleCollection implements Search {
    private final int min;
    private final int max;
    private int threadCount;
    private final ResultContainer result;

    public ExecutorsSearchWithMultipleCollection(int min, int max, int threadCount, ResultContainer result) {
        this.min = min;
        this.max = max;
        this.threadCount = threadCount;
        this.result = result;
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
            RunnableForSearchWithMultipleCollection mr = new RunnableForSearchWithMultipleCollection(localMin, localMax);
            future = executorService.submit(mr);
            threadCount--;
            localMin += step;
            localMax += step;
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
            result.addAll(mr.getResultContainer());
        }
        executorService.shutdown();
    }
}