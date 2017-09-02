package com.techiekunal.examples;

class RunnableImpl implements Runnable {

	@Override
	public void run() {
		System.out.println("Job Executed by thread :- " + Thread.currentThread().getName());
	}
	
}

public class RunnableInterfaceExample {
	
	public static void main(String[] args) {
		RunnableImpl runnableImpl = new RunnableImpl();
		Thread t1 = new Thread(runnableImpl,"Bruno");
		Thread t2 = new Thread(runnableImpl,"Adam");
		
		t1.start();
		t2.start();
	}
}

