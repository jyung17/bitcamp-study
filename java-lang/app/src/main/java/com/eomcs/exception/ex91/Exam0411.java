// 예외 상황 알리기 - 전통적인 방법
package com.eomcs.exception.ex91;

public class Exam0411 {

  static int sum;
  static float aver;

  static int computeScore(int kor, int eng, int math) throws Exception {

    if (kor < 0 || kor > 100 || eng < 0 || eng > 100 || math < 0 || math > 100) {
      throw new Exception("입력 점수가 옳지 않습니다.");
    }

    sum = kor + eng + math;
    aver = sum / 3f;
    return 0;
  }

  public static void main(String[] args) {

    try {
      computeScore(100, 90, 80);
      System.out.printf("합계=%d, 평균=%f\n", sum, aver);
    } catch (Throwable e) {
      System.out.println(e.getMessage());
    }

  }
}


