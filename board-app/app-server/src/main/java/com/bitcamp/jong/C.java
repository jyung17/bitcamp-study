package com.bitcamp.jong;

import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value = "/jong/C")
public class C {
  BoardDao boardDao;

  public C(BoardDao boardDao) {
    this.boardDao = boardDao;
  }
}
