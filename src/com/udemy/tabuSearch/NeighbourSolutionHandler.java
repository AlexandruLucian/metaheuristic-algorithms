package com.udemy.tabuSearch;

import java.util.List;

public class NeighbourSolutionHandler {

	/**
	 * In every iteration we have to find the next state: so we have to consider the
	 * neighbours BUT we have to avoid the states from the tabu list
	 */

	public State getBestNeighbour(State[][] states, List<State> neighbourStates, List<State> tabuStates) {

		// we want to remove all the tabu states present in the neighbour states list
		neighbourStates.remove(tabuStates);

		// if all the neighbour states are into tabu list lets go to the middle state
		if (neighbourStates.size() == 0)
			return states[100][100];

		State bestSolution = neighbourStates.get(0);

		for (int i = 0; i < neighbourStates.size(); i++) {
			if (neighbourStates.get(i).getZ() < bestSolution.getZ()) {
				bestSolution = neighbourStates.get(i);
			}
		}
		System.out.println("Best solution is : " + bestSolution);
		return bestSolution;
	}
}
