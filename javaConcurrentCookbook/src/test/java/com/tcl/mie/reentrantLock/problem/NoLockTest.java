package com.tcl.mie.reentrantLock.problem;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class NoLockTest {

    private static ReentrantLock lock = new ReentrantLock();

    private static int num = 100;

    public static void add(int n){
        //lock.lock();
        try{
            num += n;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //lock.unlock();
        }
    }

    public static void sub(int n){
        //lock.lock();
        try{
            num -= n;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //lock.unlock();
        }
    }

    public static int get(){
        //lock.lock();
        try{
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //lock.unlock();
        }
        return -10000;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Random random = new Random();
                for (int i = 0; i < 10; i++) {
                    int n = random.nextInt(20);
                    NoLockTest.add(n);
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    NoLockTest.sub(n);
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
