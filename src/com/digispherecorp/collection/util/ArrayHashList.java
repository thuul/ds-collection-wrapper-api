/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.util;

import com.digispherecorp.collection.util.exception.EmptyCollectionException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author walle
 * <p>
 * Created on Jul 17, 2016, 1:15:06 AM
 * @param <E>
 *
 */
public class ArrayHashList<E> implements SortedCollection<E> {

    private int arrayCapacity;
    private int size;
    public E[] innerArray;
    private Comparator<E> comparator;
    final private int INCRM_INITIAL = 25;

    public ArrayHashList() {
        innerArray = (E[]) new Object[arrayCapacity = INCRM_INITIAL];
    }

    public ArrayHashList(int initialCapacity) {
        innerArray = (E[]) new Object[arrayCapacity = initialCapacity];
    }

    public ArrayHashList(Comparator<E> comparator) {
        this();
        this.comparator = comparator;
    }

    public ArrayHashList(Collection<E> collection) {
        this();
        addAll(collection);
    }

    public ArrayHashList(ArrayHashList<E> list) {
        this();
        addAll(list);
    }

    private E[] trimCapacity() {
        if (innerArray.length == 0) {
            throw new EmptyCollectionException();
        }
        int srcArray = 0;
        int destArray = 0;
        Object[] toArray = new Object[size];
        for (Object o : innerArray) {
            if (o != null) {
                toArray[destArray] = innerArray[srcArray];
                destArray++;
            }
            srcArray++;
        }
        return (E[]) toArray;
    }

    @Override
    public void sort() {
        Object[] a = this.toArray();
        Arrays.sort(a);
        innerArray = (E[]) a;
        size = arrayCapacity = a.length;
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        innerArray = (E[]) a;
        size = arrayCapacity = a.length;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        Object[] a = toArray();
        Arrays.sort(a);
        int binarySearch = Arrays.binarySearch(a, o);
        return (binarySearch >= 0);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private E element;
            private int position;
            private int remvElement;
            private boolean removed;

            {
                this.element = null;
                this.position = 0;
                this.remvElement = 0;
                this.removed = false;
            }

            @Override
            public boolean hasNext() {
                if (position < size) {
                    if (innerArray[position] != null) {
                        this.element = innerArray[position];
                        position++;
                        return true;
                    }
                } else if (removed) {
                    size -= remvElement;
                    arrayCapacity = size;
                    innerArray = trimCapacity();
                }
                return false;
            }

            @Override
            public E next() {
                return element;
            }

            @Override
            public void remove() {
                innerArray[position - 1] = null;
                remvElement++;
                if (removed != true) {
                    removed = Boolean.TRUE;
                }
            }
        };
    }

    @Override
    public Object[] toArray() {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        int arraySize = 0;
        Object[] toArray = new Object[size];
        for (int i = 0; i < size; i++) {
            Object o = innerArray[arraySize];
            if (o != null) {
                toArray[arraySize] = o;
                arraySize++;
            }
        }
        return toArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        int sizeInner = a.length;
        int arraySize = 0;
        T[] toArray = a;
        for (int i = 0; i < sizeInner; i++) {
            Object o = innerArray[arraySize];
            if (o != null) {
                toArray[arraySize] = (T) o;
                arraySize++;
            }
        }
        return toArray;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (size < arrayCapacity) {
            innerArray[size++] = e;
        } else {
            E[] temp = (E[]) new Object[arrayCapacity += INCRM_INITIAL];
            System.arraycopy(innerArray, 0, temp, 0, innerArray.length);
            innerArray = temp;
            innerArray[size++] = e;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        boolean remove = false;
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(o)) {
                iterator.remove();
                if (remove != true) {
                    remove = Boolean.TRUE;
                }
            }
        }
        return remove;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        int i = 0;
        Object[] toArray = toArray();
        boolean[] eval = new boolean[c.size()];
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            for (Object o : toArray) {
                if (next.equals(o)) {
                    eval[i] = true;
                    break;
                }
            }
            i++;
        }
        for (boolean b : eval) {
            if (b == false) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final boolean addAll(Collection<? extends E> c) {
        boolean adds = false;
        for (E e : c) {
            add(e);
            if (adds != true) {
                adds = true;
            }
        }
        return adds;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        boolean removes = false;
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Iterator<E> innerIterator = iterator();
            while (innerIterator.hasNext()) {
                E e = innerIterator.next();
                if (e.equals(next)) {
                    innerIterator.remove();
                    if (removes != true) {
                        removes = true;
                    }
                }
            }
        }
        return removes;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        boolean retains = false;
        boolean m = false;
        Object[] toArray = c.toArray();
        Iterator<E> innerIt = iterator();
        while (innerIt.hasNext()) {
            E next = innerIt.next();
            for (Object o : toArray) {
                if (next.equals(o)) {
                    m = true;
                    break;
                }
            }
            if (m == false) {
                innerIt.remove();
                if (retains != true) {
                    retains = true;
                }
            }
            m = false;
        }
        return retains;
    }

    @Override
    public void clear() {
        innerArray = (E[]) new Object[arrayCapacity = INCRM_INITIAL];
        size = 0;
    }

}
