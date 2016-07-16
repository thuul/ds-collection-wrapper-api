/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.util;

/**
 *
 * @author walle
 * @param <E>
 */
public class ListNode<E> implements INode<E> {

    E element;
    ListNode next;
    ListNode precedeNode;

    public ListNode(E element) {
        this.element = element;
    }
}
