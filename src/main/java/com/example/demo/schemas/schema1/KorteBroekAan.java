package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.model.Member;
import com.example.demo.schemas.IProcessStep;
import com.example.demo.schemas.IStep;
import com.example.demo.schemas.loops.ILoopedProcessStep;
import org.springframework.stereotype.Component;

@Component
public class KorteBroekAan implements ILoopedProcessStep {
  @Override
  public void doStep(StepperState state, int index) {
    Member member = state.getData().getMembers().get(index);
    state.getBroekResultaat().put(member.getName(), "Korte broek");
  }

  @Override
  public Class<? extends IStep> getNextStepClass() {
    return EndMemberLoop.class;
  }
}
