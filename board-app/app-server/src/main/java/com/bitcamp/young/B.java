package com.bitcamp.young;

import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value = "/B")
public class B {
  BoardDao boardDao;

  public B(BoardDao boardDao) {
    this.boardDao = boardDao;
  };
}
