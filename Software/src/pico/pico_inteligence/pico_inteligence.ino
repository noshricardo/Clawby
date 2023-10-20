#include <BasicLinearAlgebra.h>
#include "Weights/Weights.h"
#include "Weights/neurons.h"

using namespace BLA;

BLA::Matrix<3> input;
BLA::Matrix<2> output;
BLA::Matrix<2> tmp;

int m1f = 1;
int m1b = 2;
int m2f = 3;
int m2b = 4;

int dist1;
int dist2;
int dist3;


void setup(){
  pinMode(m1f, OUTPUT);
  pinMode(m1b, OUTPUT);
  pinMode(m2f, OUTPUT);
  pinMode(m2b, OUTPUT);
}

void setup1(){
  Serial.begin(115200);
  Serial.setTimeout(10000);
}

void loop1(){
  //simulate sonar input from serial inputs
  Serial.read();
  delay(2);
  
  Serial.print("input left sonar sensor dist: ");
  dist1 = Serial.parseInt();
  Serial.println(dist1);
  
  Serial.print("input middle sonar sensor dist: ");
  dist2 = Serial.parseInt();
  Serial.println(dist2);
  
  Serial.print("input right sonar sensor dist: ");
  dist3 = Serial.parseInt();
  Serial.println(dist3);

  input(0) = float(dist1);
  input(1) = float(dist2);
  input(2) = float(dist3);
  delay(10);
  Serial << "Left Motor: " << output(0) << " Right Motor: " << output(1) << "\n";
  Serial << "input vals: " << input << " output vals: " << output << "\n";
  Serial << "raw out(no sigmoid): " << tmp << "\n";
}

void loop(){
  tmp = (layer1 * (input + inputBias)) + outputBias;
  for(int i = 0; i < 2; i++){
    output(i) = (1/(1 + exp(-(tmp(i)))));
  }
  if(output(1) < 0.5){
    digitalWrite(m1f, LOW);
    analogWrite(m1b, abs(output(1)*255));
  }
  if(output(1) > 0.5){
    digitalWrite(m1b, LOW);
    analogWrite(m1f, abs(output(1)*255));
  }
  if(output(2) < 0.5){
    digitalWrite(m2f, LOW);
    analogWrite(m2b, abs(output(2)*255));
  }
  if(output(2) > 0.5){
    digitalWrite(m2b, LOW);
    analogWrite(m2f, abs(output(2)*255));
  }
}
