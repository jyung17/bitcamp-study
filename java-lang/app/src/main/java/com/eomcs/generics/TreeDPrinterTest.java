package com.eomcs.generics;

public class TreeDPrinterTest {
  public static void main(String[] args) {
    TreeDPrinter<Powder> printer = new TreeDPrinter<>();

    printer.setMaterial(new Powder());

    Powder powder = printer.getMaterial();
  }
}
