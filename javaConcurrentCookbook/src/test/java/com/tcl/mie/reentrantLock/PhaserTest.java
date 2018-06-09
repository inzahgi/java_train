package com.tcl.mie.reentrantLock;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

public class PhaserTest {
    private static Phaser phaser= new Phaser();

    private static volatile int num = 0;

    public static void arrive(){
        add();
        try {
            TimeUnit.MICROSECONDS.sleep(new Random().nextInt(2000));
            System.out.printf("%s.... now %d\n", Thread.currentThread().getName(), phaser.getArrivedParties());
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        phaser.arriveAndAwaitAdvance();
        sub();
    }

    public static synchronized void add(){
        num += 1;
    }

    public static synchronized void sub(){
        num -= 1;
    }

    public static synchronized int get(){
        System.out.printf("%s.... now num = %d\n", Thread.currentThread().getName(), num);
        return num;
    }

    public static void main(String[] args) {
        phaser.register();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                phaser.register();
                for (int i = 0; i < 10; i++) {
                    try {
                        TimeUnit.SECONDS.sleep(new Random().nextInt(5));
                        phaser.arriveAndAwaitAdvance();
                        PhaserTest.arrive();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                phaser.arriveAndDeregister();

            }
        };

        //Thread t1 = new Thread(r1);

        //t1.start();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(r1);
            threads[i].start();
        }

        phaser.arriveAndDeregister();


        for (int i = 0; i < 10; i++) {
            try {
                threads[i].join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(get());

    }
}
