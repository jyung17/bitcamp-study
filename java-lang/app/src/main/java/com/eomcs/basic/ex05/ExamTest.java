package com.eomcs.basic.ex05;

import java.util.Iterator;
import java.util.Stack;

public class ExamTest {
  public static void main(String[] args) {
    Stack<String> stack = new Stack<>();

    stack.push("aaa");
    stack.push("bbb");
    stack.push("ccc");

    //    System.out.println(stack.pop());
    //    System.out.println(stack.pop());
    //    System.out.println(stack.pop());

    System.out.println(stack.peek());

    System.out.println(stack.search(new String("aaa")));

    //    System.out.println("-----");
    //    while (!stack.empty()) {
    //      System.out.println(stack.pop());
    //    }

    for (int i = 0; i < stack.size(); i++) {
      System.out.println(stack.get(i));
    }

    //    System.out.println("-----");
    //    while (!stack.empty()) {
    //      System.out.println(stack.pop());
    //    }

    System.out.println("--iterator  --");
    Iterator<String> iterator = stack.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

    System.out.println("--for---");
    for (String s : stack) {
      System.out.println(s);
    }
  }
}
