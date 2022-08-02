package com.epam.khimii.task2.list;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task1.list.ProductArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;


public class SemiModifiedList<E extends Product> implements List<E> {

    private ProductArrayList<E> mutable;
    private ProductArrayList<E> immutable;


    public SemiModifiedList() {
        mutable = new ProductArrayList<>();
    }

    public SemiModifiedList(ProductArrayList<E> immutable, ProductArrayList<E> mutable) {
        this.immutable = immutable;
        this.mutable = mutable;
    }

    @Override
    public int size() {
        return immutable.size() + mutable.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }


    private class NewIterator<E extends Product> implements Iterator<E> {

        private int cursor = 0;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public E next() {
            if (hasNext()) {
                if (cursor < immutable.size()) {
                    return (E) immutable.get(cursor++);
                }
                return (E) mutable.get(cursor++ - immutable.size());
            }
            throw new NoSuchElementException();
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new NewIterator();
    }


    @Override
    public Object[] toArray() {
        return new Object[size()];
    }


    @Override
    public <T> T[] toArray(T[] a) {
        return (T[]) Arrays.stream(a).toArray();
    }


    @Override
    public boolean add(E e) {
        return mutable.add(e);
    }

    @Override
    public boolean remove(Object o) {
        isMutable(indexOf(o));
        mutable.remove(o);
        return true;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        return immutable.containsAll(c) || mutable.containsAll(c);
    }


    @Override
    public boolean addAll(Collection<? extends E> c) {
        return mutable.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        isMutable(index);
        return mutable.addAll(index - mutable.size(), c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object item : c) {
            isMutable(indexOf(c));
            remove(item);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return mutable.retainAll(c);
    }

    @Override
    public void clear() {
        mutable.clear();
    }

    @Override
    public E get(int index) {
        if (index < immutable.size()) {
            return immutable.get(index);
        } else {
            return mutable.get(index);
        }
    }

    @Override
    public E set(int index, E element) {
        isMutable(index);
        return mutable.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        isMutable(index);
        mutable.add(index - immutable.size(), element);
    }

    @Override
    public E remove(int index) {
        isMutable(index);
        return mutable.remove(index - immutable.size());
    }

    @Override
    public int indexOf(Object o) {
        if (immutable.contains(o)) {
            return immutable.indexOf(o);
        }
        if (mutable.contains(o)) {
            return mutable.indexOf(o) + immutable.size();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (mutable.contains(o)) {
            return mutable.lastIndexOf(o) + immutable.size();
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

    public void isMutable(int index) {
        if ((index < 0) || (index >= immutable.size())) {
            throw new IllegalArgumentException();
        }
    }
}
