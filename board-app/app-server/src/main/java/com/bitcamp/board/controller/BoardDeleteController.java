package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;


@WebServlet("/board/delete")
public class BoardDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int no = Integer.parseInt(request.getParameter("no"));

    try {
      if (boardDao.delete(no) == 0) {
        throw new Exception("게시글 삭제 실패!");
      }
      // Redirect:
      // - 클라이언트에게 콘텐트를 보내지 않는다.
      // - 응답 프로토콜
      //      HTTP/1.1 302
      //      Location: list
      //      Content-Length: 0
      //      Date: Mon, 26 Sep 2022 05:23:40 GMT
      //      Keep-Alive: timeout=20
      //      Connection: keep-alive
      //
      //      (콘텐트 없음!)
      //
      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}