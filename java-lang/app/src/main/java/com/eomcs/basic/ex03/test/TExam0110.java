package com.eomcs.basic.ex03.test;

import java.util.ArrayList;
import java.util.Date;

class Board {
  int no;
  String title;
  String content;
}


public class TExam0110 {
  public static void main(String[] args) {
    ArrayList list = new ArrayList();
    list.add("Hello");
    list.add(Integer.valueOf(100));
    list.add(100);
    list.add(new Date());

    ArrayList<Object> list2 = new ArrayList<>();
    list2.add("Hello");
    list2.add(Integer.valueOf(100));
    list2.add(100);
    list2.add(new Date());

    ArrayList<Board> list3 = new ArrayList<>();

  }
}
