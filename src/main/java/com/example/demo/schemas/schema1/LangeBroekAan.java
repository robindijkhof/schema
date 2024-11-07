package com.example.demo.schemas.schema1;

import com.example.demo.StepService;
import com.example.demo.StepperState;
import com.example.demo.schemas.IProcesStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
class LangeBroekAan implements IProcesStep {
  public final static String NAME = LangeBroekAan.class.getName();


  @Override
  public void doStep(StepperState state) {
    state.setBroeksoort("Lange broek");
  }

  @Override
  public Class<? extends IStep> getNextStepClass() {
    return InformeerBroek.class;
  }
}
