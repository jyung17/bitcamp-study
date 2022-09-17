package com.bitcamp.jong;

import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value = "/jong/B")
public class B {
  Const constt;

  public B(Const constt) {
    this.constt = constt;
  }
}
