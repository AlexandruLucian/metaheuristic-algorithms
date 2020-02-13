package com.udemy.tabuSearch;

import java.util.ArrayList;
import java.util.List;

public class State {

	private double x;

	private double y;

	private double z; // f(x,y)

	private List<State> neighbours;

	public State(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.neighbours = new ArrayList<>();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public List<State> getNeighbours() {
		return neighbours;
	}

	public void addNeighbour(State state) {
		this.neighbours.add(state);
	}

	@Override
	public String toString() {
		return "(" + this.x + ";" + this.y + ";" + this.z + ")";
	}
}
