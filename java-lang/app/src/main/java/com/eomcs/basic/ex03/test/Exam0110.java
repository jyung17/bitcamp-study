package com.eomcs.basic.ex03.test;

import java.util.ArrayList;
import java.util.Date;

public class Exam0110 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("Hello");
    list.add(Integer.valueOf(100));
    list.add(100);
    list.add(new Date());

    for (int i = 0; i < list.size(); i++) {
      System.out.println(list.get(i));
    }
    System.out.println();

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("Hello");
    list2.add(Integer.valueOf(100));
    list2.add(100);
    list2.add(new Date());
    for (int i = 0; i < list.size(); i++) {
      System.out.println(list2.get(i));
    }
  }
}
