package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.model.Member;
import com.example.demo.schemas.IProcessStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class AllemaalKorteBroekAan implements IProcessStep {
  public final static String NAME = AllemaalKorteBroekAan.class.getName();


  @Override
  public void doStep(StepperState state) {
    for(Member m: state.getData().getMembers()){
      state.getBroekResultaat().put(m.getName(), "Korte broek");
    }
  }


  @Override
  public Class<? extends IStep> getNextStepClass() {
    return InformeerAlleBroeken.class;
  }
}
