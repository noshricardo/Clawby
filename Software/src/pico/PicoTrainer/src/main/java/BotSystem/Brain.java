/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BotSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import static java.lang.Math.exp;
import org.ejml.data.FMatrixRMaj;
import org.ejml.data.Matrix;
import org.ejml.dense.row.CommonOps_FDRM;

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
   
   public float[] computeMotion(float distLeft, float distMiddle, float distRight){
       float[] out = {0,0};
       float a[][] = {{distLeft,distMiddle,distRight}};
       float e = (float)exp(1.0);
       FMatrixRMaj in = new FMatrixRMaj(a);
       //System.out.println(in);
       //System.out.println(layer1);
       //System.out.println(layer1Bias);
       FMatrixRMaj tmp = layer1Bias.createLike();
       CommonOps_FDRM.mult(in, layer1, tmp);
       CommonOps_FDRM.add(1.0f, layer1Bias,1.0f, tmp, tmp);
       CommonOps_FDRM.scale(-1.0f, tmp);
       CommonOps_FDRM.elementPower(e, tmp, tmp);
       CommonOps_FDRM.add(tmp, 1.0f, tmp);
       CommonOps_FDRM.divide(1.0f, tmp);
       
       FMatrixRMaj tmp2 = layer2Bias.createLike();
       CommonOps_FDRM.mult(tmp, layer2, tmp2);
       CommonOps_FDRM.add(1.0f, layer2Bias,1.0f, tmp2, tmp2);
       CommonOps_FDRM.scale(-1.0f, tmp2);
       CommonOps_FDRM.elementPower(e, tmp2, tmp2);
       CommonOps_FDRM.add(tmp2, 1.0f, tmp2);
       CommonOps_FDRM.divide(1.0f, tmp2);
       
       FMatrixRMaj tmp3 = layer3Bias.createLike();
       CommonOps_FDRM.mult(tmp2, layer3, tmp3);
       CommonOps_FDRM.add(1.0f, layer3Bias,1.0f, tmp3, tmp3);
       CommonOps_FDRM.scale(-1.0f, tmp3);
       CommonOps_FDRM.elementPower(e, tmp3, tmp3);
       CommonOps_FDRM.add(tmp3, 1.0f, tmp3);
       CommonOps_FDRM.divide(1.0f, tmp3);
       
       FMatrixRMaj tmp4 = layer4Bias.createLike();
       System.out.println(tmp3);
       System.out.println(layer4);
       CommonOps_FDRM.mult(tmp3, layer4, tmp4);
       CommonOps_FDRM.add(1.0f, layer4Bias,1.0f, tmp4, tmp4);
       CommonOps_FDRM.scale(-1.0f, tmp4);
       CommonOps_FDRM.elementPower(e, tmp4, tmp4);
       CommonOps_FDRM.add(tmp4, 1.0f, tmp4);
       CommonOps_FDRM.divide(1.0f, tmp4);
       
       out = tmp4.data;
       
       return out;
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
       layer1 = new FMatrixRMaj(y,x);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer1.set(i ,j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf(',')+1);
       y = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer2 = new FMatrixRMaj(y,x);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer2.set(i ,j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf(',')+1);
       y = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer3 = new FMatrixRMaj(y,x);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer3.set(i ,j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf(',')))).intValue();
       everything = everything.substring(everything.indexOf(',')+1);
       y = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer4 = new FMatrixRMaj(y,x);
       for (int i = 0; i < y; i ++){
           for(int j = 0; j < x; j++){
               layer4.set(i ,j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
               everything.stripLeading();
           } 
       }
       try(BufferedReader br = new BufferedReader(new FileReader("../pico_inteligence/Weights/neurons.h"))) {
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
       x = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       //System.out.println("layer1Bias lenght: " + x);
       layer1Bias = new FMatrixRMaj(1,x);
       for(int j = 0; j < x; j++){
           layer1Bias.set(0,j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer2Bias = new FMatrixRMaj(1,x);
       for(int j = 0; j < x; j++){
           layer2Bias.set(0,j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer3Bias = new FMatrixRMaj(1,x);
       for(int j = 0; j < x; j++){
           layer3Bias.set(0,j , (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       everything = everything.substring(everything.indexOf('<')+1);
       x = (new Integer(everything.substring(0, everything.indexOf('>')))).intValue();
       everything = everything.substring(everything.indexOf('{')+1);
       everything.stripLeading();
       layer4Bias = new FMatrixRMaj(1,x);
       for(int j = 0; j < x; j++){
           layer4Bias.set(0,j, (new Float(everything.substring(0, everything.indexOf(',')))).floatValue());
           everything.stripLeading();
       } 
       
       
       
       
   }
   
   
    
    
}
