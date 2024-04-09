package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IProcesStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class Start implements IProcesStep {
  public final static String NAME = Start.class.getName();


  @Override
  public IStep doStep(StepperState state, StepService stepService) {
    if (state.isLoggingEnabled()) {
      System.out.println("Start");
    }

    return stepService.getStepByName(getNextStepName());
  }

  @Override
  public String getStepName() {
    return NAME;
  }

  @Override
  public String getNextStepName() {
    return WarmerDan20.NAME;
  }
}
