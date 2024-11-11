package com.example.demo.schemas.loops;

import com.example.demo.StepperState;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IStep;

public interface IStartLoopStep extends IDecisionStep {

  Class<? extends IStep> getLoopStartStep();

  Class<? extends IStep> getLoopCompletedStep();

  boolean executeLoop(StepperState state);

  void increaseIndex();

  int getIndex();

  @Override
  default Class<? extends IStep> getNegativeStepClass(){
    return getLoopCompletedStep();
  }

  @Override
  default Class<? extends IStep> getPositiveStepClass(){
    return getLoopStartStep();
  }

  @Override
  default boolean doStep(StepperState state) {
    return executeLoop(state);
  }



}
