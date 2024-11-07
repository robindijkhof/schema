package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.IEndLoopStep;
import com.example.demo.schemas.IStartLoopStep;
import com.example.demo.schemas.IStep;
import org.springframework.stereotype.Component;

@Component
public class EndMemberLoop implements IEndLoopStep {
  @Override
  public Class<? extends IStartLoopStep> getLoopStartStep() {
    return StartMemberLoop.class;
  }

  @Override
  public Class<? extends IStep> getLoopAfterEndStep() {
    return InformeerBroek.class;
  }

  @Override
  public boolean endLoop(StepperState state) {
    return false;
  }
}
