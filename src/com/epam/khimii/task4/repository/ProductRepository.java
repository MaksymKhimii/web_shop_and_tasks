package com.epam.khimii.task4.repository;

import com.epam.khimii.task1.list.ProductArrayList;
import com.epam.khimii.task4.entity.Products;

import java.util.ArrayList;


public class ProductRepository {
    private static final Products product1 = new Products("apple", 11.0, "uk");
    private static final Products product2 = new Products("banana", 12.0, "uk");
    private static final Products product3 = new Products("potato", 13.0, "uk");
    private static final Products product4 = new Products("tomato", 14.0, "uk");
    public static ArrayList<Products> products = new ArrayList<>();
    //public static ProductArrayList<Products> products = new ProductArrayList<>();

    public static void add(Products p) {
        products.add(p);
    }

    public static void addAll() {
        add(product1);
        add(product2);
        add(product3);
        add(product4);
    }

    public static void printProducts() {
        addAll();
        System.out.println("Доступные продукты: ");
        for (Products p : products) {
            System.out.println(p);
        }
        System.out.println("\n");
    }

    static boolean isExists(String name) {
        for (Products product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}