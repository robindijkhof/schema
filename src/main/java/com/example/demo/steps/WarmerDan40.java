package com.example.demo.steps;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WarmerDan40 implements IStep {
  public final static String NAME = WarmerDan40.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.getData().getTemperature() > 40 ){
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 40: ja");
      }

      return stepService.getStepByName(KorteBroekAan.NAME);
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 40: nee");
      }

      return stepService.getStepByName(Werkdag.NAME);
    }
  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
