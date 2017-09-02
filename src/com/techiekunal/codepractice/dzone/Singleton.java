package com.techiekunal.codepractice.dzone;

import java.io.Serializable;

public class Singleton implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2800905811136248842L;

	public static final Singleton INSTANCE = new Singleton();
	
	private int value;
	
	
	
	private Singleton() {
		
	}
	
	protected Object readResolve() {
		return INSTANCE;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
