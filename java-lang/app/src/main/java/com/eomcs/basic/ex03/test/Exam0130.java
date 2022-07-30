package com.eomcs.basic.ex03.test;

import java.util.ArrayList;
import java.util.Objects;

public class Exam0130 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    class Member {
      String name;
      int age;

      public Member(String name, int age) {
        this.name = name;
        this.age = age;
      }

      @Override
      public String toString() {
        return "Member [name=" + name + ", age=" + age + "]";
      }

      @Override
      public int hashCode() {
        return Objects.hash(age, name);
      }

      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Member other = (Member) obj;
        if (age != other.age)
          return false;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false;
        return true;
      }
    }

    Member m1 = new Member("홍길동", 20);
    Member m2 = new Member("임꺽정", 30);
    Member m3 = new Member("유관순", 17);

    ArrayList<Member> list = new ArrayList<>();
    list.add(m1);
    list.add(m2);
    list.add(m3);
    System.out.println(list);

    Member m4 = new Member("임꺽정", 30);
    System.out.println(list.contains(m4));
    System.out.println(list.indexOf(m4));

    System.out.println(m2 == m4);
    System.out.println(m2.equals(m4));
    System.out.println(m2.hashCode() == m4.hashCode());

    System.out.println(list.get(1));

    for (int i = 0; i < list.size(); i++) {
      Member m = list.get(i);
      System.out.printf("이름: %s, 나이: %d\n", m.name, m.age);
    }
    System.out.println();

    Object[] arr = list.toArray(); // 전체목록
    for (Object obj : arr) {
      Member mm = (Member) obj;
      System.out.printf("이름: %s, 나이: %d\n", mm.name, mm.age);
    }
  }
}
