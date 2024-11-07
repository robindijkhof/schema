package com.example.demo.schemas;

import com.example.demo.StepperState;

public interface IEndLoopStep extends IDecisionStep {
  Class<? extends IStartLoopStep> getLoopStartStep();

  Class<? extends IStep> getLoopAfterEndStep();

  boolean endLoop(StepperState state);

  @Override
  default Class<? extends IStep> getNegativeStepClass(){
    return getLoopStartStep();
  }

  @Override
  default Class<? extends IStep> getPositiveStepClass(){
    return getLoopAfterEndStep();
  }

  @Override
  default boolean doStep(StepperState state) {
    return endLoop(state);
  }
}
