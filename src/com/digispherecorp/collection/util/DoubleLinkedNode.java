package com.digispherecorp.collection.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author walle
 * @param <E>
 */
public class DoubleLinkedNode<E> implements INode {

    E element;
    DoubleLinkedNode next;
    DoubleLinkedNode previous;

    public DoubleLinkedNode(E element, DoubleLinkedNode next, DoubleLinkedNode prev) {
        this.element = element;
        this.next = next;
        this.previous = prev;
    }
}
