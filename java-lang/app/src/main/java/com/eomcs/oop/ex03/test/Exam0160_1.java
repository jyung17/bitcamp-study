package com.eomcs.oop.ex03.test;

public class Exam0160_1 {
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
    // TODO Auto-generated method stub
    Member m1 = new Member("aaa", "1111", 0);
    Member m2 = new Member("bbb", "1111", 2);
    Member m3 = new Member("ccc", "1111", 1);

  }

}
