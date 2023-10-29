/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BotSystem;

import java.util.ArrayList;

/**
 *
 * @author nosh
 */

public class ThreadController{
    
    ArrayList<BotThread> threads = new ArrayList<>();
    
    public void dispatchThread(Bot bot){
        threads.add(new BotThread(bot));
    }
    
    public boolean done(){
        boolean done = true;
        for(int i = 0; i < threads.size(); i++){
            if(threads.get(i).isAlive()){
                done=false;
            }else{
                threads.remove(i);
            }
        }
        
        return done;
    }
    
    
}
