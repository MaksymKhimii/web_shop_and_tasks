package com.epam.khimii.task2.list;

import com.epam.khimii.task1.entity.Product;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class CopyOnWriteArrayList<E extends Product> implements List<E> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final int EXTENSION_MULTIPLIER = 2;
    private E[] array;
    private int size;

    public CopyOnWriteArrayList(int immutableCount) {
        array = (E[]) new Product[immutableCount];
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
        checkIndex(index);
        createArrayCopy();
        return array[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        createArrayCopy();
        E prevElement = array[index];
        array[index] = element;
        return prevElement;
    }

    @Override
    public void add(int index, E element) {
        checkIndex(index);
        createArrayCopy();

        if (array.length == size) {
            @SuppressWarnings("unchecked")
            E[] newArray = (E[]) new Object[array.length * EXTENSION_MULTIPLIER];
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, index, newArray, index + 1, size - index);
            array = newArray;
        } else {
            System.arraycopy(array, index, array, index + 1, size - index);
        }
        array[index] = element;
        ++size;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        createArrayCopy();
        E temp = array[index];
        System.arraycopy(array, index + 1, array, index, size - index);
        --size;
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        createArrayCopy();
        if (indexOf(o) != -1) {
            E[] products = (E[]) new Product[array.length];
            System.arraycopy(array, 0, products, 0, indexOf(o) - 1);
            System.arraycopy(array, indexOf(o) + 1, products, indexOf(o), array.length - indexOf(o) - 2);
            array = products;
            return true;
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(array[i], o)) {
                return i;
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public void checkIndex(int index) {
        if (index < 0 || index >= size())
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
        return size > 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    private void createArrayCopy() {
        array = Arrays.copyOf(array, array.length);
    }

    private class CopyOnWriteIterator implements Iterator<E> {
        private int cursor = 0;
        private final E[] snapshot = array;
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
