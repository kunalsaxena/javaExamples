package com.techiekunal.examples.concurrency;

class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("Thread going to sleep :- " + Thread.currentThread().getName());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread wakenup is :- " + Thread.currentThread().getName());
	}
}


public class SleepExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(new MyRunnable(),"Bruno");
		Thread t2 = new Thread(new MyRunnable(),"Adam");
		
		t1.start();
		t2.start();
	}
}
