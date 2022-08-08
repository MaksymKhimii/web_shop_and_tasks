package com.epam.khimii.task3.list;


import com.epam.khimii.task1.entity.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

/**
 * Implementation of a list of products from ArrayList with unique objects
 *
 * @author Maksym Khimii
 */
public class UniqueProductArrayList<E extends Product> extends ArrayList<E> {

    public UniqueProductArrayList() {
    }

    @Override
    public E set(int index, E element) {
        checkElement(element);
        return super.set(index, element);
    }

    @Override
    public boolean add(E e) {
        checkElement(e);
        return super.add(e);
    }

    @Override
    public void add(int index, E element) {
        checkElement(element);
        super.add(index, element);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean flag = false;
        for (E temp : c) {
            if (add(temp))
                flag = true;
        }
        return flag;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        for (E temp : c) {
            add(index++, temp);
        }
        return true;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        int index = -1;
        for (E p : this) {
            Product product = new Product(p.getName(), p.getPrice(), p.getCountry());
            set(++index, operator.apply((E) product));
        }
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    /**
     * method for checking is this element exists in collection
     */
    private void checkElement(E element) {
        if (contains(element)) {
            throw new IllegalArgumentException("This element already exists");
        }
    }
}
