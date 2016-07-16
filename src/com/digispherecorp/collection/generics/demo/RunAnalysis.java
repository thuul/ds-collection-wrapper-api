/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.generics.demo;

public interface RunAnalysis<T extends ElementAnalysis> {

    /**
     *
     * @return ElementAnalysis
     */
    ElementAnalysis analyse();

}
