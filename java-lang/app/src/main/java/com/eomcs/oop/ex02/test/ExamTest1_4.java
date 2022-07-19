package com.eomcs.oop.ex02.test;

// 0) 관련된 기능(메서드)을 묶어 분류하기 : 분류 전
// 1) 관련된 기능(메서드)을 묶어 분류하기 - 클래스로 분류
// 2) 관련된 기능(메서드)을 묶어 분류하기 - 클래스 메서드와 클래스 변수
// 3) 클래스 변수의 한계
// => 클래스 변수는 클래스가 로딩될 때 한 번 생성된다.
// => 클래스 변수는 오직 한 개만 존재하기 때문에 여러 개의 작업을 동시에 진행할 수 없다.
// 4) 관련된 기능(메서드)을 묶어 분류하기 - 인스턴스 변수

public class ExamTest1_4 {

  static class Calculator {
    int result = 0;

    static void plus(Calculator obj, int value) {
      obj.result += value;
    }

    static void minus(Calculator obj, int value) {
      // TODO Auto-generated method stub
      obj.result -= value;
    }

    static void multiple(Calculator obj, int value) {
      // TODO Auto-generated method stub
      obj.result *= value;
    }

    static void divide(Calculator obj, int value) {
      // TODO Auto-generated method stub
      obj.result /= value;
    }

    static int abs(int a) {
      return a >= 0 ? a : a * -1;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    Calculator.plus(c1, 2);
    Calculator.plus(c1, 3);
    Calculator.minus(c1, 1);
    Calculator.multiple(c1, 7);
    Calculator.divide(c1, 3);

    Calculator.plus(c2, 3);
    Calculator.multiple(c2, 2);
    Calculator.plus(c2, 7);
    Calculator.divide(c2, 4);
    Calculator.minus(c2, 5);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }
}
