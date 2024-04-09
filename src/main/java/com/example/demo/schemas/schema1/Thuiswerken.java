package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IConditionalStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class Thuiswerken implements IConditionalStep {
  public final static String NAME = Thuiswerken.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if (state.getData().isWorkingFromHome()) {
      if (state.isLoggingEnabled()) {
        System.out.println("Is thuiswerken: ja");
      }

      return stepService.getStepByName(getPositiveStepName());
    } else {
      if (state.isLoggingEnabled()) {
        System.out.println("Is thuiswerken: nee");
      }

      return stepService.getStepByName(getNegativeStepName());
    }
  }

  @Override
  public String getStepName() {
    return NAME;
  }

  @Override
  public String getPositiveStepName() {
    return KorteBroekAan.NAME;
  }

  @Override
  public String getNegativeStepName() {
    return LangeBroekAan.NAME;
  }
}
