package com.example.demo.steps;

import com.example.demo.StepService;
import com.example.demo.StepperState;

public interface IStep {

  IStep doStep(StepperState state, StepService stepService);

  String getStepName();


}
