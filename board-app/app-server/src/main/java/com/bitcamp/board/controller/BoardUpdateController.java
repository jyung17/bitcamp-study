package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;


@WebServlet("/board/update")
public class BoardUpdateController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardDao boardDao;

  @Override
  public void init() {
    boardDao = (BoardDao) this.getServletContext().getAttribute("boardDao");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      Board board = new Board();

      // board no=71;
      // getNo = 71;
      board.setNo(Integer.parseInt(request.getParameter("no")));
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));

      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      System.out.println(loginMember);

      System.out.println(boardDao.findByNo(board.getNo()).getWriter());
      System.out.println(boardDao.findByNo(board.getNo()).getWriter().getNo());

      if (boardDao.findByNo(board.getNo()).getWriter().getNo() != loginMember.getNo()) {
        //loginMember.getNo() = 23
        // 
        /*
         * boardDao.findByNo(board.getNo()) ==> boardDao.findByNo(게시글번호)
         * boardDao.findByNo(board.getNo()).getWriter()
         *  => Member [no=23, name=user1, email=null, password=null, createdDate=null]
         * boardDao.findByNo(board.getNo()).getWriter().getNo()
         *  => 23
         */

        throw new Exception("게시글 작성자가 아닙니다.");
      }

      if (boardDao.update(board) == 0) {
        throw new Exception("게시글 변경 실패!");
      }
      // Refresh:
      // - 응답 헤더 또는 HTML 문서에 refresh 명령을 삽입할 수 있다.
      // - 응답 프로토콜
      //      HTTP/1.1 200
      //      Refresh: 30;url=list
      //      Content-Type: text/html;charset=UTF-8
      //      Content-Length: 198
      //      Date: Mon, 26 Sep 2022 05:57:00 GMT
      //      Keep-Alive: timeout=20
      //      Connection: keep-alive
      //
      //      <!DOCTYPE html>
      //      <html>
      //      <head>
      //      <meta charset="UTF-8">
      //      <title>bitcamp</title>
      //      </head>
      //      <body>
      //        <h1>게시글 변경(JSP-Servlet)</h1>
      //        <p>해당 게시글을 변경했습니다.</p>
      //      </body>
      //      </html>
      //
      // 자바 코드: 
      response.setHeader("Refresh", "1;url=list");
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/board/update.jsp").include(request, response);

    } catch (Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
