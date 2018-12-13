package com.tcl.mie.chapter1.recipe2.core;

import com.tcl.mie.chapter1.recipe2.task.Calculator;

import java.io.FileWriter;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        System.out.printf("Minimum Priority: %s \n", Thread.MAX_PRIORITY);
        System.out.printf("Normal Priority: %s\n", Thread.NORM_PRIORITY);
        System.out.printf("Maximun Priority: %s\n", Thread.MAX_PRIORITY);

        Thread threads[];
        Thread.State status[];

        threads = new Thread[10];
        status = new Thread.State[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new Calculator(i));
            if((i%2)==0){
                threads[i].setPriority(Thread.MAX_PRIORITY);
            }else {
                threads[i].setPriority(Thread.MIN_PRIORITY);
            }
            threads[i].setName("Thread " + i);
        }

        // origin file path  ".\\data\\log.txt"
        try(FileWriter file = new FileWriter("ch1_recipe2_log.txt"); PrintWriter pw = new PrintWriter(file)){
            for (int i = 0; i < 10; i++) {
                pw.println("Main : Status of Thread " + i + " : " + threads[i].getState());
                status[i]=threads[i].getState();
            }

            for (int i = 0; i < 10; i++) {
                threads[i].start();
            }

            boolean finish=false;
            while (!finish){
                for (int i = 0; i < 10; i++) {
                    if (threads[i].getState() != status[i]){
                        writeThreadInfo(pw, threads[i], status[i]);
                        status[i]=threads[i].getState();
                    }
                }
                finish=true;
                for (int i = 0; i < 10; i++) {
                    finish=finish&&(threads[i].getState()== Thread.State.TERMINATED);
                }
            }
        }catch (java.io.IOException e){
            e.printStackTrace();
        }

    }

    private static void writeThreadInfo(PrintWriter pw, Thread thread, Thread.State state){
        pw.printf("Main : Id %d - %s\n", thread.getId(), thread.getName());
        pw.printf("Main : Priority: %d\n", thread.getPriority());
        pw.printf("Main : Old State: %s\n", state);
        pw.printf("Main : New State: %s\n", thread.getState());
        pw.printf("Main : *****************************\n");
    }
}
