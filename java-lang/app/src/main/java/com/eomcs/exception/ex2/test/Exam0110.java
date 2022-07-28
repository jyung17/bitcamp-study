package com.eomcs.exception.ex2.test;

public class Exam0110 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String op = "#";
    int a = 100;
    int b = 200;

    try {
      int result = Calculator3.compute(op, a, b);
      System.out.println(result);
    } catch (RuntimeException ex) {
      System.out.println(ex.getMessage());
    }

  }
}
