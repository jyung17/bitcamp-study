package com.eomcs.oop.ex02.test;

// 0) 관련된 기능(메서드)을 묶어 분류하기 : 분류 전
// 1) 관련된 기능(메서드)을 묶어 분류하기 - 클래스로 분류
// 2) 관련된 기능(메서드)을 묶어 분류하기 - 클래스 메서드와 클래스 변수
// 3) 클래스 변수의 한계
// => 클래스 변수는 클래스가 로딩될 때 한 번 생성된다.
// => 클래스 변수는 오직 한 개만 존재하기 때문에 여러 개의 작업을 동시에 진행할 수 없다.
// 4) 관련된 기능(메서드)을 묶어 분류하기 - 인스턴스 변수
// 5) 인스턴스 변수와 인스턴스 메서드
// 6) 패키지 멤버 클래스
public class ExamTest1_6 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    Calculator c1 = new Calculator();
    Calculator c2 = new Calculator();

    c1.plus(2);
    c1.plus(3);
    c1.minus(1);
    c1.multiple(7);
    c1.divide(3);

    c2.plus(3);
    c2.multiple(2);
    c2.plus(7);
    c2.divide(4);
    c2.minus(5);

    System.out.printf("result = %d\n", c1.result);
    System.out.printf("result = %d\n", c2.result);
  }
}
