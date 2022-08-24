package com.epam.khimii.task4.file_handler;

import com.epam.khimii.task1.entity.Product;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class FileHandler implements Serializable {
    public void save(List<Product> products, String path) throws IOException {
        OutputStream os = new FileOutputStream(path);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(products);
        oos.close();
    }

    public List<Product> load(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Product> products = new ArrayList<>((Collection<? extends Product>) ois.readObject());
        ois.close();
        return products;
    }
}
