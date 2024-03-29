package com.example.demo.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
class InformeerBroek implements IStep {
  public final static String NAME = InformeerBroek.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if(state.isLoggingEnabled()){
      System.out.println("Log broek soort aan");
    }
    System.out.println("Vandaag doen we mooi de " + state.getData().getBroeksoort() + " aan");
    System.out.println("Data: " + state.getData().toString());
    System.out.println();

    return null;

  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
