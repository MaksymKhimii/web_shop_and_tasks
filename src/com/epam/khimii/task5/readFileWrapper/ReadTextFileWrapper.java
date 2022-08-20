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
        public FileIterator() {
            try {
                sc.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean hasNext() {
            try {
                String s = String.valueOf(sc.read());
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }

        @Override
        public String next() {
            if (hasNext()) {
                try {
                    return sc.readLine();
                } catch (IOException e) {
                    try {
                        throw new LineNotFoundException("Line not found");
                    } catch (LineNotFoundException ex) {
                        ex.printStackTrace();
                    }
                    e.printStackTrace();
                }
            }
            throw new NoSuchElementException();
        }
    }
}