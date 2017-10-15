package com.techiekunal.codepractice.dzone;

final class Dog {
	
	private final String name;
	private String address;
	
	Dog(String name,String address){
		this.name = name;
		this.address = address;
	}

	public Dog setAddress(String address) {
		return new Dog(this.name, address);
	}

	@Override
	public String toString() {
		return name + address;
	}
}

public class FinalFieldFreeze {
	
	static final Dog dog = new Dog("Amit","NDLS");
	
	public static void main(String[] args) {
		System.out.println("lets start..." + dog);

		
		System.out.println("lets see now..." + dog.setAddress("CHAPRA"));
	}
}
