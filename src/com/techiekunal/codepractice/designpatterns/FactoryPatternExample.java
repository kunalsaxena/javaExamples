package com.techiekunal.codepractice.designpatterns;

// Client Class
public class FactoryPatternExample {

	public static void main(String[] args) {
		Notification notification = NotificationFactory.createNotification("PUSH");
		notification.notifyUser();
	}
	
}

class NotificationFactory {
	
	public static Notification createNotification(String channel) {
		Notification notification;
		switch (channel) {
		case "SMS":
			notification = new SMSNotification();
			break;
		case "EMAIL":
			notification = new EmailNotification();
			break;	
		case "PUSH":
			notification = new PushNotification();
			break;	
		default:
			throw new IllegalArgumentException("Invalid channel passed");
		}
		return notification;
	}
	
}


interface Notification {
	void notifyUser();
}

class EmailNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("Notifying user via Email");
	}
}

class SMSNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("Notifying user via SMS");
	}
}

class PushNotification implements Notification {

	@Override
	public void notifyUser() {
		System.out.println("Notifying user via Push");
	}
}
