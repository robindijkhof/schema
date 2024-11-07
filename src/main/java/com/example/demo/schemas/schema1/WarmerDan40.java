package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class WarmerDan40 implements IDecisionStep {
  public final static String NAME = WarmerDan40.class.getName();


  @Override
  public boolean doStep(StepperState state) {
    if(state.getData().getTemperature() > 40 ){
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 40: ja");
      }

      return true;
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Warmer dan 40: nee");
      }

      return true;
    }
  }


  @Override
  public Class<? extends IStep> getPositiveStepClass() {
    return AllemaalKorteBroekAan.class;
  }

  @Override
  public Class<? extends IStep> getNegativeStepClass() {
    return StartMemberLoop.class;
  }
}
