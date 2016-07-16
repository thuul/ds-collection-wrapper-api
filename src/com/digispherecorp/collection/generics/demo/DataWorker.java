/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.digispherecorp.collection.generics.demo;

/**
 *
 * @author Ikram
 * @param <A>
 * @param <B>
 * @param <C>
 */
public class DataWorker<A, B, C> {

    private A varOne;
    private B varTwo;
    private C varTh3;
    private Object obj;
    private InnerDataWorker<Object> innerPublic = new InnerDataWorker();

    public DataWorker() {
    }

    public DataWorker(A varOne, B varTwo, C varTh3, Object obj) {
        this.varOne = varOne;
        this.varTwo = varTwo;
        this.varTh3 = varTh3;
        this.obj = obj;
    }

    public class InnerDataWorker<S> {

        private S innerPublicGenVar;
        private String innerStr;

        public InnerDataWorker() {
        }

        public InnerDataWorker(S innerVar, String s) {
            this.innerPublicGenVar = innerVar;
            this.innerStr = s;
        }

        public A getVarOne() {
            return varOne;
        }

        public B getVarTwo() {
            return varTwo;
        }

        public C getVarTh3() {
            return varTh3;
        }

        public String getInnerStr() {
            return innerStr;
        }

        public S getInnerPublicGenVar() {
            return innerPublicGenVar;
        }
    }

    public Object getObj() {
        return obj;
    }

    public Object getInnerPublicGenVar() {
        return innerPublic.innerPublicGenVar;
    }

    public void setInnerPublicGenVar(Object innerPublicGenVar) {
        this.innerPublic.innerPublicGenVar = innerPublicGenVar;
    }

    public InnerDataWorker<Object> getInnerPublic() {
        return innerPublic;
    }
}
