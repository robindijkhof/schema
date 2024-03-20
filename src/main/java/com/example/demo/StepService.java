package com.example.demo;

import com.example.demo.schema1.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StepService {
  private final List<IStep> steps;

  public IStep getStepByName(String name){
    return steps.stream().filter(x -> x.getStepName().equals(name)).findFirst().orElseThrow(() -> new RuntimeException("Stap niet gevonden"));
  }
}
