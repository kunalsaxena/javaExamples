package com.techiekunal.codepractice.designpatterns;

public final class SingletonPattern { // final preventing sub classing

	private static SingletonPattern singletonPattern;
	
	private SingletonPattern() {	// restricting use of new keyword
	}
	
	public static synchronized SingletonPattern getInstance() { // lazy Initialization
		if(singletonPattern == null) {
			singletonPattern = new SingletonPattern();
		}
		return singletonPattern;
	}
	
}
