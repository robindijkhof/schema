package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.loops.IStartLoopStep;
import com.example.demo.schemas.IStep;
import org.springframework.stereotype.Component;

@Component
public class StartMemberLoop implements IStartLoopStep {

  private int index = 0;

  @Override
  public Class<? extends IStep> getLoopStartStep() {
    return Werkdag.class;
  }

  @Override
  public Class<? extends IStep> getLoopCompletedStep() {
    return InformeerAlleBroeken.class;
  }

  @Override
  public boolean executeLoop(StepperState state) {
    return index < state.getData().getMembers().size();
  }

  @Override
  public void increaseIndex() {
    index++;
  }

  @Override
  public int getIndex() {
    return index;
  }


}
