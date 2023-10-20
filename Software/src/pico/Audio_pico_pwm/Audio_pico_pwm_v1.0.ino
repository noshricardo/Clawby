#include "Libs/Tetris_8bitPCM_hexdump_arduino.h" //Header file containing hexdump of music in byte[] array sample2

int currPos = 0; // sample position counter
int delayTime = 125; // (1/f) * 1000000, where f is sample frequency in hz

void setup() {
  //dissable RP2040 XIP cache as our audio does not benifit from it
  bool* XIP_EN = (bool*)XIP_CTRL_BASE; //ptr to cache EN bit
  (*XIP_EN) = (bool)0; // set cache EN bit to 0
  
  pinMode(20, OUTPUT); // initialize pin 20 as our output for sound
  pinMode(LED_BUILTIN, OUTPUT);
  //analogWriteResolution(8); // optionaly change bit depth, default is 8-bit
  //analogWriteRange(255); // change to max expected input value for chosen bit depth, default 255 (value for 8-bit)
  analogWriteFreq(1000000); // set PWM frequency to above norman human hering range to prevent buzzing
}

void nextVal(){
  // reset sample counter at end of track
  if(currPos == sizeof(sample2)/sizeof(sample2[0])){
    currPos = 0;
  }
  analogWrite(20, sample2[currPos]); //set output to sample value
  currPos++; // move to next sample
}

void loop() {
  nextVal(); // fetch and play next sample
  delayMicroseconds(delayTime);// wait calculated time untill next sample
}
