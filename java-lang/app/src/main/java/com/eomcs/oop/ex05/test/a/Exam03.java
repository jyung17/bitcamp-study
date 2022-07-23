package com.eomcs.oop.ex05.test.a;

public class Exam03 {
  public static void main(String[] args) {
    Score2 s = new Score2();
    s.name = "홍길동";
    s.kor = 100;
    s.eng = 100;
    s.math = 100;
    s.music = 100;
    s.art = 100;
    s.compute();
    System.out.printf("%s: %d(%.1f)]\n", s.name, s.sum, s.aver);
  }
}
