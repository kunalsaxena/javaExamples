package com.techiekunal.designpatterns;

public class StatePatternExample {
	
	public static void main(String[] args) {
		
		Mobile mobile = new Mobile();
		
		mobile.wakeupDisplay();
		mobile.setState(new LockedState());
		mobile.showNotifications();
		mobile.makeCall();
		mobile.sendSMS();
	}
}

class Mobile {
	
	private MobileState state;
	
	public Mobile() {
		state = new UnlockedState();
	}
	
	public void setState(MobileState state) {
		this.state = state;
	}
	
	public void wakeupDisplay() {
		state.wakeupDisplay();
	}
	
	public void showNotifications() {
		state.showNotifications();
	}
	
	public void makeCall() {
		state.makeCall();
	}
	
	public void sendSMS() {
		state.sendSMS();
	}
}


abstract class MobileState {
	
	void wakeupDisplay() {
		System.out.println("Waking up display ");
	}
	
	void showNotifications() {
		System.out.println("Showing Notifications ");
	}
	
	abstract void clickNotification();
	
	abstract void makeCall();
	
	abstract void sendSMS();
}

class LockedState extends MobileState {

	@Override
	void clickNotification() {
		System.out.println("Locked..so do nothing ");
	}
	
	void makeCall() {
		System.out.println("Locked..so do nothing");
	}
	
	void sendSMS() {
		System.out.println("Locked..so do nothing");
	}
}

class UnlockedState extends MobileState {
	
	void makeCall() {
		System.out.println("Making a call ");
	}
	
	void sendSMS() {
		System.out.println("Sending SMS");
	}

	@Override
	void clickNotification() {
		System.out.println("Opening related app ");
	}
}

