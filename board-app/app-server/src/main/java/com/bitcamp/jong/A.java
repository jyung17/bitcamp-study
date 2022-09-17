package com.bitcamp.jong;

import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value = "/jong/A")
public class A {
  Const constt;

  public A(Const constt) {
    this.constt = constt;
  }
}


