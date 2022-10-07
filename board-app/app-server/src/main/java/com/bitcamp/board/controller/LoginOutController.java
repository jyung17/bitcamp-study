package com.bitcamp.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/auth/logout")
public class LoginOutController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    HttpSession session = request.getSession(); // 요청한 클라이언트의 전용 HttpSession 보관소를 얻는다.
    session.invalidate(); // 현재 세션을 무효화시킨다.

    request.setAttribute("viewName", "redirect:../../");
  }
}
