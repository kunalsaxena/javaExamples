package com.techiekunal.examples.concurrency;

import java.text.SimpleDateFormat;
import java.util.Date;

class ObjectLevelTest implements Runnable {
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	
	private synchronized void fun() {
		System.out.println(Thread.currentThread().getName() + " start at    " + sdf.format(new Date()));
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Thread.currentThread().interrupt();
		}
		
		System.out.println(Thread.currentThread().getName() + " complete at "  + sdf.format(new Date()));
	}

	@Override
	public void run() {
		fun();
	}
	
}

public class ObjectLevelLockExample {

	public static void main(String[] args) {
		ObjectLevelTest olt = new ObjectLevelTest();
		new Thread(olt,"Thread A").start();
		new Thread(olt,"Thread B").start();
	}
	
}
