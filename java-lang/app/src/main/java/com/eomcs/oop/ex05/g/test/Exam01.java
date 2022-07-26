package com.eomcs.oop.ex05.g.test;

public class Exam01 {
  public static void main(String[] args) {
    B b = new B();
    System.out.println(b.v1);
    System.out.println(b.v2);
    System.out.println(b.v4);

    System.out.println("--------------");

    C c = new C();
    System.out.println(c.v1);
    System.out.println(c.v3);
    System.out.println(c.v4);
    System.out.println("--------------");

    System.out.println(b.v4);
  }
}
