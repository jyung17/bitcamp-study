// 1) 스레드 사용 전
package com.eomcs.concurrent;

public class Exam0110x {

  public static void main(String[] args) {
    int count = 1000;

    new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < count; i++) {
          System.out.println("==> " + i);
        }
      }
    }.start();

    for (int i = 0; i < 1000; i++) {
      System.out.println(">>> " + i);
    }
  }
}


