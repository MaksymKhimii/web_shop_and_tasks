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
 * @see Product, List
 * @author Maksym Khimii
 */

public class ProductArrayList <E extends Product> implements List<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int EXTENSION_MULTIPLIER = 2;
    private E[] array;
    private int size;
    Predicate<E> condition;
    protected ProductArrayList<E> productArrayList;
    protected int index;

    public ProductArrayList(Predicate<E> condition, int index, ProductArrayList<E> productArrayList) {
        this.productArrayList = productArrayList;
        this.index = -1;
        this.condition = condition;
    }

    public ProductArrayList() {
        array = (E[]) new Product[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public void clear() {
        array = (E[]) new Product[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public E get(int index) {
        if(index<=DEFAULT_CAPACITY)
            return array[index];
        throw new NoSuchElementException();
    }

    @Override
    public E set(int index, E element) {
        if(index<=DEFAULT_CAPACITY){
            array[index] = element;
            return array[index];
        }
        throw new NoSuchElementException();
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

    private void extensionArray() {
        E[] newArray = (E[]) new Object[array.length * EXTENSION_MULTIPLIER];
        for (int i = 0; i < newArray.length; i++) {
            if (i < array.length) {
                newArray[i] = array[i];
            }
            array = (E[]) newArray;
        }
    }

    @Override
    public E remove(int index) {
        if(index<=DEFAULT_CAPACITY) {
            E temp = array[index];
            System.arraycopy(array, index + 1, array, index, size - index);
            --size;
            return temp;
        }
        throw new NoSuchElementException();
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(array[i], o)) {
                remove(i);
                return true;
            }
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
        return indexOf(size)==0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; ++i) {
            if (Objects.equals(array[i], o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

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
        };
    }

    public Iterator<E> conditionIterator(Predicate<E> predicate) {
        return new Iterator<E>() {
            protected ProductArrayList<E> productArrayList;
            protected int index;
            Predicate<E> condition;

            public boolean hasNext() {
                for (int temp = index+1; temp < productArrayList.size(); ++temp) {
                    if (condition.test((E) productArrayList.toArray()[temp])) {
                        return true;
                    }
                }
                return false;
            }

            public E next() {
                while (index + 1 < productArrayList.size()) {
                    if (condition.test(((E) productArrayList.toArray()[++index]))) {
                        return ((E) productArrayList.toArray()[index]);
                    }
                }
                throw new NoSuchElementException();
            }
        };
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
