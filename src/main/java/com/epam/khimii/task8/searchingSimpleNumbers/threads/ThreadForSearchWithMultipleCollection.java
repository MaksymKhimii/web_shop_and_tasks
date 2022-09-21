package com.epam.khimii.task8.searchingSimpleNumbers.threads;


import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.SimpleNumber;

import java.util.List;

/**
 * MyThread2 with saving data in different containers
 */
public class ThreadForSearchWithMultipleCollection extends Thread {
    private final int localMin;
    private final int localMax;
    private ResultContainer result = new ResultContainer();

    public ThreadForSearchWithMultipleCollection(int LocalMin, int LocalMax) {
        this.localMin = LocalMin;
        this.localMax = LocalMax;
    }

    public synchronized List<Integer> getResult() {
        return result.getResult();
    }

    @Override
    public void run() {
        for (int n = localMin; n < localMax; n++) {
            if (SimpleNumber.isSimple(n)) {
                result.add(n);
            }
        }
    }
}