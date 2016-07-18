/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.util;

import java.util.Collection;
import java.util.Comparator;

/**
 *
 * @author walle
 * <p>
 * Created on Jul 14, 2016, 8:24:08 PM
 * @param <E>
 *
 */
public interface SortableCollection<E> extends Collection<E> {

    /**
     *
     */
    void sort();

    /**
     *
     * @param c
     */
    void sort(Comparator<? super E> c);
}
