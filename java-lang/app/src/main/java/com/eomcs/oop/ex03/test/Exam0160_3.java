package com.eomcs.oop.ex03.test;

public class Exam0160_3 {
  static class Member {

    static final int GUEST = 0;
    static final int MEMBER = 1;
    static final int MANAGER = 2;

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
    Member m1 = new Member("aaa", "1111", Member.GUEST);
    Member m2 = new Member("bbb", "1111", Member.MEMBER);
    Member m3 = new Member("ccc", "1111", Member.MANAGER);

    System.out.printf("%s, %s, %d\n", m1.id, m1.password, m1.type);
    System.out.printf("%s, %s, %d\n", m2.id, m2.password, m2.type);
    System.out.printf("%s, %s, %d\n", m3.id, m3.password, m3.type);
  }
}
