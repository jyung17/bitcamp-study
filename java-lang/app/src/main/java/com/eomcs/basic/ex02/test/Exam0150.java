package com.eomcs.basic.ex02.test;

public class Exam0150 {

  static class Member {
    String name;
    int age;

    public Member(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("홍길동", 20);

    System.out.println(m1 == m2);
    System.out.printf("%x, %x\n", m1.hashCode(), m2.hashCode());
    System.out.printf("%s, %s\n", m1.toString(), m2.toString());
    System.out.printf("%b\n", m1.equals(m2));

    System.out.println("---------------------");

    String s1 = new String("Hello");
    String s2 = new String("Hello");

    System.out.println(s1 == s2);
    System.out.printf("%x, %x\n", s1.hashCode(), s2.hashCode());
    System.out.printf("%s, %s\n", s1.toString(), s2.toString());

    System.out.printf("%b\n", s1.equals(s2));
  }
}
