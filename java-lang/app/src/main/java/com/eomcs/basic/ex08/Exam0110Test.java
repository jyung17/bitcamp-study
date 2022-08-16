package com.eomcs.basic.ex08;

import java.util.HashMap;

public class Exam0110Test {
  public static void main(String[] args) {
    HashMap<String, Member> map = new HashMap<>();
    map.put("s01", new Member("홍길동", 20));
    System.out.println(map.get("s01"));

    map.put("s02", new Member("임꺽정", 30));
    map.put("s03", new Member("유관순", 16));
    map.put("s04", new Member("안중근", 20));
    System.out.println(map.get("s02"));

    map.put("s02", new Member("윤봉길", 30));
    System.out.println(map.get("s02"));

    System.out.println(map.get("s05"));
  }
}
