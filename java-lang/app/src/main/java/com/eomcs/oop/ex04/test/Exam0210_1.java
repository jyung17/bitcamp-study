package com.eomcs.oop.ex04.test;

public class Exam0210_1 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String s1 = new String("Hello");

    char c = s1.charAt(1);
    System.out.println(c);

    System.out.println(s1.compareTo("Hello"));
    System.out.println(s1.compareTo("Hell"));
    System.out.println(s1.compareTo("Helo"));

    System.out.println(s1.contains("ll"));
    System.out.println(s1.contains("eo"));

    String s2 = s1.concat(", world!");
    System.out.println(s1);
    System.out.println(s2);

    System.out.println(s1.equals("aaa"));
    System.out.println(s1.equals("Hello"));
    System.out.println(s1 == "Hello");

    String s3 = new String("ABC가각");

    byte[] bytes;
    bytes = s3.getBytes();

    for (int i = 0; i < bytes.length; i++) {
      System.out.printf("%x,", bytes[i]);
    }
    System.out.println();
    System.out.println("=============");

    String s33 = new String("각");
    byte[] bytes2 = s33.getBytes();
    for (int i = 0; i < bytes2.length; i++) {
      System.out.printf("%x,", bytes2[i]);
    }
    System.out.println();
    System.out.println("=============");


    String s4 = String.format("%s님 반갑습니다", "홍길동");
    System.out.println(s4);

    String s5 = String.join(":", "홍길동", "임꺽정", "유관순");
    System.out.println(s5);
  }
}
