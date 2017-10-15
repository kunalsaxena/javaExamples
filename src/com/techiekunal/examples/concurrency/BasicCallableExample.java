package com.techiekunal.examples.concurrency;

import java.util.concurrent.*;

/**
 * In this example main thread has responsibility of getting results from future 
 * 
 * @author kunalsaxena
 *
 */
public class BasicCallableExample {

	// ExecuterService with 1 thread
	private static final ExecutorService es = Executors.newFixedThreadPool(1);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// create dummy Callable task and submit to ExecuterService 
		Future<Integer> submit = es.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Thread.sleep(10000);
				return 450;
			}
			
		});
		
		// wait until future returns result
		Integer integer = submit.get();
		
		// print result
		System.out.println(integer);
		
		// shutdown executor : important
		es.shutdown();
	}
}
