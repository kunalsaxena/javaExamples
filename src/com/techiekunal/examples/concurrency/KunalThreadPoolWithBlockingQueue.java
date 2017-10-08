package com.techiekunal.examples.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class KunalThreadPoolWithBlockingQueue {

	private final int capacity;
	private final BlockingQueue<Runnable> queue;
	
	
	public KunalThreadPoolWithBlockingQueue(int capacity) {
		this.capacity = capacity;
		queue = new ArrayBlockingQueue<>(capacity);
	}
	
	public void execute (Runnable r) throws InterruptedException {
		
		while(!queue.isEmpty()) {
			
			queue.put(r);
			new Thread(r).start();
			
			
		}
		
	}
	
	
}


class ThreadManager extends Thread {
	
	private final Runnable r;
	
	public ThreadManager(Runnable r) {
		this.r = r;
	}
	
	
	
}
