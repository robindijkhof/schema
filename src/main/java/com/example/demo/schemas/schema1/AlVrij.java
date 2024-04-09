package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IConditionalStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AlVrij implements IConditionalStep {
  public final static String NAME = AlVrij.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.getData().isAlreadyOff() ){
      if(state.isLoggingEnabled()){
        System.out.println("Is al vrij: ja");
      }

      return stepService.getStepByName(getPositiveStepName());
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Is al vrij: nee");
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
    return Thuiswerken.NAME;
  }
}
