package com.techiekunal.examples.concurrency;

public class JoinExample {

	class MyRunnable implements Runnable {
		
		@Override
		public void run() {
			System.out.println("Executing Thread is :- " + Thread.currentThread().getName());
			try {
				if(Thread.currentThread().getName().equals("Bruno"))
					Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Executing Complete. Thread is :- " + Thread.currentThread().getName());
		}
	}
	
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new JoinExample().new MyRunnable(),"Bruno");
		Thread t2 = new Thread(new JoinExample().new MyRunnable(),"Adam");
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		t2.start();
	}
}
