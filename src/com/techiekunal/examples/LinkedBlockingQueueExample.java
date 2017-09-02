package com.techiekunal.examples;

import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class LBQProducer implements Runnable {

	private BlockingQueue<String> queue = null;
	
	public LBQProducer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String item = UUID.randomUUID().toString();
				System.out.println("putting item - " + item);
				queue.put(item);
				Thread.sleep(500);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

class LBQConsumer implements Runnable {

	private BlockingQueue<String> queue = null;
	
	public LBQConsumer(BlockingQueue<String> queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				String item = queue.take();
				System.out.println("Thread :- " + Thread.currentThread().getName() + " taking item " + item);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


public class LinkedBlockingQueueExample {
	
	public static void main(String[] args) {
		final BlockingQueue<String> queue = new LinkedBlockingQueue<>(10);
		
		LBQProducer producer = new LBQProducer(queue);
		LBQConsumer consumer1 = new LBQConsumer(queue);
		LBQConsumer consumer2 = new LBQConsumer(queue);
		
		new Thread(producer,"Chris").start();
		new Thread(consumer1,"Bruno").start();
		new Thread(consumer2,"Adam").start();
	}
}
