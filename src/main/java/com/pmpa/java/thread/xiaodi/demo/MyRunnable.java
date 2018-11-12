package com.pmpa.java.thread.xiaodi.demo;

/**
 *
 * @Description 实现Runnable接口方式来创建线程。
 * 说明：一般选择这种方式来创建线程。因为Java只允许单继承，
 *  如果一个类继承了Thread后，就不能再继承其他的类了。
 *
 * @date 2018-11-12
 * @author natty
 *
 */

public class MyRunnable implements Runnable {
    //实现run()方法
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }

    public static void main(String[] args) {
        Thread th = new Thread(new MyRunnable());
        th.start();
    }
}
