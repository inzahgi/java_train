package com.tcl.mie.reentrantLock.atomic;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicReferenceTest {


    public static void main(String[] args) {
        AtomicIntegerTest.User u1 = new AtomicIntegerTest.User("No 1", 100);
        AtomicIntegerTest.User u2 = new AtomicIntegerTest.User("No 2", 200);

        AtomicReference<AtomicIntegerTest.User> ar = new AtomicReference<>(u1);

        ar.compareAndSet(u1, u2);
        System.out.println(ar.get());

        AtomicIntegerTest.User u3 = new AtomicIntegerTest.User("No 3", 300);
        AtomicIntegerTest.User u4 = new AtomicIntegerTest.User("No 4", 400);

        AtomicMarkableReference<AtomicIntegerTest.User> amr = new AtomicMarkableReference<>(u3, false);
        boolean flag = amr.isMarked();
        System.out.println(" line = 23 flag = "+ flag);
        amr.compareAndSet(u3, u4, flag, !flag);
        System.out.println("line 25 flag = " + amr.isMarked() + "\n" + amr.getReference());

        AtomicIntegerTest.User u5 = new AtomicIntegerTest.User("No 5", 500);
        AtomicIntegerTest.User u6 = new AtomicIntegerTest.User("No 6", 600);

        AtomicStampedReference asr = new AtomicStampedReference(u5, 10);
        int n = asr.getStamp();
        asr.compareAndSet(u5, u6, n, n+1);
        System.out.println(asr.getReference());

    }


}
