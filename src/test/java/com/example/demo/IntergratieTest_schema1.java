package com.example.demo;

import com.example.demo.model.Data;
import com.example.demo.schema1.IStep;
import com.example.demo.schema1.Start;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class IntergratieTest_schema1 {
  @Autowired
  List<IStep> steps;

  @Test
  public void test1(){
    List<IStep> schemasteps = steps.stream().filter(x -> x.getClass().getPackage().getName().equals("com.example.demo.schema1")).toList();
    StepService service = new StepService(schemasteps);


    Data data = new Data("zaterdag", 19, false, false, false);
    StepperState state = new StepperState(false, data);

    assertNull(data.getBroeksoort());

    IStep step = new Start();
    while (step != null){
      step = step.doStep(state, service);
    }

    assertEquals("Lange broek", data.getBroeksoort());
  }
}
