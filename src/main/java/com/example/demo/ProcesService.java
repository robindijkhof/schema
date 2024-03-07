package com.example.demo;

import com.example.demo.model.Data;
import com.example.demo.model.MockData;
import com.example.demo.steps.IStep;
import com.example.demo.steps.Start;
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
      IStep step = stepService.getStepByName(Start.NAME);
      startFromStep(step, d);
    }
  }

  private void startFromStep(IStep step, Data data){
    StepperState state = new StepperState(false, data);

    IStep runningStep = step;
    while (runningStep != null){
      runningStep = runningStep.doStep(state, stepService);
    }
  }
}
