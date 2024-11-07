package com.example.demo;
import com.example.demo.schemas.IDecisionStep;
import com.example.demo.schemas.IProcessStep;
import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VisualisationService {

  private List<IStep> steps;
  private StepService stepService;

  public String getSourceImage() {
    StringBuilder diagram = new StringBuilder("flowchart\n");

    for(IStep step : steps){
      switch (step) {
        case IProcessStep processStep -> {
          IStep nextStep = stepService.getStepByClass(processStep.getNextStepClass());

          diagram.append(createNode(step)).append(" --> ").append(createNode(nextStep)).append("\n");
        }
        case IDecisionStep decisionStep -> {
          IStep positiveStep = stepService.getStepByClass(decisionStep.getPositiveStepClass());
          IStep negativeStep = stepService.getStepByClass(decisionStep.getNegativeStepClass());

          diagram.append(createNode(step)).append(" -->|true| ").append(createNode(positiveStep)).append("\n");
          diagram.append(createNode(step)).append(" -->|false| ").append(createNode(negativeStep)).append("\n");
        }
        default -> diagram.append(createNode(step)).append(" --> ???\n");
      }
    }

    return diagram.toString();
  }



  static String createNode(IStep step){

    String stepOmschrijving = step.getClass().getSimpleName();


    if (step instanceof IDecisionStep){
      return step.getClass().getName() + "{{\"" + stepOmschrijving + "\"}}";
    }

    return step.getClass().getName() + "[\"" + stepOmschrijving + "\"]";
  }

}
