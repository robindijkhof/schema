package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.IProcessStep;
import com.example.demo.schemas.IStep;
import org.springframework.stereotype.Component;

@Component
public class KorteBroekAan implements IProcessStep {
  @Override
  public void doStep(StepperState state) {

  }

  @Override
  public Class<? extends IStep> getNextStepClass() {
    return EndMemberLoop.class;
  }
}
