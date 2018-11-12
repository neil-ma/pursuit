package com.pmpa.java.thread.xiaodi.demo;

/**
 * @Description 继承Thread方式来创建线程
 *
 * @Date 2018-11-12
 * @Author Natty
 *
 */

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+ " running");
    }

    public static void main(String[] args) {
        MyThread th = new MyThread();
        th.start();
    }
}
