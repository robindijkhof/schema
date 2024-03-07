package com.example.demo.steps;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Start implements IStep {
  public final static String NAME = Start.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if (state.isLoggingEnabled()) {
      System.out.println("Start");
    }

    return stepService.getStepByName(WarmerDan20.NAME);
  }

  @Override
  public String getStepName() {
    return NAME;
  }
}
