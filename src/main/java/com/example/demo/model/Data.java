package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Data {
  String day;
  int temperature;
  boolean workDay;
  boolean alreadyOff;
  boolean workingFromHome;

  public Data(String day, int temperature, boolean workDay, boolean alreadyOff, boolean workingFromHome) {
    this.day = day;
    this.temperature = temperature;
    this.workDay = workDay;
    this.alreadyOff = alreadyOff;
    this.workingFromHome = workingFromHome;
  }

  @Override
  public String toString() {
    return "Data{" +
      "name='" + day + '\'' +
      ", temperature=" + temperature +
      ", workDay=" + workDay +
      ", alreadyOff=" + alreadyOff +
      ", workingFromHome=" + workingFromHome +
      '}';
  }
}
