/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.util;

/**
 *
 * @author walle
 */
import java.util.NoSuchElementException;

public class DoubleLinkedListImpl<E> {

    private DoubleLinkedNode head;
    private DoubleLinkedNode tail;
    private int size;

    public DoubleLinkedListImpl() {
        size = 0;
    }

    /**
     * returns the size of the linked list
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * return whether the list is empty or not
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * adds element at the starting of the linked list
     *
     * @param element
     */
    public void addFirst(E element) {
        
        DoubleLinkedNode tmp = new DoubleLinkedNode(element, head, null);
        if (head != null) {
            head.previous = tmp;
        }
        head = tmp;
        if (tail == null) {
            tail = tmp;
        }
        size++;
    }

    /**
     * adds element at the end of the linked list
     *
     * @param element
     */
    public void addLast(E element) {

        DoubleLinkedNode tmp = new DoubleLinkedNode(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
    }

    /**
     * this method walks forward through the linked list
     */
    public void iterateForward() {
        
        DoubleLinkedNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
        }
    }

    /**
     * this method walks backward through the linked list
     */
    public void iterateBackward() {
        
        DoubleLinkedNode tmp = tail;
        while (tmp != null) {
            tmp = tmp.previous;
        }
    }

    /**
     * this method removes element from the start of the linked list
     *
     * @return
     */
    public E removeFirst() {
        
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DoubleLinkedNode<E> tmp = head;
        head = head.next;
        head.previous = null;
        size--;
        return tmp.element;
    }

    /**
     * this method removes element from the end of the linked list
     *
     * @return
     */
    public E removeLast() {
        
        if (size == 0) {
            throw new NoSuchElementException();
        }
        DoubleLinkedNode<E> tmp = tail;
        tail = tail.previous;
        tail.next = null;
        size--;
        return tmp.element;
    }

    public static void main(String a[]) {

        DoubleLinkedListImpl<Integer> dll = new DoubleLinkedListImpl<>();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.addFirst(5);
        dll.addFirst(6);
        dll.addFirst(7);
        dll.addFirst(8);
        dll.addFirst(9);
        dll.addFirst(10);
        System.out.println(dll.size());
        dll.iterateForward();
        dll.removeFirst();
        dll.removeLast();
        dll.iterateBackward();
    }
}
