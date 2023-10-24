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
   
   public float[] computeMotionL4O(float distLeft, float distMiddle, float distRight){
       float[] out = {0,0};
       float a[][] = {{distLeft,distMiddle,distRight}};
       float e = (float)exp(1.0);
       System.out.println("e = " + e);
       FMatrixRMaj in = new FMatrixRMaj(a);
       
       FMatrixRMaj tmp = layer4Bias.createLike();
       CommonOps_FDRM.mult(in, layer4, tmp);
       System.out.println(tmp);
       CommonOps_FDRM.add(1.0f, layer4Bias,1.0f, tmp, tmp);
       System.out.println(tmp);
       CommonOps_FDRM.scale(-1.0f, tmp);
       System.out.println(tmp);
       CommonOps_FDRM.elementPower(e, tmp, tmp);
       System.out.println(tmp);
       CommonOps_FDRM.add(tmp, 1.0f);
       System.out.println(tmp);
       CommonOps_FDRM.divide(1.0f, tmp);
       System.out.println(tmp);
       
       out = tmp.data;
       
       return out;
   }
   
   
   
   public float[] computeMotion(float distLeft, float distMiddle, float distRight){
       float[] out = {0,0};
       float a[][] = {{distLeft,distMiddle,distRight}};
       float e = (float)exp(1.0);
       System.out.println("e = " + e);
       FMatrixRMaj in = new FMatrixRMaj(a);
       /*
       CommonOps_FDRM.scale(-1.0f, in);
       CommonOps_FDRM.elementPower(e, in, in);
       CommonOps_FDRM.add(in, 1.0f);
       CommonOps_FDRM.divide(1.0f, in);
       */
       //System.out.println(in);
       //System.out.println(layer1);
       //System.out.println(layer1Bias);
       FMatrixRMaj tmp = layer1Bias.createLike();
       CommonOps_FDRM.mult(in, layer1, tmp);
       CommonOps_FDRM.add(1.0f, layer1Bias,1.0f, tmp, tmp);
       CommonOps_FDRM.scale(-1.0f, tmp);
       CommonOps_FDRM.elementPower(e, tmp, tmp);
       CommonOps_FDRM.add(tmp, 1.0f);
       CommonOps_FDRM.divide(1.0f, tmp);
       
       FMatrixRMaj tmp2 = layer2Bias.createLike();
       CommonOps_FDRM.mult(tmp, layer2, tmp2);
       CommonOps_FDRM.add(1.0f, layer2Bias,1.0f, tmp2, tmp2);
       CommonOps_FDRM.scale(-1.0f, tmp2);
       CommonOps_FDRM.elementPower(e, tmp2, tmp2);
       CommonOps_FDRM.add(tmp2, 1.0f);
       CommonOps_FDRM.divide(1.0f, tmp2);
       
       FMatrixRMaj tmp3 = layer3Bias.createLike();
       CommonOps_FDRM.mult(tmp2, layer3, tmp3);
       CommonOps_FDRM.add(1.0f, layer3Bias,1.0f, tmp3, tmp3);
       CommonOps_FDRM.scale(-1.0f, tmp3);
       CommonOps_FDRM.elementPower(e, tmp3, tmp3);
       CommonOps_FDRM.add(tmp3, 1.0f);
       CommonOps_FDRM.divide(1.0f, tmp3);
       
       FMatrixRMaj tmp4 = layer4Bias.createLike();
       //System.out.println(tmp3);
       //System.out.println(layer4);
       CommonOps_FDRM.mult(tmp3, layer4, tmp4);
       CommonOps_FDRM.add(1.0f, layer4Bias,1.0f, tmp4, tmp4);
       CommonOps_FDRM.scale(-1.0f, tmp4);
       CommonOps_FDRM.elementPower(e, tmp4, tmp4);
       CommonOps_FDRM.add(tmp4, 1.0f);
       CommonOps_FDRM.divide(1.0f, tmp4);
       
       out = tmp4.data;
       
       return out;
   }
   
   public void setRandomParams(){
       for(int i = 0; i < layer1.numCols; i++){
           for(int j = 0; j < layer1.numRows; j++){
               layer1.set(j, i, (float)Math.random());
           } 
       }
       for(int i = 0; i < layer2.numCols; i++){
           for(int j = 0; j < layer2.numRows; j++){
               layer2.set(j, i, (float)Math.random());
           } 
       }
       for(int i = 0; i < layer3.numCols; i++){
           for(int j = 0; j < layer3.numRows; j++){
               layer3.set(j, i, (float)Math.random());
           } 
       }
       for(int i = 0; i < layer4.numCols; i++){
           for(int j = 0; j < layer4.numRows; j++){
               layer4.set(j, i, (float)Math.random());
           } 
       }
       for(int i = 0; i < layer1Bias.numCols; i++){
           for(int j = 0; j < layer1Bias.numRows; j++){
               layer1Bias.set(j, i, (float)Math.random());
           } 
       }
       for(int i = 0; i < layer2Bias.numCols; i++){
           for(int j = 0; j < layer2Bias.numRows; j++){
               layer2Bias.set(j, i, (float)Math.random());
           } 
       }
       for(int i = 0; i < layer3Bias.numCols; i++){
           for(int j = 0; j < layer3Bias.numRows; j++){
               layer3Bias.set(j, i, (float)Math.random());
           } 
       }
       for(int i = 0; i < layer4Bias.numCols; i++){
           for(int j = 0; j < layer4Bias.numRows; j++){
               layer4Bias.set(j, i, (float)Math.random());
           } 
       }
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
