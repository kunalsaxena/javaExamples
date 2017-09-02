package com.techiekunal.examples;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

class DelayItem implements Delayed {

	private String item;
	private long expiryTime;
	
	public DelayItem(String item, long expiryTime) {
		this.item = item;
		this.expiryTime = expiryTime;
	}
	
	@Override
	public int compareTo(Delayed o) {
		if(this.expiryTime > ((DelayItem)o).expiryTime)
			return 1;
		if(this.expiryTime < ((DelayItem)o).expiryTime)
			return -1;
		return 0;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long timeDiff = expiryTime - System.currentTimeMillis();
		return unit.convert(timeDiff, TimeUnit.MILLISECONDS);
	}
	
	@Override
	public String toString() {
		return item + " - " + expiryTime;
	}
	
}

public class DelayQueueExample {
	
	public static void main(String[] args) throws InterruptedException {
		DelayQueue<Delayed> queue = new DelayQueue<>();
		
		DelayItem item1 = new DelayItem("Bruno", 10000);
		
		queue.put(item1);
		
		Delayed item2 = queue.take();
		System.out.println(item2);
	}
	
}
