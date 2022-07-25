package com.eomcs.quiz.ex02.ctest;

// 출처: codefights.com
//
// 배열의 전체 길이를 L이라고 하자.
// 배열을 절반(L/2)으로 나눌 때, 앞쪽 부분과 뒤쪽 부분의 위치를 바꿔라.
// 예)
// [2, 4, 5, 6, 4, 3, 7, 8] => [4, 3, 7, 8, 2, 4, 5, 6]
//
// [시간 복잡도]
// - ?
//
public class Test02 {

  public static void main(String[] args) {
    int[] values = {2, 4, 5, 6, 4, 3, 7, 8};
    changeValuePosition(values);

    int[] results = {4, 3, 7, 8, 2, 4, 5, 6};

    for (int i = 0; i < results.length; i++) {
      if (values[i] != results[i]) {
        System.out.println(false);
        return;
      }
    }
    System.out.println(true);
  }

  static void changeValuePosition(int[] values) {
    // 이 메서드를 완성하시오!
    int valLength = values.length / 2;
    int j = valLength;
    for (int i = 0; i < values.length / 2; i++) {
      int temp = values[i];
      values[i] = values[j];
      values[j] = temp;
      j++;
    }

    // 배열의 절반을 맞바꿀 것이기 때문에
    // 배열의 절반만 반복한다.
    int halfIndex = values.length / 2;
    for (int i = 0; i < halfIndex; i++) {
      // 맞바꿀 항복의 인덱스를 구한다.
      int target = i + halfIndex;
      int temp = values[i];
      values[i] = values[target];
      values[target] = temp;
    }
  }
}
