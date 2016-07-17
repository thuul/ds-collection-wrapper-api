/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.util.exception;

import java.util.NoSuchElementException;

/**
 *
 * @author walle
 * <p>
 * Created on Jul 17, 2016, 12:14:09 AM
 *
 */
public class EmptyCollectionException extends NoSuchElementException {

    /**
     * Constructs a <code>EmptyCollectionException</code> with <tt>null</tt>
     * as its error message string.
     */
    public EmptyCollectionException() {
        super();
    }

    /**
     * Constructs a <code>EmptyCollectionException</code>, saving a reference to
     * the error message string <tt>s</tt> for later retrieval by the
     * <tt>getMessage</tt> method.
     *
     * @param s the detail message.
     */
    public EmptyCollectionException(String s) {
        super(s);
    }

}
