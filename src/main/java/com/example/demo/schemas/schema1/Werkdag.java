package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class Werkdag implements IDecisionStep {
  public final static String NAME = Werkdag.class.getName();


  @Override
  public boolean doStep(StepperState state) {
//    if(state.getData().isWorkDay() ){
//      if(state.isLoggingEnabled()){
//        System.out.println("Is een werkdag: ja");
//      }
//
//      return true;
//    }else {
//      if(state.isLoggingEnabled()){
//        System.out.println("Is een werkdag: nee");
//      }
//
//      return false;
//    }

    return true;
  }



  @Override
  public Class<? extends IStep> getPositiveStepClass() {
    return AlVrij.class;
  }

  @Override
  public Class<? extends IStep> getNegativeStepClass() {
    return AllemaalKorteBroekAan.class;
  }
}
