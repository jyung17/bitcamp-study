package com.eomcs.oop.ex02.test;

class Calculator {
  int result = 0;

  void plus(int value) {
    this.result += value;
  }

  void minus(int value) {
    // TODO Auto-generated method stub
    this.result -= value;
  }

  void multiple(int value) {
    // TODO Auto-generated method stub
    this.result *= value;
  }

  void divide(int value) {
    // TODO Auto-generated method stub
    this.result /= value;
  }

  static int abs(int a) {
    return a >= 0 ? a : a * -1;
  }
}
