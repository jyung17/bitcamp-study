package com.eomcs.design_pattern.iterator.after1;

import java.util.ArrayList;
import java.util.Iterator;

public class Test02 {

  public static void main(String[] args) {
    ArrayList<String> cars = new ArrayList<>();
    cars.add("벤츠");
    cars.add("람보르기니");
    cars.add("롤스로이스");
    cars.add("페라리");

    Iterator<String> iterator = cars.iterator();
    while (iterator.hasNext()) {
      System.out.println(iterator.next());
    }

  }
}
