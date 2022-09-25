package com.techiekunal.codepractice.designpatterns;

public class StrategyPatternExample {

	public static void main(String[] args) {
		
		Context context = new Context();
		
		RouteStrategy strategy1 = new RoadStrategy();
		context.setStrategy(strategy1);
		context.buildRoute("Delhi", "Bangalore");
		
		RouteStrategy strategy2 = new PublicTransportStrategy();
		context.setStrategy(strategy2);
		context.buildRoute("Delhi", "Bangalore");
		
	}
}


// context class
class Context {
	
	private RouteStrategy strategy;

	public void setStrategy(RouteStrategy strategy) {
		this.strategy = strategy;
	}
	
	void buildRoute(String placeA, String placeB) {
		strategy.buildRoute(placeA, placeB);
		// return route decided as per above line
	}
	
}


interface RouteStrategy {
	
	void buildRoute(String placeA, String placeB);
	
}

class RoadStrategy implements RouteStrategy {

	@Override
	public void buildRoute(String placeA, String placeB) {
		System.out.println("Building route from " + placeA + " to " + placeB + " via Road");
	}
}

class WalkingStrategy implements RouteStrategy {

	@Override
	public void buildRoute(String placeA, String placeB) {
		System.out.println("Building route from " + placeA + " to " + placeB + " via Walking");		
	}
}

class PublicTransportStrategy implements RouteStrategy {

	@Override
	public void buildRoute(String placeA, String placeB) {
		System.out.println("Building route from " + placeA + " to " + placeB + " via Public Transport");
	}
}
