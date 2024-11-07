package com.example.demo;

import com.example.demo.model.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StepperState {
  boolean loggingEnabled;
  Data data;
  String broeksoort;

  public StepperState(boolean loggingEnabled, Data data){
    this.loggingEnabled = loggingEnabled;
    this.data = data;
  }
}
