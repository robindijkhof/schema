package com.example.demo.schemas.loops;

import com.example.demo.StepperState;
import com.example.demo.schemas.IProcessStep;
import com.example.demo.schemas.IStep;

public interface ILoopedProcessStep extends IStep {
  void doStep(StepperState state, int index);

  Class<? extends IStep> getNextStepClass();
}
