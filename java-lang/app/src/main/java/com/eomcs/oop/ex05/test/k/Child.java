package com.eomcs.oop.ex05.test.k;

public class Child extends Parent {

  @Override
  public int plus(int value) {
    System.out.println("Child plus 호출");
    value += value;
    System.out.println(value);

    return super.minus(super.plus(value));
  }

  public static void main(String[] args) {

    Child ch = new Child();

    System.out.println(ch.plus(1));
  }

}
