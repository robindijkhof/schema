package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Member {
  String name;
  boolean workDay;
  boolean alreadyOff;
  boolean workingFromHome;

  @Override
  public String toString() {
    return "Member{" +
      "name='" + name + '\'' +
      ", workDay=" + workDay +
      ", alreadyOff=" + alreadyOff +
      ", workingFromHome=" + workingFromHome +
      '}';
  }
}
