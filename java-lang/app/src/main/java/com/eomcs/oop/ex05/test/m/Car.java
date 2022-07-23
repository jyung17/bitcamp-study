package com.eomcs.oop.ex05.test.m;

public abstract class Car {
  public Car() {
    super();
  }

  public void start() {
    System.out.println("시동 건다!!!");
  }

  public void shutdonw() {
    System.out.println("시동 끈다!!!");
  }

  public void run() {
    System.out.println("달린다!");
  }
}
