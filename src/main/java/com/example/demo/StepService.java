package com.example.demo;

import com.example.demo.schemas.IStep;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StepService {
  private final List<IStep> steps;

  public IStep getStepByClass(Class<? extends IStep> clazz){
    return steps.stream().filter(x -> x.getClass() == clazz).findFirst().orElseThrow(() -> new RuntimeException("Stap niet gevonden: " + clazz.getName()));
  }
}
