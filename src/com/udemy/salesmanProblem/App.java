package com.udemy.salesmanProblem;

public class App {

	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			City city = new City();
			Repository.addCity(city);
		}

		SimulatedAnnealing sa = new SimulatedAnnealing();
		sa.simulation();

		System.out.println("Final solutions distance is: " + sa.getBestTour().getDistance());
		System.out.println("Tour: " + sa.getBestTour());
	}
}
