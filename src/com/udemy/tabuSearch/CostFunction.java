package com.udemy.tabuSearch;

public class CostFunction {

	// we can define the function to optimise(find minimal or maximum)
	public static double f(double x, double y) {
		return Math.exp(-x * x - y * y) * Math.sin(x);
	}
}
