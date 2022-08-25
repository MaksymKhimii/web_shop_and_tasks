package com.epam.khimii.task4.controller;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            OnlineStore store = new OnlineStore();
            store.choice();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
