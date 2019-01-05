package com.pmpa.java.thread.xiaodi.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * 使用线程池方式来创建线程
 * ExecutorService
 *
 * @date 2019-01-05
 *
 */

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(" is running!");
        });
    }
}
