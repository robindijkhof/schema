package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.IStep;
import com.example.demo.schemas.loops.IEndLoopStep;
import org.springframework.stereotype.Component;

@Component
public class EndMemberLoop implements IEndLoopStep {

  @Override
  public void doStep(StepperState state, int index) {

  }

  @Override
  public Class<? extends IStep> getNextStepClass() {
    return StartMemberLoop.class;
  }
}
