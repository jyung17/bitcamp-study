package com.eomcs.oop.ex02.domain;

public class Score {

  // 다른 패키지에서 이 설계도에 따라 만든 변수에 접근할 수 있도록
  // 접근 범위를 넓힌다.
  public String name; // 변수 또는 필드
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}
