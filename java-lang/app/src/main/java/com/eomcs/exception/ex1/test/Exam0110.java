package com.eomcs.exception.ex1.test;

public class Exam0110 {
  public static void main(String[] args) {
    int result = Calculator2.compute("#", 6, 7);

    if (result == -1212121212) {
      System.out.println("유효하지 않은 연산자입니다.!!");
    } else {
      System.out.println(result);
    }

    result = Calculator2.compute("-", 6, 7);
    if (result == -1212121212) {
      System.out.println("유효하지 않은 연산자입니다.!!");
    } else {
      System.out.println(result);
    }


    int result2 = Calculator2.compute("+", -2078654356, 866533144);
    if (result2 == -1212121212) {
      System.out.println("유효하지 않은 연산자입니다!");
    } else {
      System.out.println(result2);
    }
  }
}
