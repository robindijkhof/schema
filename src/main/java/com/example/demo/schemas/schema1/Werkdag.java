package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IConditionalStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class Werkdag implements IConditionalStep {
  public final static String NAME = Werkdag.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.getData().isWorkDay() ){
      if(state.isLoggingEnabled()){
        System.out.println("Is een werkdag: ja");
      }

      return stepService.getStepByName(getPositiveStepName());
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Is een werkdag: nee");
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
    return AlVrij.NAME;
  }

  @Override
  public String getNegativeStepName() {
    return KorteBroekAan.NAME;
  }
}
