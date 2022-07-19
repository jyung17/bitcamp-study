package com.eomcs.oop.ex02.test.util;

public class Calculator {
  public int result = 0;

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    // TODO Auto-generated method stub
    this.result -= value;
  }

  public void multiple(int value) {
    // TODO Auto-generated method stub
    this.result *= value;
  }

  public void divide(int value) {
    // TODO Auto-generated method stub
    this.result /= value;
  }

  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }
}
