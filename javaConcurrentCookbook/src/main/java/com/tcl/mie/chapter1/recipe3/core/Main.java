package com.tcl.mie.chapter1.recipe3.core;

import com.tcl.mie.chapter1.recipe3.task.PrimeGenerator;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Thread task = new PrimeGenerator();
        task.start();

        try{
            //Thread.sleep(5*1000);
            TimeUnit.SECONDS.sleep(5);
        }catch (java.lang.InterruptedException e){
            e.printStackTrace();
        }
        task.interrupt();
    }


}
