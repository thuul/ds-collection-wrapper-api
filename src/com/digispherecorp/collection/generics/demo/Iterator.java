/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.generics.demo;

/**
 *
 * @author Ikram
 * @param <K>
 */
public interface Iterator<K> extends Iterable<K>{

    @Override
    public java.util.Iterator<K> iterator();
    
}
