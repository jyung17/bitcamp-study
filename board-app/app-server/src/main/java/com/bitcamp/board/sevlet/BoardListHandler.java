/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.sevlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.domain.Board;

@WebServlet(value = "/board/list")
public class BoardListHandler implements Servlet {

  private BoardDao boardDao;

  public BoardListHandler(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    // TODO Auto-generated method stub

  }

  @Override
  public ServletConfig getServletConfig() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void service(ServletRequest req, ServletResponse res)
      throws ServletException, IOException {

    res.setContentType("text/html; charset=UTF-8");

    PrintWriter out = res.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset=\"UTF-8\">");
    out.println("<title>bitcamp</title>");
    out.println("<style>");
    out.println("tr:hover {");
    out.println("    background-color: gray;");
    out.println("    color: white;");
    out.println("}");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글</h1>");

    out.println("<a href='form'>새 글</a>");

    out.println("<table border='1'>");
    out.println("  <tr>");
    out.println("    <th>번호</th>");
    out.println("    <th>제목</th>");
    out.println("    <th>조회수</th>");
    out.println("    <th>작성자</th>");
    out.println("    <th>등록일</th>");
    out.println("  </tr>");

    List<Board> boards;
    try {
      boards = boardDao.findAll();
      for (Board board : boards) {
        out.println("<tr>");
        out.printf("  <td>%d</td>", board.no);
        out.printf("  <td><a href='detail?no=%d'>%s</a></td>", board.no, board.title);
        out.printf("  <td>%d</td>", board.viewCount);
        out.printf("  <td>%d</td>", board.memberNo);
        out.printf("  <td>%s</td>", board.createdDate);
        out.printf("</tr>");
      }
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    out.println("</table>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public String getServletInfo() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void destroy() {
    // TODO Auto-generated method stub

  }
}


