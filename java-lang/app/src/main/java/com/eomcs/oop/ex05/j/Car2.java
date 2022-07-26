package com.eomcs.oop.ex05.j;

public class Car2 {

  public String model;
  public String maker;
  public int capacity;

  public Car2() {

  }

  public Car2(String model, String maker, int capacity) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
  }

  public void run() {
    System.out.println("달린다!");
  }
}


