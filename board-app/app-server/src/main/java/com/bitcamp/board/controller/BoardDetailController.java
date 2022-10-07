package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.service.BoardService;


@WebServlet("/board/detail")
public class BoardDetailController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardService boardService;

  @Override
  public void init() {
    boardService = (BoardService) this.getServletContext().getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    int boardNo = Integer.parseInt(request.getParameter("no"));

    try {
      Board board = boardService.get(boardNo);

      if (board == null) {
        throw new Exception("게시글 조회 실패!");
      }

      request.setAttribute("board", board); // JSP가 사용할수 있도록 서블릿 리퀘스트에 저장한다.
      request.setAttribute("viewName", "/board/detail.jsp");

    } catch (Exception e) {
      request.setAttribute("exception", e);
    }
  }
}
