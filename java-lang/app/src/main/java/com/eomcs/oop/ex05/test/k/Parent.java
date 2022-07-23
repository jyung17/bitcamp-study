package com.eomcs.oop.ex05.test.k;

public class Parent {

  int result = 0;

  public int plus(int value) {
    System.out.println("Parent plus 호출");
    result += value;
    System.out.println(result);
    return result;
  }

  public int minus(int value) {
    System.out.println("Parent minus 호출");
    result += value;
    System.out.println(result);
    return result;
  }
}
