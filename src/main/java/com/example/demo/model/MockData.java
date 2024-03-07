package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class MockData {

  private MockData(){

  }

  public static List<Data> getMockData(){
    return List.of(
      new Data("maandag", 21, true, false, true),
      new Data("dinsdag", 20, true, false, true),
      new Data("woensdag", 45, true, false, false),
      new Data("donderdag", 3, true, false, false),
      new Data("vrijdag", 21, false, false, false),
      new Data("zaterdag", 19, false, false, false)
    );
  }
}
