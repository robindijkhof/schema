package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class WarmerDan20 implements IDecisionStep {
  public final static String NAME = WarmerDan20.class.getName();


  @Override
  public boolean doStep(StepperState state) {
    if(state.getData().getTemperature() > 20 ){
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 20: ja");
      }

      return true;
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 20: nee");
      }

      return false;
    }
  }

  @Override
  public Class<? extends IStep> getPositiveStepClass() {
    return WarmerDan40.class;
  }

  @Override
  public Class<? extends IStep> getNegativeStepClass() {
    return AllemaalLangeBroekAan.class;
  }
}
