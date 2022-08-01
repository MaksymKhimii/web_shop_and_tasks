package com.epam.khimii.task2.list;

import com.epam.khimii.task1.entity.Product;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class CopyOnWriteArrayList<E extends Product> implements List<E> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final int EXTENSION_MULTIPLIER = 2;
    private E[] array;
    private int size;

    public CopyOnWriteArrayList(int unmodifiedElements) {
        array = (E[]) new Product[unmodifiedElements];
    }

    public CopyOnWriteArrayList() {
        array = (E[]) new Product[DEFAULT_CAPACITY];
    }

    @Override
    public void clear() {
        array = (E[]) new Product[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public E get(int index) {
        if (checkIndex(index))
            return array[index];
        throw new NoSuchElementException();
    }

    @Override
    public E set(int index, E element) {
        if (checkIndex(index)) {
            E prevElement = array[index];
            array[index] = element;
            return prevElement;
        }
        throw new NoSuchElementException();
    }

    @Override
    public void add(int index, E element) {
        if (this.array.length == this.size) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) new Object[array.length * EXTENSION_MULTIPLIER];
            System.arraycopy(this.array, 0, newArray, 0, index);
            System.arraycopy(this.array, index, newArray, index + 1, this.size - index);
            this.array = newArray;
        } else {
            System.arraycopy(this.array, index, this.array, index + 1, this.size - index);
        }
        this.array[index] = element;
        ++this.size;
    }

    @Override
    public E remove(int index) {

        if (checkIndex(index)) {
            E temp = array[index];
            System.arraycopy(array, index + 1, array, index, size - index);
            --size;
            return temp;
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean remove(Object o) {
        if ((array.length == 0) || checkIndex(indexOf(o))) {
            return true;
        }
        E[] products = (E[]) new Product[array.length];
        System.arraycopy(array, 0, products, 0, indexOf(o) - 1);
        System.arraycopy(array, indexOf(o) + 1, products, indexOf(o), array.length - indexOf(o) - 2);
        array = products;
        return true;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException();
        //return -1;
    }

    /**
     * This method checks whether the input
     * index is within bounds of the input length:
     */
    public boolean checkIndex(int index) {
        if ((index >= 0) && (index < DEFAULT_CAPACITY)) {
            return true;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; --i) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size > 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }


    private class ProductConditionIterator<E extends Product> implements Iterator<E> {
        private Predicate<E> condition;
        private int index;

        public ProductConditionIterator() {
            this.condition = condition -> true;
        }

        public ProductConditionIterator(Predicate<E> condition) {
            this.condition = condition;
        }

        public boolean hasNext() {
            for (int temp = this.index + 1; temp < array.length; ++temp) {
                if (this.condition.test((E) array[temp])) {
                    return true;
                }
            }
            return false;
        }

        public E next() {
            while (this.index + 1 < array.length) {
                if (this.condition.test(((E) array[++index]))) {
                    return ((E) array[index]);
                }
            }
            throw new NoSuchElementException();
        }
    }


    private E[] ArrayCopy() {
        @SuppressWarnings("unchecked")
        E[] copy = (E[]) new Product[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    private class CopyOnWriteIterator<E extends Product> implements Iterator<E> {
        private int cursor = 0;
        private final E[] snapshot = (E[]) ArrayCopy();
        private final int snapshotSize = size;

        public boolean hasNext() {
            return cursor != snapshotSize;
        }

        @Override
        public E next() {
            if (cursor >= snapshotSize) {
                throw new NoSuchElementException();
            }
            return (E) snapshot[cursor++];
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new CopyOnWriteIterator();
    }

    public Iterator<E> iterator(Predicate<E> condition) {
        return new ProductConditionIterator(condition);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(array, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(array, size, a.getClass());
        }
        System.arraycopy(array, 0, a, 0, size);
        return a;
    }

    @Override
    public boolean add(E e) {

        E[] basketCopy = array.clone();
        if (size >= array.length) {
            extensionArray();
        }
        basketCopy[size] = e;
        size++;
        array = basketCopy;
        return true;
    }

    private void extensionArray() {
        Product[] products = new Product[size * EXTENSION_MULTIPLIER];
        for (int i = 0; i < products.length; i++) {
            if (i < array.length) {
                products[i] = array[i];
            }
            array = (E[]) products;
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        checkNull(c);
        for (Object temp : c) {
            if (!contains(temp)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        for (E item : c) {
            E productItem = item;
            add(productItem);
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkNull(c);
        for (E temp : c) {
            add(index, temp);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        checkNull(c);
        for (Object item : c) {
            if (contains(item)) {
                remove(indexOf(item));
            }
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        checkNull(c);
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if ((!c.contains(array[i])) && (remove(array[i]))) {
                flag = true;
                i--;
            }
        }
        return flag;
    }

    private void checkNull(Object o) {
        if (o == null) {
            throw new NullPointerException();
        }
    }
}
