// 1) 스레드 사용 전
// 2) 스레드 사용 후 : Runnable 구현체를 패키지 맴버로 만들어 Thread로 실행한다.
// 3) 패키지 멤버를 스태틱 중첩 클래스로 만든다.
// 4)
package com.eomcs.concurrent;

public class Exam0260 {
  public static void main(String[] args) {
    int count = 1000;

    Runnable r = new Runnable() {

      @Override
      public void run() {
        for (int i = 0; i < count; i++) {
          System.out.println("==> " + i);
        }
      }
    };

    new Thread(r).start();

    for (int i = 0; i < 1000; i++) {
      System.out.println(">>> " + i);
    }
  }
}
