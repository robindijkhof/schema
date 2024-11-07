package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.ExitStep;
import com.example.demo.schemas.IProcesStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
class InformeerBroek implements IProcesStep {
  public final static String NAME = InformeerBroek.class.getName();


  @Override
  public void doStep(StepperState state) {
    if(state.isLoggingEnabled()){
      System.out.println("Log broek soort aan");
    }
    System.out.println("Vandaag doen we mooi de " + state.getBroeksoort() + " aan");
    System.out.println("Data: " + state.getData().toString());
    System.out.println();


  }


  @Override
  public Class<? extends IStep> getNextStepClass() {
    return ExitStep.class;
  }
}
