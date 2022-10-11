package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.service.BoardService;

@Controller // 페이지 컨트롤러에 붙이는 애노테이션
public class BoardDetailController {

  BoardService boardService;

  public BoardDetailController(BoardService boardService) {
    this.boardService = boardService;
  }

  @GetMapping("/board/detail") // 요청을 들어 왔을 때 호출될 메서드에 붙이는 애노테이션
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
