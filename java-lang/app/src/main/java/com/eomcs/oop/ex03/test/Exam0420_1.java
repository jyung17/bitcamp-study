package com.eomcs.oop.ex03.test;

public class Exam0420_1 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    Score(String name, int kor, int eng, int math) {
      this.name = name;
      this.kor = kor;
      this.eng = eng;
      this.math = math;
      this.compute();
    }

    public void compute() {
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum / 3f;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Score s1 = new Score("홍길동", 90, 80, 75);
    Score s2 = new Score("임꺽정", 80, 70, 65);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
        s1.average);
    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s2.name, s2.kor, s2.eng, s2.math, s2.sum,
        s1.average);

  }

}
