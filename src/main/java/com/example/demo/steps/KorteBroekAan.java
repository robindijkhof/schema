package com.example.demo.steps;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class KorteBroekAan implements IStep {
  public final static String NAME = KorteBroekAan.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    state.getData().setBroeksoort("Korte broek");

    return stepService.getStepByName(InformeerBroek.NAME);

  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
