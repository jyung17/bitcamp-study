package com.eomcs.quiz;

// [문제]
// 두 위치의 비트 값을 맞교환 하라!
// 예) 값: 0b00101100_01110001
// 2번째(2^2 자리) 비트와 13번째(2^13 자리) 비트
// 결과: 0b00001100_01110101
//
// [훈련 목표]
// - 관계 연산자 및 비트 연산자, 비트 이동 연산자 활용
// - 반복문 활용
// - 메서드 파라미터 및 리턴 값 다루기
//
public class Test03 {

  public static void main(String[] args) {
    int r = swapBits(0b00101100_01110001, 2, 13);
    System.out.println(r == 0b00001100_01110101); // true

    r = swapBits(0b01010111_01100011, 6, 10);
    System.out.println(r == 0b01010111_01100011); // true
  }

  static int swapBits(int value, int i, int j) {
    int n1 = 1;
    int n2 = 1;
    for (int n = 1; n <= 2; n++) {
      n1 *= 2;
    }
    for (int m = 1; m <= 13; m++) {
      n2 *= 2;
    }
    value = ((value ^ n1) & (value ^ n2));
    return 0;
  }
}
