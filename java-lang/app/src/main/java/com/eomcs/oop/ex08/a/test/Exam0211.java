package com.eomcs.oop.ex08.a.test;

class Score2 {
  String name;
  int kor;
  int eng;
  int math;

  private int sum;
  private float aver;

  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}


public class Exam0211 {
  public static void main(String[] args) {

    Score2 s1 = new Score2();

    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 80;

    //s1.sum = s1.kor + s1.eng + s1.math; // 컴파일 오류! (The field Score2.sum is not visible)
    //s1.aver = s1.sum / 4f; // 컴파일 오류!

    s1.compute();
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.getSum(),
        s1.getAver());
  }
}
