package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.BoardService;


@WebServlet("/board/fileDelete")
public class BoardFileDeleteController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardService boardService;

  @Override
  public void init() {
    boardService = (BoardService) this.getServletContext().getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int no = Integer.parseInt(request.getParameter("no"));

      // 첨부파일 정보를 가져온다.
      AttachedFile attachedFile = boardService.getAttachedFile(no);

      // 게시글의 작성자가 로그인 사용자인지 검사한다.
      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      Board board = boardService.get(attachedFile.getBoardNo());
      if (board.getWriter().getNo() != loginMember.getNo()) {
        throw new Exception("게시글 작성자가 아닙니다.");
      }

      // 첨부파일을 삭제한다.
      if (!boardService.deleteAttachedFile(no)) {
        throw new Exception("게시글 첨부파일을 삭제할 수 없습니다.");
      }

      response.sendRedirect("detail?no=" + board.getNo()); // Board 객체를 여기서도 사용해야해서 Board 객체를 생

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}