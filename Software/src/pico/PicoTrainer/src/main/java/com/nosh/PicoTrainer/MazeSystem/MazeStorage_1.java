package com.nosh.PicoTrainer.MazeSystem;

import java.util.ArrayList;

public class MazeStorage_1 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 882079402549675391L;

	private ArrayList<int[][]> mazes = new ArrayList<>();
	
	public int[][] getMaze(int mazeNum){
		return mazes.get(mazeNum);
	}
	
	public int size() {
		return mazes.size();
	}
	
	public void addMaze(int[][] mazeIn) {
		mazes.add(mazeIn);
	}
	public void setMaze(int mazeNum, int[][] mazeIn) {
		mazes.set(mazeNum+1, mazeIn);
	}
        

}
