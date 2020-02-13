package com.udemy.geneticAlgorithm;

import java.util.Random;

public class GeneticAlgorithm {

	private Random randomGenerator;

	public GeneticAlgorithm() {
		randomGenerator = new Random();
	}

	public Population evolvePopulation(Population population) {

		Population newPopulation = new Population(population.size());

		for (int i = 0; i < population.size(); i++) {
			Individual firstIndividual = randomSelection(population);
			Individual secondIndividual = randomSelection(population);
			Individual newIndividual = crossOver(firstIndividual, secondIndividual);
			newPopulation.saveIndividual(i, newIndividual);
		}

		for (int i = 0; i < newPopulation.size(); i++) {
			mutate(newPopulation.getIndividual(i));
		}
		return newPopulation;
	}

	private Individual randomSelection(Population population) {

		Population newPopulation = new Population(Constants.TOURNAMENT_SIZE);

		for (int i = 0; i < Constants.TOURNAMENT_SIZE; i++) {
			int randomIndex = (int) (Math.random() * population.size());
			newPopulation.saveIndividual(i, population.getIndividual(randomIndex));
		}
		return newPopulation.getFitTestIndividual();
	}

	private Individual crossOver(Individual firstIndividual, Individual secondIndividual) {

		Individual newIndividual = new Individual();

		for (int i = 0; i < Constants.CHROMOZOME_LENGHT; i++) {
			if (Math.random() <= Constants.CROSSOVER_RATE) {
				newIndividual.setGene(i, firstIndividual.getGene(i));
			} else {
				newIndividual.setGene(i, secondIndividual.getGene(i));
			}
		}
		return newIndividual;
	}

	private void mutate(Individual individual) {

		for(int i=0; i<Constants.CHROMOZOME_LENGHT;i++) {
			if(Math.random() <= Constants.MUTATION_RATE) {
				int gene = randomGenerator.nextInt(Constants.SOLUTION_SEQUENCE.length);
				individual.setGene(i, gene);
			}
		}
	}
}