package com.eomcs.oop.ex08.a.test;

class Score4 {
  private String name;
  private int kor;
  private int eng;
  private int math;

  private int sum;
  private float aver;

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setKor(int kor) {
    if (kor >= 0 && kor <= 100) {
      this.kor = kor;
      this.compute();
    }
  }

  public int getKor() {
    return this.kor;
  }

  public int getEng() {
    return this.eng;
  }

  public void setEng(int eng) {
    if (eng >= 0 && eng <= 100) { // 유효한 점수인 경우에만 저장한다.
      this.eng = eng;
      this.compute(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
    }
  }

  public int getMath() {
    return this.math;
  }

  public void setMath(int math) {
    if (math >= 0 && math <= 100) {// 유효한 점수인 경우에만 저장한다.
      this.math = math;
      this.compute(); // 유효한 값이라면 다시 합계와 평균을 계산한다.
    }
  }

  public int getSum() {
    return this.sum;
  }

  public float getAver() {
    return this.aver;
  }

  private void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }

}


public class Exam0410 {
  public static void main(String[] args) {
    Score4 s1 = new Score4();
    s1.setName("홍길동");
    s1.setKor(100);
    s1.setEng(90);
    s1.setMath(80);

    System.out.printf("%s, %d, %d, %d, %d, %.1f\n", s1.getName(), s1.getKor(), s1.getEng(),
        s1.getMath(), s1.getSum(), s1.getAver());
  }
}
