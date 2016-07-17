/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.util;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author walle
 * <p>
 * Created on Jul 17, 2016, 1:09:01 AM
 *
 */
public class TestUtil {

    public static void main(String[] args) {

        HashList<Integer> hashList = new HashList();
        hashList.add(1);
        hashList.add(4);
        hashList.add(6);
        hashList.add(2);
        hashList.add(3);
        hashList.add(10);
        hashList.add(7);
        hashList.add(5);
        hashList.add(8);
        hashList.add(9);
        hashList.add(1);
        hashList.add(4);
        hashList.add(6);
        hashList.add(2);
        hashList.add(3);
        hashList.add(10);
        hashList.add(7);
        hashList.add(5);
        hashList.add(8);
        hashList.add(9);
        hashList.add(1);
        hashList.add(4);
        hashList.add(6);
        hashList.add(2);
        hashList.add(3);
        hashList.add(10);
        hashList.add(7);
        hashList.add(5);
        hashList.add(8);
        hashList.add(9);

        hashList.sort();
        //hashList.remove(1);
        //hashList.remove(9);
        System.out.println(hashList.size());

        System.out.println();

        hashList.stream().forEach((Integer in) -> {
            System.out.println(in);
        });

        System.out.println();

        HashList<Integer> hashList0 = new HashList();
        hashList0.add(9);
        hashList0.add(8);
        
        hashList0.add(1);

        //hashList0.sort();
        hashList0.stream().forEach((Integer in) -> {
            System.out.println(in);
        });

        System.out.println();

        //System.out.println(hashList.removeAll(hashList0));
        System.out.println(hashList.retainAll(hashList0));
        //System.out.println(hashList.containsAll(hashList0));
        //System.out.println(hashList.addAll(hashList0));
        System.out.println();

        hashList.stream().forEach((Integer in) -> {
            System.out.println(in);
        });

        System.out.println();

        System.out.println(hashList.size());
        
        System.out.println();
        
        /**
         * 
         * Testing ArrayHashList implementation
         * 
         */        
        
        System.out.println("Testing ArrayHashList implementation");
        System.out.println();
        
        
        Collection<Integer> arrayList = new ArrayHashList<>(2);
        arrayList.add(9);
        arrayList.add(8);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(10);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(4);
        arrayList.add(1);

        System.out.println(arrayList.size());
        System.out.println();

        ((SortedCollection) arrayList).sort();

        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            //iterator.remove();
        }

        System.out.println();

        Iterator<Integer> iterator0 = arrayList.iterator();
        while (iterator0.hasNext()) {
            Integer next = iterator0.next();
            System.out.println(next);
        }

        System.out.println();
        System.out.println(arrayList.size());

        arrayList.add(9);
        arrayList.add(8);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(10);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(9);
        arrayList.add(8);
        arrayList.add(5);
        arrayList.add(7);
        arrayList.add(10);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(6);
        arrayList.add(4);
        arrayList.add(1);

        System.out.println();
        System.out.println(arrayList.size());
        System.out.println(arrayList.toArray().length);

        System.out.println();

        HashList<Integer> arrayList0 = new HashList();
        arrayList0.add(1);
        arrayList0.add(4);
        arrayList0.add(6);
        arrayList0.add(2);
        arrayList0.add(3);
        arrayList0.add(10);
        arrayList0.add(7);
        arrayList0.add(5);
        arrayList0.add(8);
        arrayList0.add(9);

        //hashList.sort();
        arrayList0.stream().forEach((Integer in) -> {
            System.out.println(in);
        });

        System.out.println();

        //System.out.println(hashList0.removeAll(hashList));
        //System.out.println(hashList0.retainAll(hashList));
        //System.out.println(hashList0.containsAll(hashList));
        System.out.println(arrayList.addAll(arrayList0));
        System.out.println();

        arrayList.stream().forEach((Integer in) -> {
            System.out.println(in);
        });

        System.out.println();

        System.out.println(arrayList.size());
        
        
        arrayList.clear();
        
        System.out.println();

        System.out.println(arrayList.size());
        
        arrayList.toArray();

    }
}
