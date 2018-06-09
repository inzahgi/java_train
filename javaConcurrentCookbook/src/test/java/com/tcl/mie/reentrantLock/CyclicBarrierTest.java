package com.tcl.mie.reentrantLock;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {
    private static CyclicBarrier barrier= new CyclicBarrier(10, ()->{
        System.out.printf("%s.... ...... \t\t num =%d\n",
                Thread.currentThread().getName(), CyclicBarrierTest.get());
    });
    private static volatile int num = 0;

    public static void arrive(){
        add();
        try {
            TimeUnit.MICROSECONDS.sleep(new Random().nextInt(2000));
            System.out.printf("%s.... now %d\n", Thread.currentThread().getName(), barrier.getNumberWaiting());
            barrier.await();
        }catch (java.util.concurrent.BrokenBarrierException e){
            e.printStackTrace();
        }catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }
    }

    public static synchronized void add(){
        num += 1;
    }

    public static int get(){
        System.out.printf("%s.... now num = %d\n", Thread.currentThread().getName(), num);
        return num;
    }

    public static void main(String[] args) {
//        Runnable r1 = new Runnable() {
//            @Override
//            public void run() {
//                CyclicBarrierTest.get();
//            }
//        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try{
                    TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                }catch (java.lang.InterruptedException e){
                    e.printStackTrace();
                }
                CyclicBarrierTest.arrive();
            }
        };

        //Thread t1 = new Thread(r1);

        //t1.start();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(r2);
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
//        try {
//            t1.join();
//        }catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }
}
