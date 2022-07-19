package com.eomcs.oop.ex02.domain;

public class Score2 {

  // 다른 패키지에서 이 설계도에 따라 만든 변수에 접근할 수 있도록
  // 접근 범위를 넓힌다.
  public String name; // 변수 또는 필드
  public int kor;
  public int eng;
  public int math;
  public int sum;
  public float aver;

  // new 연산자를 이용하여 인스턴스를 만들 때 자동으로 호출되는 특별한 문법의 메서드
  // => 생성자(constructor)
  // - 메서드명은 클래스 이름과 같아야 한다.
  // - 리턴 타입은 없다.

  public Score2(String name, int kor, int eng, int math) {
    this.name = name;
    this.kor = kor;
    this.eng = eng;
    this.math = math;

    this.compute();
  }

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = (float) this.sum / 3;
  }
}
