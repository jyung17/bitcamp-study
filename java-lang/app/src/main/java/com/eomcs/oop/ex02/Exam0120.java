package com.eomcs.oop.ex02;

// # 사용자 정의 데이터 타입 + 클래스 메서드
// 0) 낱개 변수 사용
// 1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
// 2) 리팩토링: 메서드 추출(extract method), static nested class
public class Exam0120 {

  // 여러 메서드에서 공유하려면 클래스 맴버로 만들어야 한다.
  // - 특히 스태틱 멤버끼리 공유하려면 같은 스태틱 멤버로 만들어야 한다.
  static class Score {
    String name; // 변수 또는 필드
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }

  public static void main(String[] args) {
    // 사용자 정의 데이터 타입을 사용하는 방법
    // - new 명령을 사용하여 설계도에 기술된 대로 메모리를 준비한다.
    // - 메모리는 Heap 영역에 생성된다.
    // - 메모리 주소를 레퍼런스(주소 변수)에 저장한다.
    Score s1 = new Score();

    // - 클래스로 만든 메모리는 레퍼런스를 통해 접근한다.
    s1.name = "홍길동";
    s1.kor = 100;
    s1.eng = 90;
    s1.math = 85;
    printScore(s1); // s1의 인스턴스를 printScore에 넘김
    // s1.sum = s1.kor + s1.eng + s1.math;
    // s1.aver = (float) s1.sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s1.name, s1.kor, s1.eng, s1.math, s1.sum,
        s1.aver);

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    s2.sum = s2.kor + s2.eng + s2.math;
    s2.aver = (float) s2.sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s2.name, s2.kor, s2.eng, s2.math, s2.sum,
        s2.aver);

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    s3.sum = s3.kor + s3.eng + s3.math;
    s3.aver = (float) s3.sum / 3;

    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s3.name, s3.kor, s3.eng, s3.math, s3.sum,
        s3.aver);
  }

  // static void printScore(Score s) -> Score s인스턴드 값을 받음
  static void printScore(Score s) {
    s.sum = s.kor + s.eng + s.math;
    s.aver = (float) s.sum / 3;
  }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


