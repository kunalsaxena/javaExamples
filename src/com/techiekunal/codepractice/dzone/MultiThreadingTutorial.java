package com.techiekunal.codepractice.dzone;

class MultiThread extends Thread{
    public void run(){
        System.out.println("Running Thread Name: "+ this.currentThread().getName());
        System.out.println("Running Thread Priority: "+ this.currentThread().getPriority());
    }
}
public class MultiThreadingTutorial {
    public static void main(String[] args) {
        MultiThread multiThread1 = new MultiThread();
        multiThread1.setName("Thread1");
        multiThread1.setPriority(Thread.MIN_PRIORITY);

        MultiThread multiThread2 = new MultiThread();
        multiThread2.setName("Thread2");
        multiThread2.setPriority(Thread.MAX_PRIORITY);

        MultiThread multiThread3 = new MultiThread();
        multiThread3.setName("Thread3");

        multiThread1.start();
        multiThread2.start();
        multiThread3.start();
    }
}