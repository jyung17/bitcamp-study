// 1) 스레드 사용 전
package com.eomcs.concurrent;

public class Exam0210x {

  public static void main(String[] args) {

    int count = 1000;

    for (int i = 0; i < 1000; i++) {
      System.out.println("==> " + i);
    }

    for (int i = 0; i < 1000; i++) {
      System.out.println(">>> " + i);
    }
  }
}
