package com.eomcs.exception.ex3.test;

public class Exam0110 {
  static void m() {
    throw new RuntimeException("예외가 발생했습니다.!");
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    try {
      m();
    } catch (RuntimeException ex) {
      System.out.println(ex.getMessage());
    }

    System.out.println("시스템을 종료합니다.");
  }

}
