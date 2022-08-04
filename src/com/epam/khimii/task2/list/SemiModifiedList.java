package com.epam.khimii.task2.list;

import com.epam.khimii.task1.entity.Product;
import com.epam.khimii.task1.list.ProductArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class SemiModifiedList<E extends Product> implements List<E> {
    private ProductArrayList<E> mutable;
    private ProductArrayList<E> immutable;

    public SemiModifiedList() {
        this.mutable = new ProductArrayList<>();
        this.immutable = new ProductArrayList<>();
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

    private class NewIterator implements Iterator<E> {
        private final Iterator<E> immutableIterator = immutable.iterator();
        private final Iterator<E> mutableIterator = mutable.iterator();

        @Override
        public boolean hasNext() {
            if (!immutableIterator.hasNext()) {
                return mutableIterator.hasNext();
            }
            return true;
        }

        @Override
        public E next() {
            if (!immutableIterator.hasNext()) {
                return mutableIterator.next();
            }
            return immutableIterator.next();
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
        checkImmutableIndex(indexOf(o));
        return mutable.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object object : c) {
            if (!immutable.contains(object) && !mutable.contains(object)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return mutable.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        checkImmutableIndex(index);
        return mutable.addAll(index - immutable.size(), c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object object : c) {
            checkImmutableIndex(indexOf(object));
        }
        return mutable.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object object : c) {
            checkImmutableIndex(indexOf(object));
        }
        return mutable.retainAll(c);
    }

    @Override
    public void clear() {
        mutable.clear();
    }

    @Override
    public E get(int index) {
        checkImmutableIndex(index);
        if (index < immutable.size()) {
            return immutable.get(index);
        }
        return mutable.get(index);
    }

    @Override
    public E set(int index, E element) {
        checkImmutableIndex(index);
        return mutable.set(index, element);
    }

    @Override
    public void add(int index, E element) {
        checkImmutableIndex(index);
        mutable.add(index - immutable.size(), element);
    }

    @Override
    public E remove(int index) {
        checkImmutableIndex(index);
        return mutable.remove(index - immutable.size());
    }

    @Override
    public int indexOf(Object object) {
        if (immutable.contains(object)) {
            return immutable.indexOf(object);
        }
        if (mutable.contains(object)) {
            return mutable.indexOf(object) + immutable.size();
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        checkImmutableIndex(indexOf(object));
        if (mutable.contains(object)) {
            return mutable.lastIndexOf(object) + immutable.size();
        }
        if (immutable.contains(object)) {
            return immutable.lastIndexOf(object);
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

    public void checkImmutableIndex(int index) {
        if (index < immutable.size())
            throw new IllegalArgumentException();
    }
}