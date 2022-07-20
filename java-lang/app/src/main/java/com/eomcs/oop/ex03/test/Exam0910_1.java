package com.eomcs.oop.ex03.test;

public class Exam0910_1 {

  static class Monitor {
    int bright = 50;
    int contrast = 50;
    int widthRes = 1920;
    int heightRes = 1080;

    void display() {
      System.out.println("---------------------");
      System.out.printf("밝기(%d)\n", this.bright);
      System.out.printf("명암(%d)\n", this.contrast);
      System.out.printf("해상도(%d x %d)\n", this.widthRes, this.heightRes);
      System.out.println("---------------------");
    }
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Monitor m1 = new Monitor();

    m1.display();

    m1.bright = 40;

    m1.display();
  }

}
