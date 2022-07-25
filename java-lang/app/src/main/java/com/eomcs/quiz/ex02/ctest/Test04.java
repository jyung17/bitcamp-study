package com.eomcs.quiz.ex02.ctest;

// 출처: codefights.com
// 한 줄에 버그가 있다. 고쳐라!
/*
 * 등비수열(geometric progression 또는 geometric sequence)인지 검사하라. 등비수열이면 true, 아니면 flase를 출력하라.
 * 
 * 등비수열이란? => 각 항이 그 앞 항과 일정한 비를 가지는 수열. => 이 일정한 비를 공비(common ratio)라고 한다.
 * 
 * Example isGeometricProgression([1, 4, 16]) = true <--- 공비는 4 isGeometricProgression([2, 4, 8, 17,
 * 34]) = false
 */

/*
 * 원문 A geometric progression is a sequence of numbers where each term after the first is found by
 * multiplying the previous one by a fixed, non-zero number.
 * 
 * Example
 * 
 * isGeometricProgression([1, 4, 16]) = true isGeometricProgression([2, 4, 8, 17, 34]) = false
 * [input] array.integer sequence
 * 
 * array of integers [output] boolean
 * 
 * true if sequence represents a geometric progression,
 */
//
// [시간 복잡도]
// - ?
//
public class Test04 {

  public static void main(String[] args) {
    System.out.println(isGeometricProgression(new int[] {1, 4, 16}) == true);
    System.out.println(isGeometricProgression(new int[] {2, 4, 8, 17, 34}) == false);
  }

  static boolean isGeometricProgression(int[] sequence) {
    // 이 메서드를 완성하시오!
    // 공비(r)를 구한다 => 공비 = 두번째항 / 첫번째항
    int r = sequence[1] / sequence[0];
    for (int i = 0; i < sequence.length - 1; i++) {
      if ((sequence[i] * r) == sequence[i + 1]) {
        continue; // sequence[i] * r == sequence[i + 1] 같다면 continue; 
      } else {
        return false;
        // sequence[i] * r) == sequence[i + 1]과 같지 않다면 등비수열이 성립할 수 없으므로 return false;
      }
    }
    return true;
  }
}
