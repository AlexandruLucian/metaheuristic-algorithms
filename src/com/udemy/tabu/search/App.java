package com.udemy.tabu.search;

public class App {

	public static void main(String[] args) {

		State[][] states = new State[Constants.NUM_VALUES][Constants.NUM_VALUES];

		int row = 0;
		int col = 0;

		// create states with x=[-10][10] and y=[-10][10] with step size 0.1
		for (double x = -10; x < 9.9; x += 0.1) {
			for (double y = -10; y < 9.9; y += 0.1) {
				states[row][col] = new State(x, y, CostFunction.f(x, y));
				col++;
			}
			col = 0;
			row++;
		}

		// set the neighbours for first column
		for (int i = 0; i < 200; i++) {
			states[i][0].addNeighbour(states[i][1]);
		}

		// set the neighbours for last column
		for (int i = 0; i < 200; i++) {
			states[i][199].addNeighbour(states[i][198]);
		}

		// set the neighbours for first row
		for (int i = 0; i < 200; i++) {
			states[0][i].addNeighbour(states[1][i]);
		}

		// set the neighbours for last row
		for (int i = 0; i < 200; i++) {
			states[199][i].addNeighbour(states[198][i]);
		}

		// set the neighbours for middle nodes
		for (int i = 1; i < 199; i++) {
			for (int j = 1; j < 199; j++) {
				states[i][j].addNeighbour(states[i - 1][j]);
				states[i][j].addNeighbour(states[i + 1][j]);
				states[i][j].addNeighbour(states[i][j - 1]);
				states[i][j].addNeighbour(states[i][j + 1]);
			}
		}

		TabuSearch tabuSearch = new TabuSearch(states);

		System.out.println(tabuSearch.solve(states[100][100]));
	}
}
