package com.example.demo.schemas;

public interface IConditionalStep extends IStep{

  String getPositiveStepName();
  String getNegativeStepName();
}
