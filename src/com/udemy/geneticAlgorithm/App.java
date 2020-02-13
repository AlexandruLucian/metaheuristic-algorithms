package com.udemy.geneticAlgorithm;

public class App {

	public static void main(String[] args) {

		GeneticAlgorithm algorithm = new GeneticAlgorithm();

		Population population = new Population(100);
		population.initialize();

		int generationCounter = 0;

		while (population.getFitTestIndividual().getFitness() != Constants.MAX_FITNESS) {

			++generationCounter;
			System.out.println("Generation: " + generationCounter + " - fitness is : "
					+ population.getFitTestIndividual().getFitness());
			System.out.println(population.getFitTestIndividual() + "\n");

			population = algorithm.evolvePopulation(population);
		}

		System.out.println("Solution found!!!");
		System.out.println(population.getFitTestIndividual());
	}

}
