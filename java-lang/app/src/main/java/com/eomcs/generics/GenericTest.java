package com.eomcs.generics;

import java.util.ArrayList;

public class GenericTest {
  public static void main(String[] args) {
    ArrayList<Integer> list = new ArrayList();
    list.add(10);
    list.add(20);
    //list.add("30");
    list.add(30);

    Integer i = list.get(2);

    System.out.println(list);
  }
}
