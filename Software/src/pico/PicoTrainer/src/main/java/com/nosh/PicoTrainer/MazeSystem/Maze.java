package com.nosh.PicoTrainer.MazeSystem;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import java.util.ArrayList;




public class Maze {
	ArrayList<MazeTile> maze = new ArrayList<>();
	String mazeString;
	MazeStorage mazeStorage;
        
        
	public Maze(MazeStorage mazeStorage) {
            this.mazeStorage = mazeStorage;
		for(int i = 0; i < mazeStorage.getMaze(0).length; i++){
                    for(int j = 0; j < mazeStorage.getMaze(0)[0].length; j++){
                        if(mazeStorage.getMaze(0)[i][j] == 1){
                            maze.add(new MazeTile(i,j,0,0,"Wall", 0, 0));
                        }
                    }
                }
	}
	
        public MazeStorage getMaze(){
            return mazeStorage;
        }
        
        
        
        public void drawMaze(AssetManager assetManager, Node rootNode){
            for(int i = 0; i < maze.size(); i++){
                maze.get(i).setModel(assetManager, rootNode);
            }
           
            //bulletAppState.getPhysicsSpace().add();
        }
        
        
	public void genMaze(int mazeNum, int viewx, int viewy, float fx, float fy) {
            
        }
	
}
