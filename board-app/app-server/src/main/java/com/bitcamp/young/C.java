package com.bitcamp.young;

import com.bitcamp.servlet.annotation.WebServlet;

@WebServlet(value = "/C")
public class C {
  BoardDao boardDao;

  public C(BoardDao boardDao) {
    this.boardDao = boardDao;
  };
}
