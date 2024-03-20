package com.example.demo.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class LangeBroekAan implements IStep {
  public final static String NAME = LangeBroekAan.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    state.getData().setBroeksoort("Lange broek");

    return stepService.getStepByName(InformeerBroek.NAME);
  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
