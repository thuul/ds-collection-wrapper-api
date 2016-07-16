/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.generics.demo;

/**
 *
 * @author walle
 * @param <T>
 */
public abstract class AbstractElement<T> implements Element<T> {

    private T elementContent;

    public AbstractElement(T elementContent) {
        this.elementContent = elementContent;
    }

    @Override
    public T getElementContent() {
        return elementContent;
    }

    @Override
    public void setElementContent(T elementContent) {
        this.elementContent = elementContent;
    }

}
