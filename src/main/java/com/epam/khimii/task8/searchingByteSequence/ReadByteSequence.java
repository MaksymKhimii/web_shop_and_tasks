package com.epam.khimii.task8.searchingByteSequence;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ReadByteSequence {
    private Sequence sequence;

    public synchronized Sequence getSequence() {
        return sequence;
    }

    public String readFile(File file) throws IOException {
        if (!file.isFile()) {
            throw new IllegalArgumentException();
        }
        byte[] byteArray = new byte[255];
        byte b;
        FileInputStream is = new FileInputStream(file);
        while (true) {
            b = (byte) is.read();
            if (b == -1) break;
            byteArray[b]++;
        }
        is.close();
        return new String(byteArray, StandardCharsets.UTF_8);
    }

    public void findLongestSequence(String line) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> future;
        ThreadForSearch thread = new ThreadForSearch(line);
        future = executorService.submit(thread);
        System.out.println("Main thread is waiting");
        while (!future.isDone()) {
            System.out.println(thread.getCurrentSize());
        }
        sequence = thread.getSequence();
    }
}