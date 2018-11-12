package com.pmpa.java.thread.xiaodi.demo;

/**
 * 使用匿名内部类方式 创建线程
 * @date 2018-11-12
 * @author natty
 */
public class MyThreadAnonymous {

    public static void main(String[] args) {
        Thread th = new Thread(new MyRunnable() {
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        + " running");
            }
        });
        th.start();
    }
}

