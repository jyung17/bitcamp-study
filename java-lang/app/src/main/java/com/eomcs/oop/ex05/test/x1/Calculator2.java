package com.eomcs.oop.ex05.test.x1;

public class Calculator2 {
  public int result;

  Calculator origin;

  public Calculator2(Calculator origin) {
    this.origin = origin;
  }

  public void plus(int value) {
    origin.plus(value);
  }

  public void minus(int value) {
    origin.minus(value);
  }

  public void multiple(int value) {
    origin.result *= value;
  }

  public int getResult() {
    return origin.result;
  }
}
