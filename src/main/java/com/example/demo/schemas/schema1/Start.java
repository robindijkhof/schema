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
  public void doStep(StepperState state) {
    if (state.isLoggingEnabled()) {
      System.out.println("Start");
    }
  }



  @Override
  public Class<? extends IStep> getNextStepClass() {
    return WarmerDan20.class;
  }
}
