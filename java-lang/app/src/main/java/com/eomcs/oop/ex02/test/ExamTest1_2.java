package com.eomcs.oop.ex02.test;

// 0) 관련된 기능(메서드)을 묶어 분류하기 : 분류 전
// 1) 관련된 기능(메서드)을 묶어 분류하기 - 클래스로 분류
public class ExamTest1_2 {

  static class Calculator {
    static int plus(int a, int b) {
      return a + b;
    }

    static int minus(int a, int b) {
      // TODO Auto-generated method stub
      return a - b;
    }

    static int multiple(int a, int b) {
      // TODO Auto-generated method stub
      return a * b;
    }

    static int divide(int a, int b) {
      // TODO Auto-generated method stub
      return a / b;
    }

    static int abs(int a) {
      return a >= 0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int result = 0;
    result = Calculator.plus(2, 3);
    result = Calculator.minus(result, 1);
    result = Calculator.multiple(result, 7);
    result = Calculator.divide(result, 3);

    System.out.printf("result = %d\n", result);
  }
}
