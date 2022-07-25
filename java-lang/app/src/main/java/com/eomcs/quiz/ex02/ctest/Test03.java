package com.eomcs.quiz.ex02.ctest;

// 출처: codefights.com
//
// 숫자 배열이 있다.
// 나누어 0이 떨어지는 수가 몇 쌍이 있는지 구하라!
//
// [시간 복잡도]
// - ?
//
public class Test03 {

  public static void main(String[] args) {
    int[] values = {2, 4, 8};
    System.out.println(divisorsPairs(values) == 3);
    System.out.println(values[0] & values[1]);

  }

  public static int divisorsPairs(int[] sequence) {
    int result = 0;
    for (int i = 0; i < sequence.length; i++) {
      if (((sequence[i] & (sequence[i] - 1))) == 0) {
        result++;
      }
    }
    return result;
  }
}

