#include <BasicLinearAlgebra.h>
#include "Weights/Weights.h"

using namespace BLA;

BLA::Matrix<3> input;
BLA::Matrix<2> output;

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
  
}

void loop1(){
  //do input from sonar
  dist1 = 0;
  dist2 = 5;
  dist3 = 4;
  input(0) = float(dist1);
  input(1) = float(dist2);
  input(2) = float(dist3);
}

void loop(){
  BLA::Matrix<2> tmp = layer1 * input;
  for(int i = 0; i < 2; i++){
    output(i) = (1/(1 + exp(tmp(i))));
  }
  if(output(1) < 0){
    digitalWrite(m1f, LOW);
    analogWrite(m1b, abs(output(1)*255));
  }
  if(output(1) > 0){
    digitalWrite(m1b, LOW);
    analogWrite(m1f, abs(output(1)*255));
  }
  if(output(2) < 0){
    digitalWrite(m2f, LOW);
    analogWrite(m2b, abs(output(2)*255));
  }
  if(output(2) > 0){
    digitalWrite(m2b, LOW);
    analogWrite(m2f, abs(output(2)*255));
  }
}
