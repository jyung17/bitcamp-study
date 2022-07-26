package com.eomcs.oop.ex07.b.test;

public class Exam01 {

  static int[] createRandomNumbers(final int size) {
    int[] arr = new int[size];
    for (int i = 0; i < size; i++) {
      arr[i] = i;
    }

    int count = size >> 1;
    for (int i = 0; i < count; i++) {
      int index1 = (int) (Math.random() * size);
      int index2 = (int) (Math.random() * size);
      int temp = arr[index1];
      arr[index1] = arr[index2];
      arr[index2] = temp;
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] values = createRandomNumbers(100000);

    BubbleSort s1 = new BubbleSort();

    display(s1, values);
  }

  static void display(BubbleSort sorter, int[] values) {
    long start = System.currentTimeMillis();
    sorter.run(values);
    long end = System.currentTimeMillis();
    System.out.printf("걸린시간: %d\n", end - start);
  }

}
