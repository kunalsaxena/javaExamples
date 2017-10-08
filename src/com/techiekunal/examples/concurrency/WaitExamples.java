package com.techiekunal.examples.concurrency;

public class WaitExamples {
	
	class WaitJob implements Runnable {
		
		private Integer value;
		
		public WaitJob(Integer val) {
			this.value = val;
		}
		
		@Override
		public void run() {
			
			synchronized (value) {

				System.out.println("Executing Thread is :- " + Thread.currentThread().getName());
				try {
					value.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Resumed Thread is :- " + Thread.currentThread().getName());
			}
		}
	}
	
	class NotifyJob implements Runnable {
		
		private Integer value;
		
		public NotifyJob(Integer val) {
			this.value = val;
		}
		
		@Override
		public void run() {
			
			synchronized (value) {
				System.out.println("Executing Thread is :- " + Thread.currentThread().getName());
				value.notify();
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		Integer val = new Integer(1);
		
		WaitJob wait = new WaitExamples().new WaitJob(val);
		NotifyJob notify = new WaitExamples().new NotifyJob(val);
		
		Thread t1 = new Thread(wait,"Bruno");
		Thread t2 = new Thread(notify,"Adam");
		
		t1.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.start();
		
	}

}
