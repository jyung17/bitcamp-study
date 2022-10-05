package com.bitcamp.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.bitcamp.board.domain.AttachedFile;
import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.BoardService;

// Servlet API에서 제공하는 Multipart/form-data 처리기를 사용하려면
// 서블릿에 다음 애노테이션으로 설정해야한다.
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // 최대 10M까지 업로드 혀용
@WebServlet("/board/add")
public class BoardAddController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  BoardService boardService;

  @Override
  public void init() {
    boardService = (BoardService) this.getServletContext().getAttribute("boardService");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      request.setCharacterEncoding("UTF-8");
      Board board = new Board();
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));
      System.out.println(board);


      // 첨부파일명을 저장할 컬렉션 객체 준비
      List<AttachedFile> attachedFiles = new ArrayList<>();

      // 임시 폴더에 저장된 파일을 옮길 폴더 경로 알아내기
      String dirPath = request.getServletContext().getRealPath("/board/files");

      Collection<Part> parts = request.getParts();

      for (Part part : parts) {
        if (!part.getName().equals("files")) {
          continue;
        }

        String filename = UUID.randomUUID().toString();
        // 우리가 지정한 디렉토리로 옮긴다.
        // 이때 파일명은 원래의 이름 대신 우리가 UUID로 생성한 이름을 사용한다.
        part.write(dirPath + "/" + filename);
        attachedFiles.add(new AttachedFile(filename));
      }

      // Board 객체에서 파일명 목록을 담고 있는 컬렉션 객체를 저장한다.
      board.setAttachedFiles(attachedFiles);

      Member loginMember = (Member) request.getSession().getAttribute("loginMember");
      board.setWriter(loginMember);

      // 서비스 객체에 업무를 맡긴다.
      boardService.add(board);

      response.sendRedirect("list");
    } catch (

    Exception e) {
      request.setAttribute("exception", e);
      request.getRequestDispatcher("/error.jsp").forward(request, response);
    }
  }
}
