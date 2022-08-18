package com.epam.khimii.task5.readFileWrapper;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReadTextFileWrapper implements Iterable<String>, Closeable {
    private RandomAccessFile sc;

    public ReadTextFileWrapper(String fileName) {
        try {
            sc = new RandomAccessFile(new File(fileName), "r");
        } catch (FileNotFoundException e) {
            System.out.println("File with this name was not found!");
            e.printStackTrace();
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new FileIterator();
    }

    @Override
    public void close() throws IOException {
        sc.close();
    }

    private class FileIterator implements Iterator<String> {
        private String line;

        public FileIterator() {
            try {
                line = sc.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            return line != null;
        }

        @Override
        public String next() {
            if (hasNext()) {
                String temp = line;
                try {
                    line = sc.readLine();
                } catch (IOException e) {
                    System.out.println("Line not found");
                    e.printStackTrace();
                }
                return temp;
            }
            throw new NoSuchElementException();
        }
    }
}