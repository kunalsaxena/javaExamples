package com.techiekunal.examples.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuterServiceExample {

	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		executorService.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Running through Executor. Thread :- " + Thread.currentThread().getName());
			}
		});
		executorService.shutdown();
	}
	
}
