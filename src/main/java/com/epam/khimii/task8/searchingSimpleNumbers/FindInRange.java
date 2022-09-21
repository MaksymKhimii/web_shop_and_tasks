package com.epam.khimii.task8.searchingSimpleNumbers;

import com.epam.khimii.task8.searchingSimpleNumbers.search.ExecutorsSearchWithSingleCollection;
import com.epam.khimii.task8.searchingSimpleNumbers.search.ExecutorsSearchWithMultipleCollection;
import com.epam.khimii.task8.searchingSimpleNumbers.search.MultithreadedSearchWithSingleCollection;
import com.epam.khimii.task8.searchingSimpleNumbers.search.MultithreadedSearchWithMultipleCollection;
import com.epam.khimii.task8.searchingSimpleNumbers.search.Search;

import java.util.Scanner;

public class FindInRange {
    private final Scanner scanner = new Scanner(System.in);

    public synchronized void start() {
        System.out.println("Enter the range of numbers(2 numbers)");
        int min = NumberUtil.getNumber(scanner.nextLine());
        int max = NumberUtil.getNumber(scanner.nextLine());
        System.out.println("Enter the thread count");
        int threadCount = NumberUtil.getNumber(scanner.nextLine());
        if (threadCount <= 0) {
            try {
                throw new Exception("Wrong count of threads");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        ResultContainer resultContainer = new ResultContainer();
        System.out.println("Are you want to use Threads or Executors?(1/0)");
        int choiceOfMethod = NumberUtil.getNumber(scanner.nextLine());
        System.out.println("""
                Choose how to generate the result:
                -using one collection(1)
                -using more than one collections in every thread(0)""");
        int choiceOfResult = NumberUtil.getNumber(scanner.nextLine());
        Search search;
        if (choiceOfMethod == 1) {
            if (choiceOfResult == 1) {
                search = new MultithreadedSearchWithSingleCollection(min, max, threadCount, resultContainer);
            } else {
                search = new MultithreadedSearchWithMultipleCollection(min, max, threadCount, resultContainer);
            }
        } else if (choiceOfResult == 1) {
            search = new ExecutorsSearchWithSingleCollection(min, max, threadCount, resultContainer);
        } else {
            search = new ExecutorsSearchWithMultipleCollection(min, max, threadCount, resultContainer);
        }
        search.startSearching();
        System.out.println(resultContainer.getResult());
    }
}