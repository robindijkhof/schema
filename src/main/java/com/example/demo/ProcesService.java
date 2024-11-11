package com.example.demo;

import com.example.demo.model.Data;
import com.example.demo.model.MockData;
import com.example.demo.schemas.ExitStep;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IProcessStep;
import com.example.demo.schemas.IStep;
import com.example.demo.schemas.loops.IEndLoopStep;
import com.example.demo.schemas.loops.ILoopedDecisionStep;
import com.example.demo.schemas.loops.ILoopedProcessStep;
import com.example.demo.schemas.loops.IStartLoopStep;
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

    IStartLoopStep startLoopStep = null;
    boolean endLoopDetected = false;

    IStep runningStep = startStep;
    while (!runningStep.getClass().equals(ExitStep.class)) {
      if(runningStep instanceof IStartLoopStep step){
        startLoopStep = step;
      }
      endLoopDetected = runningStep instanceof IEndLoopStep step;
      logStartStep(runningStep, i++);

        switch (runningStep) {
            case IProcessStep step -> {
                step.doStep(state);
                runningStep = stepService.getStepByClass(step.getNextStepClass());
            }
            case IDecisionStep step -> {
                boolean result = step.doStep(state);
                runningStep = stepService.getStepByClass(result ? step.getPositiveStepClass() : step.getNegativeStepClass());
            }
            case ILoopedProcessStep step -> {
                step.doStep(state, startLoopStep.getIndex());
                runningStep = stepService.getStepByClass(step.getNextStepClass());
            }
            case ILoopedDecisionStep step -> {
                boolean result = step.doStep(state, startLoopStep.getIndex());
                runningStep = stepService.getStepByClass(result ? step.getPositiveStepClass() : step.getNegativeStepClass());
            }
            default -> {
              System.out.println("unknown step: " + runningStep.getClass());
            }
        }

      if(startLoopStep != null && endLoopDetected){
        startLoopStep.increaseIndex();
      }
    }
  }

  public void logStartStep(IStep step, int i) {
    System.out.println(i + " Starting step: " + step.getClass().getName());
  }
}
