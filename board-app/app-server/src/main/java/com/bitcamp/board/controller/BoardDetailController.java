package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.service.BoardService;
import com.bitcamp.servlet.Controller;


public class BoardDetailController implements Controller {

  BoardService boardService;

  public BoardDetailController(BoardService boardService) {
    this.boardService = boardService;
  }

  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int boardNo = Integer.parseInt(request.getParameter("no"));

    Board board = boardService.get(boardNo);

    if (board == null) {
      throw new Exception("게시글 조회 실패!");
    }

    request.setAttribute("board", board); // JSP가 사용할수 있도록 서블릿 리퀘스트에 저장한다.
    return "/board/detail.jsp";
  }
}
