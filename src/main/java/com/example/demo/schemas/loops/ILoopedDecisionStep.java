package com.example.demo.schemas.loops;

import com.example.demo.StepperState;
import com.example.demo.schemas.IStep;

public interface ILoopedDecisionStep extends IStep {

  boolean doStep(StepperState state, int index);

  Class<? extends IStep> getPositiveStepClass();
  Class<? extends IStep> getNegativeStepClass();
}
