package com.techiekunal.codepractice.designpatterns;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternExample {

	public static void main(String[] args) {
		
		EmailSubscriber emailSubscriber = new EmailSubscriber();
		MobileSubscriber mobileSubscriber = new MobileSubscriber();
		
		Iphone iphone = new Iphone();
		iphone.subscribe(emailSubscriber);
		iphone.subscribe(mobileSubscriber);
		
		iphone.setAvailablity(true);
		
		System.out.println("============================================================");
		
		iphone.unSubscribe(mobileSubscriber);
		
		iphone.setAvailablity(true);
		
	}
	
}


// ***************************************************** //

interface ObservableProduct {
	
	void subscribe(Subscriber name);
	
	void unSubscribe(Subscriber name);
	
	void notifySubscribers();
}

class Iphone implements ObservableProduct {

	private List<Subscriber> subscriberList = new ArrayList<>(); 
	
	private boolean isAvailable;
	
	@Override
	public void subscribe(Subscriber name) {
		subscriberList.add(name);
	}

	@Override
	public void unSubscribe(Subscriber name) {
		subscriberList.remove(name);
	}

	@Override
	public void notifySubscribers() {
		for(Subscriber subscriber : subscriberList) {
			subscriber.update();
		}
	}
	
	public void setAvailablity(boolean availability) {
		this.isAvailable = availability;
		if(availability = true) {
			System.out.println("Iphone became available in store");
			notifySubscribers();
		}
	}
}

interface Subscriber {
	void update();
}

// subscriber 1
class EmailSubscriber implements Subscriber {

	@Override
	public void update() {
		System.out.println("Notifying user via Email");
	}
}

// subscriber 2
class MobileSubscriber implements Subscriber {

	@Override
	public void update() {
		System.out.println("Notifying user via Mobile");
	}
}