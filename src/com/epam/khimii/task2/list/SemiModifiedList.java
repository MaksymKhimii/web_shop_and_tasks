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

    ProductArrayList<E> mutable;
    ProductArrayList<E> immutable;
    private int immutableIndex;


    public SemiModifiedList() {
        mutable = new ProductArrayList<>();
    }

    public SemiModifiedList(ProductArrayList<E> immutable, ProductArrayList<E> mutable) {
        this.immutable = immutable;
        immutableIndex = immutable.size();
        this.mutable = mutable;
    }

    @Override
    public int size() {
        return immutable.size() + mutable.size();
    }

    @Override
    public boolean isEmpty() {
        return immutable.isEmpty() && mutable.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return immutable.contains(o) || mutable.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return mutable.iterator();
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
        if (e != null) {
            return mutable.add(e);
        } else {
            throw new UnsupportedOperationException();
        }

    }

    @Override
    public boolean remove(Object o) {
        if (mutable.contains(o)) {
            remove(indexOf(o));
            return true;
        }
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        if (c != null) {
            return immutable.containsAll(c) || mutable.containsAll(c);
        }
        return false;
    }


    @Override
    public boolean addAll(Collection<? extends E> c) {
        return mutable.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if (IsMutable(index)) {
            return mutable.addAll(index - mutable.size(), c);
        }
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object item : c) {
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
        if (index <= size()) {
            if (index < immutable.size()) {
                int count = 0;
                for (E p : immutable) {
                    if (count == index) {
                        return p;
                    }
                    count++;
                }
            } else {
                int count = immutable.size();
                for (E p : mutable) {
                    if (count == index) {
                        return p;
                    }
                    count++;
                }
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public E set(int index, E element) {
        int NewIndex;
        if (IsMutable(index)) {
            if (index == immutable.size()) {
                System.out.println("aslml: " + immutable.size());
                mutable.set(0, element);
            } else {
                NewIndex = immutable.size() + index - 2;
                System.out.println("NewIndex:" + NewIndex);
                mutable.set(NewIndex, element);
            }
            return element;
        }
        throw new UnsupportedOperationException();
    }


    @Override
    public void add(int index, E element) {
        if (IsMutable(index)) {
            mutable.add(index - immutable.size(), element);
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        if ((IsMutable(index))) {
            return mutable.remove(index - immutable.size());
        }
        throw new UnsupportedOperationException();
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
        if (immutable.contains(o)) {
            return immutable.lastIndexOf(o);
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
        List<E> list = new ProductArrayList<>();
        if (!IsMutable(fromIndex) && !IsMutable(toIndex)) {
            while (fromIndex <= toIndex) {
                list.add(immutable.get(fromIndex));
                fromIndex++;
            }
            return list;
        }
        if (IsMutable(fromIndex) && IsMutable(toIndex)) {
            while (fromIndex <= toIndex) {
                list.add(mutable.get(fromIndex));
                fromIndex++;
            }
            return list;
        }

        while (fromIndex <= immutable.size()) {
            list.add(immutable.get(fromIndex));
            fromIndex++;
        }
        while (fromIndex <= toIndex) {
            list.add(mutable.get(fromIndex));
            fromIndex++;
        }
        return list;

    }

    public boolean IsMutable(int index) {
        return (index < 0) || (index >= immutable.size());
    }

}
