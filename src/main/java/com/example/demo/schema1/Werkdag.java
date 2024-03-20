package com.example.demo.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class Werkdag implements IStep {
  public final static String NAME = Werkdag.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.getData().isWorkDay() ){
      if(state.isLoggingEnabled()){
        System.out.println("Is een werkdag: ja");
      }

      return stepService.getStepByName(AlVrij.NAME);
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Is een werkdag: nee");
      }

      return stepService.getStepByName(KorteBroekAan.NAME);
    }
  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
