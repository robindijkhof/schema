package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class MockData {

  private MockData(){
    //Optie1:
    //Start loop stap
    // End loop stap extends processtap;
    // Obv conditie gaat de endloop naar start of gewoon verder.
    // De index zal in de state moeten komen te staan. Andere stappen kunnen heir in principe bij


    // Optie 2:
    //Indexed step + indexedProcessStep + indexedDecisionStep.
    //Process service is verantwoordelijk
    //OOk een end en startStep nodig?


    //Laten we beginnen met een start en stopstap
  }

  public static List<Data> getMockData(){
    return List.of(
      new Data("maandag", 21, List.of(new Member("bob", true, false, false), new Member("alice", true, false, true))),
      new Data("dinsdag", 20, List.of()),
      new Data("woensdag", 45, List.of()),
      new Data("donderdag", 3, List.of()),
      new Data("vrijdag", 21, List.of()),
      new Data("zaterdag", 19, List.of())
    );
  }
}
