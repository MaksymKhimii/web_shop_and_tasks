package com.epam.khimii.task4.repository;


import com.epam.khimii.task4.entity.Buffer;

public class BufferRepository {
    private static final Buffer buffer = new Buffer();

    public static void addToBasketBuffer(String name, int quantity) {
        if (buffer.size() == 3) {
            buffer.remove(Buffer.getFirstInBuffer());
        }
        buffer.put(name, quantity);
    }

    public static void printBuffer() {
        if (buffer.size() == 0) {
            System.out.println("История отсутствует(");
            return;
        }
        System.out.println("Последние " + buffer.size() + " products в корзине:");
        Buffer.print(buffer);
    }
}
