package com.eomcs.oop.ex03.test;

public class Member {

  static final int GUEST = 0;
  static final int MEMBER = 1;
  static final int MANAGER = 2;

  public String id;
  public String password;
  public int type; // 0: 손님, 1: 회원, 2: 관리자

  public Member(String id, String password, int type) {
    this.id = id;
    this.password = password;
    this.type = type;
  }
}
