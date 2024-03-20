package com.example.demo;

import com.example.demo.model.Data;
import com.example.demo.model.MockData;
import com.example.demo.schema1.IStep;
import com.example.demo.schema1.Start;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProcesService {
  private final StepService stepService;

  public void runAllData(){
    List<Data> mockDate = MockData.getMockData();
    for(Data d: mockDate){

      // 'com.example.demo.steps.Thuiswerken' is not public in 'com.example.demo.steps'. Cannot be accessed from outside package
//      IStep stepError = stepService.getStepByName(Thuiswerken.NAME);

      IStep step = stepService.getStepByName(Start.NAME);
      startFromStep(step, d);
    }
  }

  private void startFromStep(IStep step, Data data){
    StepperState state = new StepperState(false, data);
    int i = 1;

    IStep runningStep = step;
    while (runningStep != null){
      logStartStep(runningStep, i++);
      runningStep = runningStep.doStep(state, stepService);
    }
  }

  public void logStartStep(IStep step, int i){
    System.out.println(i + " Starting step: " + step.getStepName());
  }
}
