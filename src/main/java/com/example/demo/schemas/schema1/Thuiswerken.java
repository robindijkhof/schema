package com.example.demo.schemas.schema1;

import com.example.demo.StepperState;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class Thuiswerken implements IDecisionStep {
  public final static String NAME = Thuiswerken.class.getName();


  @Override
  public boolean doStep(StepperState state) {
//    if (state.getData().isWorkingFromHome()) {
//      if (state.isLoggingEnabled()) {
//        System.out.println("Is thuiswerken: ja");
//      }
//
//      return true;
//    } else {
//      if (state.isLoggingEnabled()) {
//        System.out.println("Is thuiswerken: nee");
//      }
//
//      return false;
//    }

    return true;
  }



  @Override
  public Class<? extends IStep> getPositiveStepClass() {
    return KorteBroekAan.class;
  }

  @Override
  public Class<? extends IStep> getNegativeStepClass() {
    return LangeBroekAan.class;
  }
}
