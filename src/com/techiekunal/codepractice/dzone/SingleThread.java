package com.techiekunal.codepractice.dzone;

public class SingleThread extends Thread {
	public void run() {
		System.out.println("Single Thread. By" + currentThread());
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableThread(),"Manikant");
		Thread t2 = new Thread(new RunnableThread(),"Kunal");
		SingleThread t3 = new SingleThread();
		t3.setName("Nag");
		
		t1.start();
		t2.start();
		try {
			t2.join();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		t3.start();
	}
}

class RunnableThread implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Runnable Thread:" + Thread.currentThread().getName());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
	}
}
