package com.example.demo.schemas;

import com.example.demo.StepperState;

public interface IDecisionStep extends IStep{

  boolean doStep(StepperState state);

  Class<? extends IStep> getPositiveStepClass();
  Class<? extends IStep> getNegativeStepClass();
}
