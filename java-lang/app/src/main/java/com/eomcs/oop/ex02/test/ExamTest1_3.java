package com.eomcs.oop.ex02.test;

// 0) 관련된 기능(메서드)을 묶어 분류하기 : 분류 전
// 1) 관련된 기능(메서드)을 묶어 분류하기 - 클래스로 분류
// 2) 관련된 기능(메서드)을 묶어 분류하기 - 클래스 메서드와 클래스 변수
// 3) 클래스 변수의 한계
// => 클래스 변수는 클래스가 로딩될 때 한 번 생성된다.
// => 클래스 변수는 오직 한 개만 존재하기 때문에 여러 개의 작업을 동시에 진행할 수 없다.
public class ExamTest1_3 {

  static class Calculator {
    static int result = 0;

    static void plus(int value) {
      result += value;
    }

    static void minus(int value) {
      // TODO Auto-generated method stub
      result -= value;
    }

    static void multiple(int value) {
      // TODO Auto-generated method stub
      result *= value;
    }

    static void divide(int value) {
      // TODO Auto-generated method stub
      result /= value;
    }

    static int abs(int a) {
      return a >= 0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Calculator.plus(2);
    Calculator.plus(3);
    Calculator.minus(1);
    Calculator.multiple(7);
    Calculator.divide(3);

    System.out.printf("result = %d\n", Calculator.result);
  }
}
