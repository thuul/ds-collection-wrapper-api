/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.generics.demo;

/**
 *
 * @author Ikram
 * @param <T>
 */
public interface Element<T> {

    /**
     *
     * @return T
     */
    T getElementContent();

    /**
     *
     * @param elementContent
     */
    void setElementContent(T elementContent);

    /**
     *
     */
    void analyse();
}
