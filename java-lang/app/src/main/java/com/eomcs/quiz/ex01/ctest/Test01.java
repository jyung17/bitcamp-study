package com.eomcs.quiz.ex01.ctest;

// [문제]
// 파라미터로 주어진 정수 값을 2진수로 표현했을 때 1로 설정된 비트의 개수를 구하라!
// [훈련 목표]
// - 비교 연산자 및 비트 연산자 활용
// - 반복문 활용
// - 메서드 파라미터 및 리턴 값 다루기
//

public class Test01 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int c = countBits(0b0110011);
    System.out.println(c == 4);

    c = countBits(0b01010111_01100011);
    System.out.println(c == 9);
  }

  static int countBits(int value) {
    int r = 0;

    while (value != 0) {
      r += (value & 1);
      value >>>= 1; // value = (value >> 1);
    }
    return r;
  }

  // static int countBits(int value) {
  // int r = 0;
  // r = Integer.bitCount(value);
  // return r;
  // }
}
