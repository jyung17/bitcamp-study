package com.eomcs.quiz.ex01.ctest;

// copyright by codefights.com
//
// 양의 정수가 주어질 때 가장 큰 숫자를 찾아라!
// 예)
// maxDigit(2542) ==> 5
//
//
/*
 * Find the largest digit of the given number.
 * 
 * [input] integer n non-negative integer
 * 
 * [output] integer largest digit of n
 */
//
// [시간 복잡도]
// - ?
//
public class Test20 {

  public static void main(String[] args) {
    System.out.println(maxDigit(736) == 7);
    System.out.println(maxDigit(2542) == 5);
  }

  static int maxDigit(int n) {
    // 이 메서드를 완성하시오!
    //    int result = 0;
    //    while (n > 0) {
    //      result = Math.max(result, n % 10);
    //      n /= 10;
    //    }
    //    return result;

    int result = 0;
    while (n > 0) {
      if ((n % 10) > result) {
        result = n % 10;
      }
      n /= 10;
    }
    return result;
  }
}
