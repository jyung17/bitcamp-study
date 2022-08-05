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

    System.out.println(list);
  }
}
