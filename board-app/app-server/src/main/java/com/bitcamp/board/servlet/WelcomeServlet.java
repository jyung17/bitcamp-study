package com.bitcamp.board.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(value = "/welcome")
public class WelcomeServlet implements Servlet {

  ServletConfig config;

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
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>환영합니다!1</h1>");
    out.println("<p>비트캠프 게시판 관리 시스템 프로젝트 입니다.</p>");
    out.println("<form action='board/list'>");
    out.println("<p>");
    out.println("<button type='submit'>게시판</button>");
    out.println("</p>");
    out.println("</form>");
    out.println("<form action='member/list'>");
    out.println("<p>");
    out.println("<button type='submit'>회원</button>");
    out.println("</p>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  public void init(ServletConfig config) throws ServletException {
    System.out.println("WelcomServlet.init()");
    this.config = config;
  }

  @Override
  public ServletConfig getServletConfig() {
    System.out.println("WelcomServlet.getServletConfig()");
    return this.config;
  }


  @Override
  public String getServletInfo() {
    System.out.println("WelcomServlet.getServletInfo()");
    return "환영인사를 하는 서블릿";
  }

  @Override
  public void destroy() {
    System.out.println("WelcomServlet.destroy()");
  }
}
