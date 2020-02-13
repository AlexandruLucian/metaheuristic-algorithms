package com.udemy.geneticAlgorithm;

import java.util.Random;

public class Individual {

	private int[] genes;
	private int fitness;
	private Random randomGenerator;

	public Individual() {
		this.genes = new int[Constants.CHROMOZOME_LENGHT];
		this.randomGenerator = new Random();
	}

	public void generateIndividual() {
		for (int i = 0; i < Constants.CHROMOZOME_LENGHT; i++) {
			genes[i] = randomGenerator.nextInt(Constants.SOLUTION_SEQUENCE.length);
		}
	}

	public int getFitness() {
		if (fitness == 0) {
			for (int i = 0; i < Constants.CHROMOZOME_LENGHT; i++) {
				if (getGene(i) == Constants.SOLUTION_SEQUENCE[i]) {
					fitness++;
				}
			}
		}
		return fitness;
	}

	public int getGene(int index) {
		return genes[index];
	}

	public void setGene(int index, int value) {
		genes[index] = value;
		fitness = 0;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < Constants.CHROMOZOME_LENGHT; i++) {
			builder.append(getGene(i));
			builder.append(", ");
		}
		return builder.toString();
	}
}
