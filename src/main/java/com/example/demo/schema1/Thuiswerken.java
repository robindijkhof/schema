package com.example.demo.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class Thuiswerken implements IStep {
  public final static String NAME = Thuiswerken.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if (state.getData().isWorkingFromHome()) {
      if (state.isLoggingEnabled()) {
        System.out.println("Is thuiswerken: ja");
      }

      return stepService.getStepByName(KorteBroekAan.NAME);
    } else {
      if (state.isLoggingEnabled()) {
        System.out.println("Is thuiswerken: nee");
      }

      return stepService.getStepByName(LangeBroekAan.NAME);
    }
  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
