package com.pmpa.java.algorithm;

import java.util.Iterator;

/**
 * @Description : 以双链表形式实现表
 * @Author: Natty
 * @Date: 2018-11-07
 *
 */

public class MyLinkedList<T> implements Iterable<T> {

    private class Node<T>{
        private T data;
        private Node next;
        private Node prev;
    }



    public Iterator<T> iterator() {
        return null;
    }
}
