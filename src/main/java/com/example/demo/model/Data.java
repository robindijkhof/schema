package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Data {
  String name;
  int temperature;
  boolean workDay;
  boolean alreadyOff;
  boolean workingFromHome;

  String broeksoort;

  public Data(String name, int temperature, boolean workDay, boolean alreadyOff, boolean workingFromHome) {
    this.name = name;
    this.temperature = temperature;
    this.workDay = workDay;
    this.alreadyOff = alreadyOff;
    this.workingFromHome = workingFromHome;
  }

  @Override
  public String toString() {
    return "Data{" +
      "name='" + name + '\'' +
      ", temperature=" + temperature +
      ", workDay=" + workDay +
      ", alreadyOff=" + alreadyOff +
      ", workingFromHome=" + workingFromHome +
      ", broeksoort='" + broeksoort + '\'' +
      '}';
  }
}
