package com.nosh.PicoTrainer;

import BotSystem.Bot;
import BotSystem.Brain;
import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.nosh.PicoTrainer.MazeSystem.Maze;
import com.nosh.PicoTrainer.MazeSystem.MazeGenerator;
import com.nosh.PicoTrainer.MazeSystem.MazeStorage;

/**
 * This is the Main Class of your Game. You should only do initialization here.
 * Move your Logic into AppStates or Controls
 * @author normenhansen
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Brain brain = new Brain();
        brain.readParams();
        
        
        this.cam.setFrustumFar(100000);
        Maze maze = new Maze(MazeGenerator.genRandomMaze(new MazeStorage(), 100, 100));
        maze.drawMaze(assetManager, rootNode);
        Bot bot = new Bot(rootNode, assetManager);
        flyCam.setMoveSpeed(100);
    }

    @Override
    public void simpleUpdate(float tpf) {
        //TODO: add update code
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}

