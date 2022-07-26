package com.eomcs.oop.ex07.a;

abstract class A3_1 {
  public abstract void m1();
}


class A3Sub_1 extends A3_1 {
  @Override
  public void m1() {
    System.out.println("A3Sub_1.m1() 호출됨!");
  }

  public void m2() {
    System.out.println("A3Sub_1.m2() 호출됨!");
  }
}


public class Exam03_1 {
  public static void main(String[] args) {
    A3_1 obj;
    //    obj = new A3_1();

    obj = new A3Sub_1();
    obj.m1();
    // obj.m2();
    // A3_1 obj 
    // - 슈퍼 클래스 타입의 레퍼런스 변수(참조 변수)
    // - 부모 클래스 타입의  레퍼런스 변수(참조 변수)
    // obj = new A3Sub_1();
    // - 부모타입의 레퍼런스(참조) 변수로 자식클래스의 인스턴스(객체) 변수를 사용
    // - 슈퍼클래스 타입의 레퍼런스 변수로 서브클래스의 인스턴스 변수를 사용
    // 부모타입의 레퍼런스 변수로 자식클래스의 인스턴스 변수를 사용할 수 없다.
    // 사용하려면 강제 형변환 후에 사용 가능
    ((A3Sub_1) obj).m2();

    test_1(obj);

  }

  static void test_1(A3_1 obj) {
    obj.m1();
  }
}
