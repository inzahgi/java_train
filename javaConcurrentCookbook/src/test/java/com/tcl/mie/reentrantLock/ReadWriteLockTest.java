package com.tcl.mie.reentrantLock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

    private static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private static ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private static ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();


    private static int num = 100;

    public static void add(int n){
        writeLock.lock();
        try{
            num  += n;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writeLock.unlock();
        }
    }


    public static int get(){
        readLock.lock();
        try{
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readLock.unlock();
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
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(i % 5 == 0) {
                        ReadWriteLockTest.add(n);
                        ReadWriteLockTest.add(-n);
                    }else {
                        //Thread.yield();
                        ReadWriteLockTest.get();
                    }
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
