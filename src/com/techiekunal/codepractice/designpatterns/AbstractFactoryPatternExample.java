package com.techiekunal.codepractice.designpatterns;

public class AbstractFactoryPatternExample {

	public static void main(String[] args) {
		IFactory factory = VehicleAbstractFactory.createFactory("BMW");
		factory.createVehicle("TRUCK").construct();
	}
}

interface IFactory {
	Vehicle createVehicle(String type);
}

abstract class VehicleAbstractFactory {

	static IFactory createFactory(String company) {
		if (company.equals("TATA")) {
			return new TataFactory();
		} else if (company.equals("BMW")) {
			return new BMWFactory();
		} else {
			throw new IllegalArgumentException("Invalid company name given");
		}
	}
}

class TataFactory extends VehicleAbstractFactory implements IFactory {

	@Override
	public Vehicle createVehicle(String type) {
		if (type.equals("CAR")) {
			return new TataCar();
		} else if (type.equals("TRUCK")) {
			return new TataTruck();
		} else {
			throw new IllegalArgumentException("Invalid vehicle type requested from Tata");
		}
	}
}

class BMWFactory extends VehicleAbstractFactory implements IFactory {

	@Override
	public Vehicle createVehicle(String type) {
		if (type.equals("CAR")) {
			return new BMWCar();
		} else if (type.equals("BIKE")) {
			return new BMWBike();
		} else {
			throw new IllegalArgumentException("Invalid vehicle type requested from BMW");
		}
	}
}

interface Vehicle {
	void construct();
}

interface Car extends Vehicle {
}

interface Bike extends Vehicle {
}

interface Truck extends Vehicle {
}

class TataCar implements Car {

	@Override
	public void construct() {
		System.out.println("Constructing Tata car");
	}
}

class BMWCar implements Car {

	@Override
	public void construct() {
		System.out.println("Constructing BMW car");
	}
}

class BMWBike implements Bike {

	@Override
	public void construct() {
		System.out.println("Constructing BMW bike");
	}
}

class TataTruck implements Truck {

	@Override
	public void construct() {
		System.out.println("Constructing Tata truck");
	}
}
