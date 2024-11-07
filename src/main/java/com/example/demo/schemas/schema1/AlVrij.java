package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class AlVrij implements IDecisionStep {
  public final static String NAME = AlVrij.class.getName();


  @Override
  public boolean doStep(StepperState state) {
    if(state.getData().isAlreadyOff() ){
      if(state.isLoggingEnabled()){
        System.out.println("Is al vrij: ja");
      }

      return true;
    }else {
      if(state.isLoggingEnabled()){
        System.out.println("Is al vrij: nee");
      }

      return false;
    }
  }



  @Override
  public Class<? extends IStep> getPositiveStepClass() {
    return KorteBroekAan.class;
  }

  @Override
  public Class<? extends IStep> getNegativeStepClass() {
    return Thuiswerken.class;
  }
}
