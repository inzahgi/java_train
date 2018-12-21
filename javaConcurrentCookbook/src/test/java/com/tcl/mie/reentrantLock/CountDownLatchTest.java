package com.tcl.mie.reentrantLock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class CountDownLatchTest {
    private static CountDownLatch latch = new CountDownLatch(10);
    private static volatile int num = 0;

    public static synchronized void arrive(){
        add();
        latch.countDown();
        System.out.printf("%s.... now %d\n", Thread.currentThread().getName(), latch.getCount());
    }

    public static synchronized void add(){
        num += 1;
    }

    public static void get(){
        try {
            latch.await();
            System.out.printf("%s.... now num = %d\n", Thread.currentThread().getName(), num);
        }catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                CountDownLatchTest.get();
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
//                try{
//                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
//                }catch (java.lang.InterruptedException e){
//                    e.printStackTrace();
//                }
                CountDownLatchTest.arrive();
            }
        };

        Thread t1 = new Thread(r1);

        t1.start();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(r2);
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            }catch (java.lang.InterruptedException e){
                e.printStackTrace();
            }
        }
        try {
            t1.join();
        }catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }
    }
}
