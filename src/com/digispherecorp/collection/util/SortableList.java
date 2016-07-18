/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.util;

import com.digispherecorp.collection.util.exception.EmptyCollectionException;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author walle
 * @param <E>
 *
 * <p>
 *
 * custom Java Collection's interface implementation analogous to HashSet but
 * directly extending the Collection interface. The interface is designed to
 * accept duplicates but not Null entries. This interface holds elements
 * internally in Nodes which are held together by connecting Head and Tail
 * Nodes.
 *
 *
 * <p>
 * @see Collection
 * @see AbstractCollection
 * @see Set
 *
 *
 *
 */
public class SortableList<E> implements SortableCollection<E> {

    private ListNode<E> head;
    private ListNode<E> tail;
    private int size;
    private Comparator<E> comparator;

    public SortableList() {
    }

    public SortableList(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public SortableList(Collection<E> collection) {
        addAll(collection);
    }

    public SortableList(SortableList<E> list) {
        addAll(list);
    }

    private void rearrangeNode(Object[] a) {
        head = null;
        tail = null;
        size = 0;
        for (Object obj : a) {
            if (obj != null) {
                add((E) obj);
            }
        }
    }

    @Override
    public void sort() {
        Object[] a = this.toArray();
        Arrays.sort(a);
        rearrangeNode(a);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        Object[] a = this.toArray();
        Arrays.sort(a, (Comparator) c);
        rearrangeNode(a);
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

            private ListNode<E> innerNode;
            private ListNode<E> remNode;
            private E element;

            {
                innerNode = head;
            }

            @Override
            public boolean hasNext() {
                if (innerNode != null) {
                    remNode = innerNode;
                    element = remNode.element;
                    innerNode = innerNode.next;
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                return element;
            }

            @Override
            public void remove() {
                ListNode prevNode = remNode.precedeNode;
                ListNode nextNode = remNode.next;
                if (prevNode == null && nextNode == null) {
                    head = null;
                    tail = null;
                } else if (prevNode == null) {
                    nextNode.precedeNode = null;
                    head = nextNode;
                    remNode.next = null;
                    remNode = null;
                } else if (nextNode == null) {
                    prevNode.next = null;
                    remNode = null;
                } else {
                    prevNode.next = nextNode;
                    nextNode.precedeNode = prevNode;
                    remNode = null;
                }
                size--;
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
        ListNode node = head;
        while (node != null) {
            toArray[arraySize] = node.element;
            node = node.next;
            arraySize++;
        }
        return toArray;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (size == 0) {
            throw new EmptyCollectionException();
        }
        int arraySize = 0;
        T[] toArray = a;
        ListNode node = head;
        while (node != null) {
            toArray[arraySize] = (T) node.element;
            node = node.next;
            arraySize++;
        }
        return toArray;
    }

    @Override
    public boolean add(E e) {
        if (e == null) {
            throw new NullPointerException();
        }
        boolean add;
        ListNode<E> newNode = new ListNode<>(e);
        if (head == null) {
            head = newNode;
            add = true;
        } else if (tail == null) {
            head.next = newNode;
            newNode.precedeNode = head;
            tail = newNode;
            add = true;
        } else {
            tail.next = newNode;
            newNode.precedeNode = tail;
            tail = newNode;
            add = true;
        }
        size++;
        return add;
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

    /**
     *
     * @param c
     * @return boolean
     *
     * <p>
     * DO NOT MODIFY
     */
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
        head = null;
        tail = null;
        size = 0;
    }
}
