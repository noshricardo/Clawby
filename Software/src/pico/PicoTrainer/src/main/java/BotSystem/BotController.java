/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BotSystem;

import com.jme3.asset.AssetManager;
import com.jme3.scene.Node;
import java.util.ArrayList;

/**
 *
 * @author nosh
 */
public class BotController {
    
    
    ThreadController threadController;
    ArrayList<Bot> bots = new ArrayList<>();
    
    public BotController(int numBots, Node rootNode, AssetManager assetManager){
        threadController = new ThreadController();
        for(int i = 0; i < numBots; i++){
            bots.add(new Bot(rootNode, assetManager));
        }
    }
    
    public void update(float tpf){
        for(int i = 0; i < bots.size(); i++){
            bots.get(i).setTpf(tpf);
            threadController.dispatchThread(bots.get(i));
        }
        while(!threadController.done()){
            
        }
    }
    
}
