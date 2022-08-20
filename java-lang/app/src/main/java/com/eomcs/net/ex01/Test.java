package com.eomcs.net.ex01;

interface Fightable extends Movable {
}


interface Movable {
  void mov(int x, int y);
}


class Unit {
  int currentHP;
  int x;
  int y;
}


class Firether2 extends Unit implements Fightable {

  @Override
  public void mov(int x, int y) {
    // TODO Auto-generated method stub
  }
}


class Firether extends Unit implements Fightable {


  @Override
  public void mov(int x, int y) {
    System.out.println(x + y);
  }

  public void attack(Fightable f) {
    System.out.println(f);
  }
}


public class Test {
  public static void main(String[] args) {

    Firether firether = new Firether();
    Firether2 firether2 = new Firether2();
    firether.attack(firether2);
    firether.mov(1, 2);
  }
}
