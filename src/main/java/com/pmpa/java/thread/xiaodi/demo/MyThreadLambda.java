package com.pmpa.java.thread.xiaodi.demo;

/**
 * @Description 使用Lambda表达式方式创建线程
 * @Date : 2018-11-12
 * @author : natty
 *
 */

public class MyThreadLambda{
    public static void main(String[] args) {
        new Thread(
                () ->
                        System.out.println(Thread.currentThread().getName() + " running")
        ).start();
    }
}
