package com.eomcs.oop.ex07.a;

abstract class Car {
  int a;

  abstract public void m1();
}


class Sedan extends Car {
  int b;

  @Override
  public void m1() {
    System.out.println("Sedan m1()호출");
  }
}


public class Test1_ {
  public static void main(String[] args) {
    Sedan sedan = new Sedan();
    Car car = sedan;

    car.m1();
  }
}
