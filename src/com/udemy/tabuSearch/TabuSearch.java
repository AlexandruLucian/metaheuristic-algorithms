package com.udemy.tabuSearch;

import java.util.List;

public class TabuSearch {

	private State[][] states;

	private TabuList tabuList;

	private NeighbourSolutionHandler neighbourSolutionHandler;

	public TabuSearch(State[][] states) {
		this.states = states;
		this.tabuList = new TabuList();
		this.neighbourSolutionHandler = new NeighbourSolutionHandler();
	}

	public State solve(State initialSolution) {

		State bestState = initialSolution;
		State currentState = initialSolution;

		int iterationCounter = 0;

		while(iterationCounter<Constants.NUM_ITERATIONS) {

			//get all the available state in the neighbourhood
			List<State> candidateNeighbours = currentState.getNeighbours();
			//get the tabu list
			List<State> solutionsTabu = tabuList.getTabuItems();

			//get the best neighbour and make sure is not in teh tabu list
			State bestNeighbourFound = neighbourSolutionHandler.getBestNeighbour(states, candidateNeighbours,
					solutionsTabu);

			// we are looking for a minimum value
			if (bestNeighbourFound.getZ() < bestState.getZ()) {
				bestState = bestNeighbourFound;
			}

			// we add the state to the tabu list
			tabuList.add(currentState);

			// hop to the next state
			currentState = bestNeighbourFound;

			iterationCounter++;

		}
		return bestState;
	}
}
