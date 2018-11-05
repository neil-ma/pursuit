package com.pmpa.java.algorithm;
/**
 * @Description : 以数组形式实现ArrayList
 * @Author: Natty
 * @Date: 2018-11-05
 *
 */

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;

    public MyArrayList(){

    }

    public void clear(){

    }

    private void doClear(){

    }


    /**
     * @return 返回ArrayList的长度
     */
    public int size(){
        return theSize;
    }

    /**
     * @return 返回ArrayList是否为空
     */
    public boolean isEmpty(){
        return theSize == 0 ;
    }

    public void trimToSize(){

    }

    public T get(int idx){

        return null;
    }

    public T set(int idx, T newVal){
        return null;
    }

    public void ensureCapacity(int newCapacity){

    }

    public boolean add(T x){
        return true;
    }

    public void add(int idx,T x){

    }

    public T remove(int idx){
        return null;
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private Class ArrayListIterator implements Iterator<T>{


    }
}
