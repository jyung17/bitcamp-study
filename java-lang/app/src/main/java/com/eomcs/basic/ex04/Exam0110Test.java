package com.eomcs.basic.ex04;

import java.util.LinkedList;

public class Exam0110Test {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s1 = new String("aaa");
    String s2 = new String("bbb");
    String s3 = new String("ccc");
    String s4 = new String("ddd");
    String s5 = new String("eee");

    LinkedList list = new LinkedList();
    list.add(s1);
    list.add(s2);
    list.add(s3);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));

    System.out.println(list.size());
    print(list);

  }

  private static void print(LinkedList list) {
    // TODO Auto-generated method stub
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ", ");
    }
    System.out.println();
  }
}
