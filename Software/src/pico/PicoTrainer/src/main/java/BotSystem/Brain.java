/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BotSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.Matrix;

/**
 *
 * @author nosh
 */






public class Brain {
    
    FMatrixRMaj layer1;
    FMatrixRMaj layer2;
    FMatrixRMaj layer3;
    FMatrixRMaj layer4;
    FMatrixRMaj layer1Bias;
    FMatrixRMaj layer2Bias;
    FMatrixRMaj layer3Bias;
    FMatrixRMaj layer4Bias;
    
   public Brain(){
       
   }
   
   public void readParams(){
       String everything = "";
       try(BufferedReader br = new BufferedReader(new FileReader("../pico_inteligence/Weights/Weights.h"))) {
           StringBuilder sb = new StringBuilder();
           String line = br.readLine();
           while (line != null) {
               sb.append(line);
               sb.append(System.lineSeparator());
               line = br.readLine();
           }
           everything = sb.toString();
       }catch(Exception e){
           
       }
       everything = everything.substring(everything.indexOf('<')+1);
       int x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf(',')+1);
       int y = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer1 = new FMatrixRMaj(x,y);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer1.set(j ,i , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf(',')+1);
       y = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer2 = new FMatrixRMaj(x,y);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer2.set(j ,i , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf(',')+1);
       y = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer3 = new FMatrixRMaj(x,y);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer3.set(j ,i , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf(',')+1);
       y = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer4 = new FMatrixRMaj(x,y);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer4.set(j ,i , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       try(BufferedReader br = new BufferedReader(new FileReader("../pico_inteligence/Weights/Weights.h"))) {
           StringBuilder sb = new StringBuilder();
           String line = br.readLine();
           while (line != null) {
               sb.append(line);
               sb.append(System.lineSeparator());
               line = br.readLine();
           }
           everything = sb.toString();
       }catch(Exception e){
           
       }
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer1Bias = new FMatrixRMaj(x);
       for(int j = 0; j < x; j++){
           layer1Bias.set(j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer2Bias = new FMatrixRMaj(x);
       for(int j = 0; j < x; j++){
           layer2Bias.set(j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer3Bias = new FMatrixRMaj(x);
       for(int j = 0; j < x; j++){
           layer3Bias.set(j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer4Bias = new FMatrixRMaj(x);
       for(int j = 0; j < x; j++){
           layer4Bias.set(j, (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       
       
       
       
   }
   
   
    
    
}
