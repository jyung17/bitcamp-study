package com.bitcamp.young;

import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value = "/A")
public class A {
  BoardDao boardDao;

  public A(BoardDao boardDao) {
    this.boardDao = boardDao;
  };
}
