package com.pmpa.java.algorithm;
/**
 * @Description : 以数组形式实现表
 * @Author: Natty
 * @Date: 2018-11-05
 *
 */

import java.util.Iterator;

public class MyArrayList<T>
        implements Iterable<T>
{

    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private T[] theItems;

    public MyArrayList(){
        doClear();
    }

    public void clear(){
        doClear();
    }

    private void doClear(){
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
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
        ensureCapacity(size());
    }

    public T get(int idx){
        if(idx <0 || idx>=size())
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        else
        {
            return theItems[idx];
        }
    }

    public T set(int idx, T newVal){
        T oldVal;
        if(idx <0 || idx>=size())
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        else
        {
            oldVal = theItems[idx];
            theItems[idx] = newVal;
            return oldVal;
        }
    }

    /**
     * 将ArrayList的底层数组扩容，在现有数组不够用的情况下。
     * @param newCapacity ：扩容数组的长度
     */
    public void ensureCapacity(int newCapacity){
        if(newCapacity < size())
        {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for(int i=0;i<theSize;i++)
            theItems[i] = old[i];
    }

    public boolean add(T x){
        add(size(),x);
        return true;
    }

    /**
     * 将元素x插入到表的idx位置上。
     * @param idx    插入表中的位置编号
     * @param x      插入表中的元素
     */
    public void add(int idx,T x){
        if(size() == theSize)
        {
            ensureCapacity(2*size()+1);
        }
        for(int i=size()-1 ; i>=idx ; i--)
        {
            theItems[i+1] = theItems[i];
        }
        theItems[idx]=x;
        theSize++;
    }

    /**
     * 删除表中第idx位置的元素并返回
     * @param idx
     * @return
     */
    public T remove(int idx){
        if(idx>=theSize)
        {
            return null;
        }
        T removedValue = theItems[idx];
        for(int i=idx; i<theSize ; i++)
            theItems[i] = theItems[i+1];
        theSize--;
        return removedValue;
    }

    @Override
    public String toString() {
        StringBuilder sb =new StringBuilder();
        for(int i = 0 ; i<theSize; i++)
        {
            sb.append(
             ((theSize-i)>1)?(theItems[i].toString()+",")
                     :(theItems[i].toString())
            );
        }
        return sb.toString();
    }
        public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T>{
        private int current = 0 ;

        public boolean hasNext() {
            return current < theSize;
        }

        public T next() {
            return theItems[current++];
        }

        public void remove() {
             MyArrayList.this.remove(--current);
        }
    }

    public static void main(String[] args){
        MyArrayList<Integer> mylist = new MyArrayList<Integer>();
        for (int i=7; i<100 ; i++)
            mylist.add(i);
        System.out.println(mylist);
        for(int i: mylist)
        {
            System.out.println(i);
        }
    }

}


