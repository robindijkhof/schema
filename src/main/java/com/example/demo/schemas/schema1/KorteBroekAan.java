package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IProcesStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class KorteBroekAan implements IProcesStep {
  public final static String NAME = KorteBroekAan.class.getName();


  @Override
  public void doStep(StepperState state) {
    state.setBroeksoort("Korte broek");
  }


  @Override
  public Class<? extends IStep> getNextStepClass() {
    return InformeerBroek.class;
  }
}
