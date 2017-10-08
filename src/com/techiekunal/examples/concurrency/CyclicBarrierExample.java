package com.techiekunal.examples.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Lets implement Cyclic Barrier Example for preparing meal at Mcdonalds.
 * Meal will have Burger, Fries and cola, which will be prepared by 3 threads.
 * When all 3 threads have worked. Meal is prepared so barrier will reached.
 * 
 * @author Kunal.Saxena
 *
 */

// Mcdonalds Job
class McdonaldsMealTask implements Runnable {

	private final CyclicBarrier barrier;

	public McdonaldsMealTask(CyclicBarrier barrier) {
		this.barrier = barrier;
	}

	@Override
	public void run() {
		
		String threadName = Thread.currentThread().getName();
		
		System.out.println("Thread starting :-" + threadName);
		
		switch (threadName) {
		case "BurgerMachine":
			System.out.println("Preparing Burger");
			break;
			
		case "FriesMachine":
			System.out.println("Preparing Fries");
			break;
			
		case "ColaMachine":
			System.out.println("Preparing Cola");
			break;
		}
		
		try {
			this.barrier.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
		
		System.out.println("Thread finished :-" + threadName);
	}
}

// Thread Manager class.
public class CyclicBarrierExample {

	public static void main(String[] args) {
		
		Runnable barrierAction = new Runnable() {

			@Override
			public void run() {
				System.out.println("Order Complete. Put in Tray and deliver");
			}
		};

		CyclicBarrier barrier = new CyclicBarrier(3, barrierAction);
		
		McdonaldsMealTask task = new McdonaldsMealTask(barrier);
		
		new Thread(task,"BurgerMachine").start();
		new Thread(task,"FriesMachine").start();
		new Thread(task,"ColaMachine").start();
	}
}
