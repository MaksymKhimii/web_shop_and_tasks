package com.epam.khimii.task8.searchingSimpleNumbers.threads;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import com.epam.khimii.task8.searchingSimpleNumbers.SimpleNumber;

/**
 * MuyThread with one container for saving data
 */
public class ThreadForSearchWithSingleCollection extends Thread {
    private final int localMin;
    private final int localMax;
    private final ResultContainer result;

    public ThreadForSearchWithSingleCollection(int LocalMin, int LocalMax, ResultContainer result) {
        this.localMin = LocalMin;
        this.localMax = LocalMax;
        this.result = result;
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