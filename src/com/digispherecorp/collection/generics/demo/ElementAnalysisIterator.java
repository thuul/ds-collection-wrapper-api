/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.generics.demo;

import java.util.Set;

public class ElementAnalysisIterator<T> implements Iterator<ElementAnalysis<T>> {

    private final Set<ElementAnalysis> algoSet;
    private final java.util.Iterator<ElementAnalysis> iterator;

    public ElementAnalysisIterator(Set<ElementAnalysis> algoSet) {
        this.algoSet = algoSet;
        iterator = algoSet.iterator();
    }

    @Override
    public java.util.Iterator<ElementAnalysis<T>> iterator() {
        return new java.util.Iterator<ElementAnalysis<T>>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public ElementAnalysis<T> next() {
                return new RunAnalysis<ElementAnalysis<T>>() {
                    @Override
                    public ElementAnalysis<T> analyse() {
                        ElementAnalysis<T> next = iterator.next();
                        next.AnalyseElement();
                        return next;
                    }
                }.analyse();
            }
        };
    }

}
