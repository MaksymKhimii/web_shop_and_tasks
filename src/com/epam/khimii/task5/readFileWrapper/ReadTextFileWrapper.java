package com.epam.khimii.task5.readFileWrapper;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ReadTextFileWrapper implements Iterable<String>, Closeable {
    private final RandomAccessFile sc;

    public ReadTextFileWrapper(String fileName) {
        try {
            sc = new RandomAccessFile(new File(fileName), "r");
        } catch (FileNotFoundException e) {
            throw new FileStateException("File was not found");
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
        @Override
        public boolean hasNext() {
            try {
                return sc.read() != -1;
            } catch (IOException e) {
                throw new FileStateException("Line not found");
            }
        }

        @Override
        public String next() {
            if (hasNext()) {
                try {
                    return sc.readLine();
                } catch (IOException e) {
                    throw new FileStateException("Line not found");
                }
            }
            throw new NoSuchElementException();
        }
    }
}