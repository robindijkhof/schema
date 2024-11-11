package com.example.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Data {
  String day;
  int temperature;
  List<Member> members = new ArrayList<>();

  public Data(String day, int temperature, List<Member> members) {
    this.day = day;
    this.temperature = temperature;
    this.members = members;
  }


  @Override
  public String toString() {
    return "Data{" +
      "day='" + day + '\'' +
      ", temperature=" + temperature +
      ", members=" + members +
      '}';
  }
}
