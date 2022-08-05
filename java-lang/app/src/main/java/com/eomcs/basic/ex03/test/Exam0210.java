package com.eomcs.basic.ex03.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class Exam0210 {

  public static void main(String[] args) {
    class Member {
      String name;
      int age;

      public Member(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Member [name=" + name + " . age=" + age + "]";
      }
    }

    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 17);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println("--------------");

    for (int i = 0; i < list.size(); i++) {
      Member m = list.get(i);
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    System.out.println("--------------");

    Object[] arr = list.toArray();
    for (Object obj : arr) {
      Member m = (Member) obj;
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    System.out.println("--------------");

    Member[] arr2 = list.toArray(new Member[list.size()]);
    for (Member m : arr2) {
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    System.out.println("--------------");

    Iterator<Member> iterator = list.iterator();

    while (iterator.hasNext()) {
      Member m = iterator.next();
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }

    System.out.println("--------------");

    class MyConsumer implements Consumer<Member> {
      @Override
      public void accept(Member m) {
        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
      }
    }
    list.forEach(new MyConsumer());
    System.out.println("--------------");

    Consumer<Member> action = new Consumer<>() {
      @Override
      public void accept(Member m) {
        System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
      }
    };

    list.forEach(action);
    System.out.println("--------------");
  }
}
