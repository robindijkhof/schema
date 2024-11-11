package com.example.demo.schemas;

import com.example.demo.StepperState;

public interface IProcessStep extends IStep {
  void doStep(StepperState state);

  Class<? extends IStep> getNextStepClass();
}
