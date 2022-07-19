package com.eomcs.oop.ex03.test;

public class Exam0160_2 {
  static class Member {

    String id;
    String password;
    int type; // 0: 손님, 1: 회원, 2: 관리자

    public Member(String id, String password, int type) {
      this.id = id;
      this.password = password;
      this.type = type;
    }
  }

  public static void main(String[] args) {

    final int GUEST = 0;
    final int MEMBER = 1;
    final int MANAGER = 2;

    // TODO Auto-generated method stub
    Member m1 = new Member("aaa", "1111", GUEST);
    Member m2 = new Member("bbb", "1111", MEMBER);
    Member m3 = new Member("ccc", "1111", MANAGER);

    System.out.printf("%s, %s, %d\n", m1.id, m1.password, m1.type);
    System.out.printf("%s, %s, %d\n", m2.id, m2.password, m2.type);
    System.out.printf("%s, %s, %d\n", m3.id, m3.password, m3.type);
  }
}
