package com.nosh.PicoTrainer.MazeSystem;

import java.util.ArrayList;

public class MazeView implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4659651534180414749L;
	

	private ArrayList<int[][]> mazes = new ArrayList<>();
	
	public int[][] getMaze(int mazeNum){
		return mazes.get(mazeNum);
	}
	
	public void addMaze(int[][] mazeIn) {
		mazes.add(mazeIn);
	}
	public void setMaze(int mazeNum, int[][] mazeIn) {
		mazes.set(mazeNum, mazeIn);
	}

}
