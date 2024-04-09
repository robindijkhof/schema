package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IConditionalStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class WarmerDan20 implements IConditionalStep {
  public final static String NAME = WarmerDan20.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.getData().getTemperature() > 20 ){
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 20: ja");
      }

      return stepService.getStepByName(getPositiveStepName());
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 20: nee");
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
    return WarmerDan40.NAME;
  }

  @Override
  public String getNegativeStepName() {
    return LangeBroekAan.NAME;
  }
}
