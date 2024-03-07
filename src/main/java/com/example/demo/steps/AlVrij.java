package com.example.demo.steps;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AlVrij implements IStep {
  public final static String NAME = AlVrij.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.getData().isAlreadyOff() ){
      if(state.isLoggingEnabled()){
        System.out.println("Is al vrij: ja");
      }

      return stepService.getStepByName(KorteBroekAan.NAME);
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Is al vrij: nee");
      }

      return stepService.getStepByName(Thuiswerken.NAME);
    }
  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
