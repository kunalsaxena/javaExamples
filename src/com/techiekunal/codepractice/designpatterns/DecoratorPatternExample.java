package com.techiekunal.codepractice.designpatterns;

public class DecoratorPatternExample {

	public static void main(String[] args) {
		
		INotifier notifier = new WhatsappNotifier(new FacebookNotifier(new EmailNotifier("Kunal")));
		notifier.send();
	}
}


// **********======================**********

interface INotifier {
	
	String getUsername();
	
	void send();
}

class EmailNotifier implements INotifier {

	private final String username;
	private final DatabaseService databaseService;
	
	public EmailNotifier(String username) {
		this.username = username;
		this.databaseService = new DatabaseService();
	}
	
	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public void send() {
		String email = databaseService.getMailFromUsername(username);
		System.out.println("Sending notification to " + email + " via Email");
	}
}

abstract class BaseNotifierDecorator implements INotifier {
	
	private final INotifier wrapped; 
	protected final DatabaseService databaseService;
	
	public BaseNotifierDecorator(INotifier wrapped) {
		this.wrapped = wrapped;
		databaseService = new DatabaseService();
	}

	@Override
	public String getUsername() {
		return wrapped.getUsername();
	}

	@Override
	public void send() {
		wrapped.send();
	}
}

class FacebookNotifier extends BaseNotifierDecorator {

	public FacebookNotifier(INotifier wrapped) {
		super(wrapped);
	}
	
	@Override
	public void send() {
		super.send();
		String fbname = databaseService.getFBNameFromUsername(getUsername());
		System.out.println("Sending notification to " + fbname + " via Facebook");
	}
}

class WhatsappNotifier extends BaseNotifierDecorator {

	public WhatsappNotifier(INotifier wrapped) {
		super(wrapped);
	}
	
	@Override
	public void send() {
		super.send();
		String mobile = databaseService.getPhoneNbrFromUsername(getUsername());
		System.out.println("Sending notification to " + mobile + " via Whatsapp");
	}
}


class DatabaseService {

    public String getMailFromUsername(String username) {
        return username + "@Mail";
    }

    public String getPhoneNbrFromUsername(String username) {
        return username + "@Phone";
    }

    public String getFBNameFromUsername(String username) {
        return username + "@Facebook";
    }

}

