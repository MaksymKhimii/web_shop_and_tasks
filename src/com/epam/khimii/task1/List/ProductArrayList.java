package com.epam.khimii.task1.List;

import com.epam.khimii.task1.Entity.Product;
import com.epam.khimii.task1.Iterator.ProductConditionalIterator;
import com.epam.khimii.task1.Iterator.ProductIterator;

import java.lang.reflect.Array;
import java.util.*;
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
 * @see Product, List
 * @author Maksym Khimii
 */

public class ProductArrayList <E extends Product> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private E[] array;
    private int size;

    public ProductArrayList() {
        this.array = (E[]) new Product[DEFAULT_CAPACITY];
        this.size = 0;
    }

    public ProductArrayList(Class<E> dataType, int capacity) {
        this.array = (E[]) Array.newInstance(dataType, capacity);
        this.size = 0;
    }

    @Override
    public void clear() {
        this.array = (E[]) new Product[DEFAULT_CAPACITY];
        this.size = 0;
    }

    @Override
    public E get(int index) {
        return this.array[index];
    }

    @Override
    public E set(int index, E element) {
        this.array[index] = element;
        return this.array[index];
    }

    @Override
    public void add(int index, E element) {
        if (this.array.length == this.size) {
            E[] newArray = (E[]) new Object[this.array.length * 2];
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
        E temp = this.array[index];
        System.arraycopy(this.array, index + 1, this.array, index, this.size - index);
        --this.size;
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < this.size; ++i) {
            if (Objects.equals(this.array[i], o)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this.size; ++i) {
            if (Objects.equals(this.array[i], o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = this.size - 1; i >= 0; --i) {
            if (Objects.equals(this.array[i], o)) {
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
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < this.size; ++i) {
            if (Objects.equals(this.array[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new ProductIterator<>(this);
    }

    public Iterator<E> conditionIterator(Predicate<E> predicate) {
        return new ProductConditionalIterator<>(predicate, this);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < this.size) {
            return (T[]) Arrays.copyOf(this.array, this.size, a.getClass());
        } else {
            System.arraycopy(this.array, 0, a, 0, this.size);
            if (a.length > this.size) {
                a[this.size] = null;
            }
            return a;
        }
    }

    @Override
    public boolean add(E e) {
        if (this.size == this.array.length) {
            E[] newArray = (E[]) new Object[this.array.length * 2];
            System.arraycopy(this.array, 0, newArray, 0, this.size);
            newArray[this.size] = e;
            this.array = newArray;
        } else {
            this.array[this.size] = e;
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
            if (!c.contains(array[i])) {
                if (remove(array[i])) {
                    flag = true;
                    i--;
                }
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
