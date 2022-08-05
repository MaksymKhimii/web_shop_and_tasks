package com.epam.khimii.task1.list;

import com.epam.khimii.task1.entity.Product;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * A resizable array-based interface implementation.
 * Has a capacity that expands when the size of the collection reaches it.
 * The default capacity is 10 cells. Is a generic for the product class and its descendants.
 * Contains basic methods for working with a list: get,clear, set, add, remove, indexOf, contains.
 * listIterator and sublist are unsupported.
 * Has methods for addition, removing and retain collection.
 * Has private method for checking object for null, which throw NullPointerException if object is null.
 * Has two iterator. First is simple iterator without some condition.
 * Second iterator with condition, which iterates element, that meets the condition.
 *
 * @author Maksym Khimii
 * @see Product, List
 */
public class ProductArrayList<E extends Product> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int EXTENSION_MULTIPLIER = 2;
    private E[] array;
    private int size;

    public ProductArrayList() {
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
            E[] newArray = (E[]) new Object[this.array.length * EXTENSION_MULTIPLIER];
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
        if (checkIndex(indexOf(o))) {
            remove(indexOf(o));
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
        return -1;
    }

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
        return this.size == 0;
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

    @Override
    public Iterator<E> iterator() {
        return new ProductConditionIterator();
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
        if (size == array.length) {
            E[] newArray = (E[]) new Object[array.length * EXTENSION_MULTIPLIER];
            System.arraycopy(array, 0, newArray, 0, size);
            newArray[size] = e;
            array = newArray;
        } else {
            array[size] = e;
        }
        ++this.size;
        return true;
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
        checkNull(c);
        for (E temp : c) {
            add(temp);
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
        boolean flag = false;
        for (Object temp : c) {
            if (remove(temp)) {
                flag = true;
            }
        }
        return flag;
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