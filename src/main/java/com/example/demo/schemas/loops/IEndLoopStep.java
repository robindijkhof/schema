package com.example.demo.schemas.loops;

import com.example.demo.schemas.IStep;

public interface IEndLoopStep extends ILoopedProcessStep {


  @Override
  Class<? extends IStep> getNextStepClass();


}
