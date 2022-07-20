package com.eomcs.oop.ex03.test;

import java.util.Scanner;

public class Exam0320_1 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    public void compute() {
      this.sum = this.kor + this.eng + this.math;
      this.average = this.sum / 3f;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner keyScan = new Scanner(System.in);

    System.out.print("성적 데이터를 입력하세요(예: 홍길동 100 100 100) >");
    Score s1 = new Score();
    s1.name = keyScan.next();
    s1.kor = keyScan.nextInt();
    s1.eng = keyScan.nextInt();
    s1.math = keyScan.nextInt();

    s1.compute();

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
        s1.average);

  }

}
