package com.tcl.mie.reentrantLock.problem;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class NoConditionTest {

    private static ReentrantLock lock = new ReentrantLock();

    private static int num = 10;

    public static void add(int n){
        lock.lock();
        try{

            num += n;
            System.out.printf("add n = %d, \t\tnum = %d.......\n", n, num);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void sub(int n){
        lock.lock();
        try{
            num -= n;
            System.out.printf("sub n = %d, \t\tnum = %d.......\n", n, num);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static int get(){
        lock.lock();
        try{
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        return -10000;
    }

    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    NoConditionTest.sub(1);
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    NoConditionTest.add(1);
//                    try {
//                        TimeUnit.SECONDS.sleep(5);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t2.start();
        t1.start();
        try {
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


//        Thread[] threads = new Thread[100];
//        for (int i = 0; i < 100; i++) {
//            threads[i] = new Thread(r1);
//            threads[i].start();
//        }
//
//        for (int i = 0; i < 100; i++) {
//            try {
//                threads[i].join();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        }

        System.out.println("num = " + get());

    }
}
