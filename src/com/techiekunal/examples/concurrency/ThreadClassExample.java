package com.techiekunal.examples.concurrency;

public class ThreadClassExample extends Thread{

	@Override
	public void run() {
		System.out.println("Executing Job. by thread :- " + Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		
		// Creating new threads
		ThreadClassExample t1 = new ThreadClassExample();
		ThreadClassExample t2 = new ThreadClassExample();
		
		// Setting name for threds
		t1.setName("Bruno");
		t2.setName("Adam");
		
		// Starting threads
		t1.start();
		t2.start();
		
	}
}
