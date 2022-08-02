package com.eomcs.oop.ex09.b;

class one {
  int a;
  int b;
}


class two extends one {
  String a;
  String b;
}


class three extends two implements fore {
  char a;
  char b;

  @Override
  public void abcd() {
    // TODO Auto-generated method stub

  }
}


interface fore1 {

}


interface fore extends fore1 {
  abstract void abcd();
}


public class Test01 {

}
