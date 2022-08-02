package com.eomcs.quiz.ex02.ctest;

// 출처: codefights.com
//
// 주어진 양의 정수 배열에서 가장 큰 짝수를 찾아라!
// 최소 한 개의 짝수가 존재한다.
// 예)
// maximalEven([4, 3, 6, 8, 2, 4]) = 8
//
/*
 * Pick-out the largest even number from an array of integers
 * 
 * Example
 * 
 * maximalEven([4, 3, 6, 8, 2, 4]) = 8
 * 
 * [input] array.integer inputArray an array of positive integers, it's guaranteed that inputArray
 * contains at least one even integer
 * 
 * [output] integer maximal even element of inputArray
 */
//
// [시간 복잡도]
// - ?
//
public class Test07 {

  public static void main(String[] args) {
    System.out.println(maximalEven(new int[] {4, 3, 6, 8, 2, 4}) == 8);
  }

  static int maximalEven(int[] inputArray) {
    int answer = inputArray[0];
    int max = 0;
    // 이 메서드를 완성하시오!
    for (int i = 0; i < inputArray.length; i++) {
      if ((inputArray[i] > max) && (inputArray[i] % 2 == 0)) {
        answer = max = inputArray[i];
      }
    }
    return answer;
  }
}


