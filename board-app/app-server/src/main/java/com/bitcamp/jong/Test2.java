package com.bitcamp.jong;

import java.lang.reflect.Constructor;

public class Test2 {
  public static void main(String[] args) throws Exception {
    Class<?> classInfo = Class.forName("java.lang.String");
    System.out.println(classInfo);

    String x1 = (String) classInfo.newInstance(); // @Deprecated (사용하지 말라)
    // 1. 생성자를 알아낸다.
    Constructor<?> constructor = classInfo.getConstructor();
    // 2. 생성자를 통해 인스턴스 생성
    constructor.newInstance();
  }
}
