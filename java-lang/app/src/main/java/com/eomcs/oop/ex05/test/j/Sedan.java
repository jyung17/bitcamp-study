package com.eomcs.oop.ex05.test.j;

public class Sedan extends Car {
  @Override
  public void run() {
    System.out.println("쌩썡 달린다.");
  }

  public void doSunroof(boolean open) {
    if (open) {
      System.out.println("썬루프를 연다.");
    } else {
      System.out.println("썬루프를 닫는다.");
    }
  }
}
