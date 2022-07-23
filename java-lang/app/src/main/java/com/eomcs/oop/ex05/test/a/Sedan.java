package com.eomcs.oop.ex05.test.a;

public class Sedan extends Car {

  public boolean sunroof;
  public boolean auto;

  public Sedan(String model, String maker, int capacity, boolean sunroof, boolean auto) {
    this.model = model;
    this.maker = maker;
    this.capacity = capacity;
    this.sunroof = sunroof;
    this.auto = auto;
  }
}
