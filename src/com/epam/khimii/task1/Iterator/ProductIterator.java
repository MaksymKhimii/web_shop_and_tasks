package com.epam.khimii.task1.Iterator;


import com.epam.khimii.task1.Entity.Product;
import com.epam.khimii.task1.List.ProductArrayList;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An iterator over a collection of products.
 * An iterator contains methods for checking if there is a next item in the collection
 * and returning a boolean value, and for getting the next item from the collection.
 * @see ProductArrayList, Iterator, Iterable
 * @author Maksym Khimii
 * @param <E> – the type of elements returned by this iterator
 */
public class ProductIterator <E extends Product> implements Iterator<E> {
    protected ProductArrayList<E> productArrayList;
    protected int index;

    public ProductIterator(ProductArrayList<E> productArrayList) {
        this.productArrayList = productArrayList;
        this.index = -1;
    }

    @Override
    public boolean hasNext() {
        return index < productArrayList.size() - 1;
    }

    @Override
    public E next() {
        if (hasNext()) {
            return productArrayList.get(++index);
        }
        throw new NoSuchElementException();
    }
}

