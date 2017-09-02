package com.techiekunal.examples;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class Producer implements Runnable {

	protected BlockingQueue<String> queue = null;
	
	public Producer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Producer Running.. Thread :- " + Thread.currentThread().getName());
			queue.put("1");
			Thread.sleep(1000);
			queue.put("2");
			Thread.sleep(1000);
			queue.put("3");
				
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

class Consumer implements Runnable {

	protected BlockingQueue<String> queue = null;
	
	public Consumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			System.out.println("Consumer Running.. Thread :- " + Thread.currentThread().getName());
			
			System.out.println(queue.take());
			System.out.println(queue.take());
			System.out.println(queue.take());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

public class ArrayBlockingQueueExample {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(100);
		
		Producer producer = new Producer(queue);
		Consumer consumer = new Consumer(queue);
		
		new Thread(producer,"Bruno").start();
		new Thread(consumer,"Adam").start();
		
		Thread.sleep(4000);
	}
	
}
