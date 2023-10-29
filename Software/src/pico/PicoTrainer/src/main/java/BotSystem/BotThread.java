/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BotSystem;

/**
 *
 * @author nosh
 */
public class BotThread extends Thread{
    
    Bot bot;
    public BotThread(Bot bot){
        this.bot = bot;
        this.run();
    }
    
    
    @Override
    public void run(){
        bot.update();
    }
    
}
