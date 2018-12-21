package com.tcl.mie.reentrantLock.problem;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class NoSemaphoreTest {

    //private static Semaphore semaphore = new Semaphore(3);
    private static int num = 0;

    public synchronized static void add(){
        num += 1;
        System.out.printf("add .... num = %d\n", num);
    }

    public synchronized static void sub(){
        num -= 1;
        System.out.printf("add .... num = %d\n", num);

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
                    NoSemaphoreTest.add();
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    NoSemaphoreTest.sub();
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
