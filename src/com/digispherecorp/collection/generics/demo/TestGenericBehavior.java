/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.generics.demo;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author walle
 */
public class TestGenericBehavior {

    public static void main(String[] args) {

        Element<Float> e = new AbstractElement<Float>(Float.valueOf(1000)) {
            @Override
            public void analyse() {
                System.out.println("analysing internals in Floats");
            }
        };

        ElementAnalysis<Float> ea = new ElementAnalysis<>(e);

        Set<ElementAnalysis<Float>> set = new TreeSet<>((ElementAnalysis<Float> o1, ElementAnalysis<Float> o2) -> {
            return o1.getElement().getElementContent().compareTo(o2.getElement().getElementContent());
        });

        set.add(ea);
        set.add(new ElementAnalysis<>(new AbstractElement<Float>(Float.valueOf(2000)) {
            @Override
            public void analyse() {
                System.out.println("Printing: " + Float.valueOf("2000"));
            }
        }));
        set.add(new ElementAnalysis<>(new AbstractElement<Float>(Float.valueOf(3000)) {
            @Override
            public void analyse() {
                System.out.println("Printing: " + Float.valueOf("3000"));
            }
        }));
        set.add(new ElementAnalysis<>(new AbstractElement<Float>(Float.valueOf(4000)) {
            @Override
            public void analyse() {
                System.out.println("Printing: " + Float.valueOf("4000"));
            }
        }));
        set.add(new ElementAnalysis<>(new AbstractElement<Float>(Float.valueOf(5000)) {
            @Override
            public void analyse() {
                System.out.println("Printing: " + Float.valueOf("5000"));
            }
        }));

        ElementAnalysisIterator iteratorImpl = new ElementAnalysisIterator(set);
        Iterator<ElementAnalysis<Float>> iterator = iteratorImpl.iterator();
        while (iterator.hasNext()) {
            ElementAnalysis<Float> next = iterator.next();
        }
        
        System.out.println("");
        
        DataWorker<Integer, Integer, Integer> dw  = new DataWorker<>(Integer.SIZE, Integer.BYTES, Integer.BYTES, set);
        
        dw.setInnerPublicGenVar(new Long("9200000000000000000"));
        System.out.println(dw.getInnerPublicGenVar());
        System.out.println(dw.getObj().toString());
        System.out.println(dw.getInnerPublic());

    }
}
