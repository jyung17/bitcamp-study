package com.eomcs.oop.ex02;

// # 사용자 정의 데이터 타입 + 클래스 메서드
// 0) 낱개 변수 사용
// 1) 성적 데이터를 저장할 사용자 정의 데이터 타입을 만든다.
// 2) 리팩토링: 메서드 추출(extract method), static nested class
// 3) 리팩토링: 메서드 추출(extract method) = 한 개의 메서드는 한 개의 기능을 수행해야 한다.
// 4) GRASP(General Responsibility Assignment Software Patterns) 패턴 : Information Expert
// => Information Expert : 데이터를 다룰 때는 그 데이터를 갖고 있는 객체에게 묻는다.
// 리팩토링: 메서드 이동(Move Method)
// => 메서드를 관련된 클래스로 이동시킨다 => 코드의 이해가 쉽
// 5) 인스턴스 메서드 : 인스턴스 주소를 받는 더 쉬운 문법
public class Exam0150 {

  // 여러 메서드에서 공유하려면 클래스 맴버로 만들어야 한다.
  // - 특히 스태틱 멤버끼리 공유하려면 같은 스태틱 멤버로 만들어야 한다.
  static class Score {
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
    s1.compute();
    printScore(s1); // s1의 인스턴스를 printScore에 넘김

    Score s2 = new Score();
    s2.name = "임꺽정";
    s2.kor = 90;
    s2.eng = 80;
    s2.math = 75;
    s2.compute();
    printScore(s2);

    Score s3 = new Score();
    s3.name = "유관순";
    s3.kor = 80;
    s3.eng = 70;
    s3.math = 65;
    s3.compute();
    printScore(s3);
  }

  // static void printScore(Score s) -> Score s인스턴드 값을 받음
  static void printScore(Score s) {
    System.out.printf("%s: %d, %d, %d, %d, %.1f\n", s.name, s.kor, s.eng, s.math, s.sum, s.aver);
  }
}

// 클래스 문법의 용도?
// 1) 사용자 정의 데이터 타입 만들 때
// 즉 새로운 구조의 메모리를 설계할 때 사용한다.
// 2) 메서드를 묶을 때
// 서로 관련된 기능을 관리하기 쉽게 묶고 싶을 때 사용한다.


