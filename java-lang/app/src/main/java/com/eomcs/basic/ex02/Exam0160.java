// String - mutable vs immutable 객체
package com.eomcs.basic.ex02;

public class Exam0160 {
  public static void main(String[] args) {
    // String 객체는 immutable 객체이다.
    // 즉 한 번 객체에 값을 담으면 변경할 수 없다.

    String s1 = new String("Hello");

    // String 클래스의 메서드는 원본 인스턴스의 데이터를 변경하지 않는다. 
    // 다만 새로 String 객체를 만들 뿐이다.
    // s2 = s1.replace('l', 'x');  하게되면 상수풀에 String 객체를 구성한 후 그 주소를 리턴한다.
    String s2 = s1.replace('l', 'x');
    String s2_1 = s2.intern();
    System.out.println(s1 == s2);
    System.out.println(s2 == s2_1);
    System.out.println(s2.hashCode());
    System.out.println(s2_1.hashCode());
    System.out.printf("%s : %s\n", s1, s2); // 원본은 바뀌지 않는다.

    String s3 = s1.concat(", world!");
    System.out.printf("%s : %s\n", s1, s3); // 원본은 바뀌지 않는다.
  }
}


