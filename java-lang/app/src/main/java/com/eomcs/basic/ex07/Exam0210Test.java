package com.eomcs.basic.ex07;

import java.util.HashSet;

public class Exam0210Test {
  public static void main(String[] args) {
    HashSet<String> set = new HashSet<>();
    set.add("aaa");
    set.add("bbb");
    set.add("ccc");
    set.add("ddd");
    set.add("eee");

    Object[] values = set.toArray();
    for (Object value : values) {
      System.out.printf(value + ", ");
    }
    System.out.println();
  }
}
