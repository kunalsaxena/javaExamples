package com.techiekunal.examples;

public class DeadlockExample {

	class MyRunnable implements Runnable {

		// let's take two resources
		Integer r1 = new Integer(1);
		Integer r2 = new Integer(2);

		@Override
		public void run() {

			try 
			{
				if(Thread.currentThread().getName().equals("Bruno")) {
					synchronized (r1) {
						
						System.out.println("Thread " + Thread.currentThread().getName() + " locked r1");
						
						Thread.sleep(2000);
						synchronized (r2) {
							System.out.println("Thread " + Thread.currentThread().getName() + " locked r2");
						}
					}
				}
				else {
					synchronized (r2) {
						
						System.out.println("Thread " + Thread.currentThread().getName() + " locked r2");
						
						Thread.sleep(2000);
						synchronized (r1) {
							System.out.println("Thread " + Thread.currentThread().getName() + " locked r1");
						}
					}
				}
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) {
		DeadlockExample.MyRunnable job = new DeadlockExample().new MyRunnable();

		Thread t1 = new Thread(job, "Bruno");
		Thread t2 = new Thread(job, "Adam");

		t1.start();
		t2.start();
		
	}
}
