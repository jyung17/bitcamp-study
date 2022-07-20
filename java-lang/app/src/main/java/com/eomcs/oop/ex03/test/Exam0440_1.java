package com.eomcs.oop.ex03.test;

public class Exam0440_1 {

  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float average;

    Score() {
      this("이름없음");
      System.out.println("Score()");
    }

    Score(String name) {
      this(name, 0, 0, 0);
      System.out.println("Score(String)");
    }

    Score(String name, int kor, int eng, int math) {
      System.out.println("Score(String,int,int,int) 호출!");
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
    // 생성자가 여러 개 일 때 파라미터에 전달하는 값으로 구분한다.
    Score s1 = new Score();

    // 인스턴스 생성 후에 나중에 따로 생성자를 호출할 수 없다!
    //    s1.Score("홍길동", 100, 90, 77); // 컴파일 오류!
    System.out.println("--------------------------------");

    Score s2 = new Score("유관순");
    System.out.println("--------------------------------");

    Score s3 = new Score("홍길동", 100, 90, 77);
    System.out.println("--------------------------------");
    // Score s4 = new Score(true); // 논리 값을 받는 생성자는 없다!

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
        s1.average);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s2.name, s2.kor, s2.eng, s2.math, s2.sum,
        s2.average);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s3.name, s3.kor, s3.eng, s3.math, s3.sum,
        s3.average);
  }

}
