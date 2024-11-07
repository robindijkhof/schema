package com.example.demo;

import com.example.demo.model.Data;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class StepperState {
  boolean loggingEnabled;
  Data data;

  Map<String, String> broekResultaat = new HashMap<>();

  public StepperState(boolean loggingEnabled, Data data){
    this.loggingEnabled = loggingEnabled;
    this.data = data;
  }
}
