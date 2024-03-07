package com.example.demo.steps;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class WarmerDan20 implements IStep {
  public final static String NAME = WarmerDan20.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.getData().getTemperature() > 20 ){
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 20: ja");
      }

      return stepService.getStepByName(WarmerDan40.NAME);
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 20: nee");
      }

      return stepService.getStepByName(LangeBroekAan.NAME);
    }
  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
