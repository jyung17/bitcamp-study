package com.eomcs.oop.ex03.test;

import static com.eomcs.oop.ex03.test.Member.GUEST;
import static com.eomcs.oop.ex03.test.Member.MANAGER;
import static com.eomcs.oop.ex03.test.Member.MEMBER;

public class Exam0160_4 {

  public static void main(String[] args) {

    // TODO Auto-generated method stub
    Member m1 = new Member("aaa", "1111", GUEST);
    Member m2 = new Member("bbb", "1111", MEMBER);
    Member m3 = new Member("ccc", "1111", MANAGER);

    System.out.printf("%s, %s, %d\n", m1.id, m1.password, m1.type);
    System.out.printf("%s, %s, %d\n", m2.id, m2.password, m2.type);
    System.out.printf("%s, %s, %d\n", m3.id, m3.password, m3.type);
  }
}
