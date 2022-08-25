package com.eomcs.oop.ex12;

public class Exam0110x {

  interface Player {
    void play(String name);
  }

  public static void main(String[] args) {
    Player p = new Player() {
      @Override
      public void play(String name) {
        System.out.println(name + " 님 환영합니다.");
      }
    };
    p.play("임꺽정");

    Player p1 = (String name) -> System.out.println(name + " 님 환영합니다.");
    p1.play("홍길동");

    Player p2 = (name) -> System.out.println(name + " 님 환영합니다");
    p2.play("임꺽정");

    Player p3 = name -> System.out.println(name + " 님 환영합니다.");
    p3.play("홍길동");

    System.out.println(p2 == p3);
  }
}
