package com.epam.khimii.task8.searchingSimpleNumbers.search;

import com.epam.khimii.task8.searchingSimpleNumbers.ResultContainer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExecutorsSearchWithSingleCollectionTest {
    private ExecutorsSearchWithSingleCollection executorsSearchWithSingleCollection;
    private ResultContainer resultContainer;
    private int min;
    private int max;
    private int threadCount;
    private List<Integer> expected;

    @Before
    public void beforeTest() {
        resultContainer = new ResultContainer();
        expected = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37));
    }

    @Test
    public void shouldFindSimpleNumbersTest() {
        min = 1;
        max = 40;
        threadCount = 2;
        executorsSearchWithSingleCollection = new ExecutorsSearchWithSingleCollection(min, max, threadCount, resultContainer);
        try {
            executorsSearchWithSingleCollection.startSearching();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(expected, Arrays.asList(resultContainer.getResult().stream().sorted().toArray()));
    }

    @Test(expected = Exception.class)
    public void shouldWarnAboutIncorrectCountOfThreadsTest() throws Exception {
        min = 1;
        max = 40;
        threadCount = 0;
        executorsSearchWithSingleCollection = new ExecutorsSearchWithSingleCollection(min, max, threadCount, resultContainer);
        executorsSearchWithSingleCollection.startSearching();
        Thread.sleep(2000);
    }
}