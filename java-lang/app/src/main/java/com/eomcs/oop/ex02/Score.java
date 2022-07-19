package com.eomcs.oop.ex02;

public class Score {
  String name; // 변수 또는 필드
  int kor;
  int eng;
  int math;
  int sum;
  float aver;

  void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}
