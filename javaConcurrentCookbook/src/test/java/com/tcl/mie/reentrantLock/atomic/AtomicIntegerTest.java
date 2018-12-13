package com.tcl.mie.reentrantLock.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerTest {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    private static AtomicIntegerArray aia = new AtomicIntegerArray(new int[10]);

    private static AtomicIntegerFieldUpdater<User> aifu = AtomicIntegerFieldUpdater
                                                        .newUpdater(User.class, "age");
    public static void main(String[] args) {

        System.out.println(atomicInteger.addAndGet(2));
        System.out.println(atomicInteger.accumulateAndGet(2, (x, y)->{return x+y*x;}));

        for (int i = 0; i < 10; i++) {
            aia.set(i, i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("i = " + i + "-----" + aia.addAndGet(i, i));
        }

        User u = new User();
        u.setName("Hohenheim");
        aifu.set(u, 100);
        System.out.println(u);
    }

    public static class User{
        private String name;
        public volatile int age;

        public User(){

        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
