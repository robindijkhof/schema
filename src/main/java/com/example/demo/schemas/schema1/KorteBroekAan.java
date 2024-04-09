package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IProcesStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class KorteBroekAan implements IProcesStep {
  public final static String NAME = KorteBroekAan.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    state.getData().setBroeksoort("Korte broek");

    return stepService.getStepByName(getNextStepName());

  }

  @Override
  public String getStepName() {
    return NAME;
  }

  @Override
  public String getNextStepName() {
    return InformeerBroek.NAME;
  }
}
