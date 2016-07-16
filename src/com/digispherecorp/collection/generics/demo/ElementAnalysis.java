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
public class ElementAnalysis<T> {

    private final Element<T> element;

    public ElementAnalysis(Element<T> element) {
        this.element = element;
    }

    public void AnalyseElement() {
        element.analyse();
    }

    public Element<T> getElement() {
        return element;
    }
}
