package com.tcl.mie.reentrantLock;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    private static Semaphore semaphore = new Semaphore(3);
    private static volatile int num = 0;

    public static void set(){
        try{
            semaphore.acquire();
            add();
            try{
                TimeUnit.MICROSECONDS.sleep(new Random().nextInt(2000));
            }catch (java.lang.InterruptedException e){
                e.printStackTrace();
            }
            sub();
        }catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }finally {
            semaphore.release();
        }
    }
    public synchronized static void add(){
            num += 1;
            System.out.printf("%s ....add .... num = %d\n",Thread.currentThread().getName(), num);
    }

    public synchronized static void sub(){
        num -= 1;
        System.out.printf("sub .... num = %d\n", num);
    }

    public synchronized static int get(){
            return num;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 10; i++) {
                    SemaphoreTest.set();
//                    try{
//                        TimeUnit.MICROSECONDS.sleep(new Random().nextInt(2000));
//                    }catch (java.lang.InterruptedException e){
//                        e.printStackTrace();
//                    }
                }
            }
        };
        Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new Thread(r);
            threads[i].start();
        }


        for (int i = 0; i < 100; i++) {
            try {
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("num = " + get());

    }
}
