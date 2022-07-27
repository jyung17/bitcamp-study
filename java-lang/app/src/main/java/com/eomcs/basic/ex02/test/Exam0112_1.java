package com.eomcs.basic.ex02.test;

public class Exam0112_1 {
  public static void main(String[] args) {
    String s1 = new String("Hello");
    String s2 = "Hello";
    String s3 = s1.intern();
    String s4 = "HELLO";

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));
    System.out.println(s2.equals(s3));
    System.out.println(s1 instanceof String);
    System.out.println(s2 instanceof String);
    System.out.println(s1 == s3);
    System.out.println(s2 == s3);
    System.out.println(s1.equals(s4));
    System.out.println(s1.equalsIgnoreCase(s4));
  }
}
