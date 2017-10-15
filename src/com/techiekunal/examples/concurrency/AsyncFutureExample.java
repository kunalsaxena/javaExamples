package com.techiekunal.examples.concurrency;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Task that will take random time (upto 10 sec) and return result
 * This will mimic processing on inputs
 * 
 * @author kunalsaxena
 *
 */
class MyFutureTask implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		// Sleep for random time (upto 10 sec) and return random int result
		Random random = new Random();
		Thread.sleep(random.nextInt(10) * 1000);
		return random.nextInt(500) + 1;
	}

}

/**
 * This is asynchronous job which:-
 * Takes future list as inputs then process them until you get results from all futures
 * This takes responsibility of acting on future, from main thread to a new external Thread
 * This way main thread can continue other tasks
 * 
 * @author kunalsaxena
 *
 */
class AsyncThreadTask implements Runnable {
	
	// List for Future inputs 
	private final List<Future<Integer>> futureList;
	// List for results from Future
	private final List<Integer> futureResults = new ArrayList<>();

	public AsyncThreadTask(List<Future<Integer>> list) {
		this.futureList = list;
	}

	@Override
	public void run() {
		Iterator<Future<Integer>> itr = futureList.iterator();
		try {
			while (itr.hasNext()) {
				Future<Integer> next = itr.next();
				// wait until future task is done
				while (!next.isDone()) {
					System.out.println("future task not done yet");
					// wait for sometime and let it complete
					Thread.sleep(2000);
				}
				// task is complete : so add result to list
				futureResults.add(next.get());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
		// You can process results : here i am printing them
		// Sequence of input future tasks and results will be maintained as per logic
		System.out.println(futureResults);
	}

}

/**
 * Example of how you can use Future asynchronously
 * 
 * @author kunalsaxena
 *
 */
public class AsyncFutureExample {

	// I am taking 2 threads in this example
	private static final ExecutorService es = Executors.newFixedThreadPool(2);
	// Store Futures
	private static final List<Future<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {
		// have two tasks and assign it to executer service. They will return future
		MyFutureTask task1 = new MyFutureTask();
		MyFutureTask task2 = new MyFutureTask();
		Future<Integer> future1 = es.submit(task1);
		Future<Integer> future2 = es.submit(task2);
		
		// Adding futures to list(pipeline)
		list.add(future1);
		list.add(future2);

		// Now Delegate processing of futures to external thread : we have already defined Job in AsyncThreadTask
		AsyncThreadTask asyncThreadTask = new AsyncThreadTask(list);

		// start external thread
		new Thread(asyncThreadTask).start();

		// Now main thread can perform other tasks without waiting for futures to return :: Asynchronous way
		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Doing some other stuff.." + new Date());
				try {
					Thread.sleep(15000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("other stuff done" + new Date());
			}
		}).start();

		// Shutdown Executor, otherwise it will keep on running
		es.shutdown();

	}
}
