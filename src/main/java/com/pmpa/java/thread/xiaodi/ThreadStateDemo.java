package com.pmpa.java.thread.xiaodi;


import java.io.IOException;

/**
 * @Description 通过源码查看Thread的几个状态。
 *              在jconsole中查看创建的几个状态的实例：
 *                  新建连接 -> 选择这个开发的类 -> 选择"线程"标签 -> 选择我们开发的线程 就可以看到这个线程的状态。
 *              NEW,RUNNABLE,BLOCKED,WAITING,TIMED_WAITING,TERMINATED
 * @date 2018-11-11
 * @author natty
 *
 */
public class ThreadStateDemo {

    public static void main(String[] args) {

        /*RUNNABLE:
        Thread state for a runnable thread.  A thread in the runnable
        state is executing in the Java virtual machine but it may
        be waiting for other resources from the operating system
        such as processor.
        */
        Thread th = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        th.start();
    }
}
