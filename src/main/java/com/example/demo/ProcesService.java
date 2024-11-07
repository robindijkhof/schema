package com.example.demo;

import com.example.demo.model.Data;
import com.example.demo.model.MockData;
import com.example.demo.schemas.ExitStep;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IProcesStep;
import com.example.demo.schemas.IStep;
import com.example.demo.schemas.schema1.Start;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcesService {
  private final StepService stepService;

  public void runAllData() {
    List<Data> mockDate = MockData.getMockData();
    for (Data d : mockDate) {

      // 'com.example.demo.steps.Thuiswerken' is not public in 'com.example.demo.steps'. Cannot be accessed from outside package
//      IStep stepError = stepService.getStepByName(Thuiswerken.NAME);

      IStep step = stepService.getStepByClass(Start.class);
      startFromStep(step, d);
    }
  }

  private void startFromStep(IStep startStep, Data data) {
    StepperState state = new StepperState(true, data);
    int i = 1;

    IStep runningStep = startStep;
    while (!runningStep.getClass().equals(ExitStep.class)) {
      if (runningStep instanceof IProcesStep step) {
        logStartStep(runningStep, i++);
        step.doStep(state);
        runningStep = stepService.getStepByClass(step.getNextStepClass());
      } else if (runningStep instanceof IDecisionStep step) {
        logStartStep(runningStep, i++);
        boolean result = step.doStep(state);
        runningStep = stepService.getStepByClass(result ? step.getPositiveStepClass() : step.getNegativeStepClass());
      }
    }
  }

  public void logStartStep(IStep step, int i) {
    System.out.println(i + " Starting step: " + step.getClass().getName());
  }
}
