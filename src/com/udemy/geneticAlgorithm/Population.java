package com.udemy.geneticAlgorithm;

public class Population {

	private Individual[] individuals;

	public Population(int size) {
		individuals = new Individual[size];
	}

	public void initialize() {
		for (int i = 0; i < individuals.length; i++) {
			Individual newIndividual = new Individual();
			newIndividual.generateIndividual();
			saveIndividual(i, newIndividual);
		}
	}

	public void saveIndividual(int index, Individual individual) {
		individuals[index] = individual;
	}

	public Individual getIndividual(int index) {
		return individuals[index];
	}

	public Individual getFitTestIndividual() {

		Individual individual = individuals[0];

		for (int i = 1; i < individuals.length; i++) {
			if (getIndividual(i).getFitness() >= individual.getFitness()) {
				individual = getIndividual(i);
			}
		}
		return individual;
	}

	public int size() {
		return individuals.length;
	}

}
