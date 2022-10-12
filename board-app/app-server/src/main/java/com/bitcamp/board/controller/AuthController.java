package com.bitcamp.board.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@Controller // 페이지 컨트롤러에 붙이는 애노테이션
//- 애노테이션을 붙일 때 객체 이름을 명시하면 그 이름으로 저장한다.
//- 프론트 컨트롤러는 페이지 컨트로러를 찾을 때 이 이름으로 찾을 것이다.
public class AuthController {

  MemberService memberService;

  public AuthController(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping(value = "/auth/form", method = RequestMethod.GET)
  public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/auth/form.jsp";
  }

  @RequestMapping(path = "/auth/login", method = RequestMethod.POST)
  public String login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    Member member = memberService.get(email, password);

    if (member != null) {
      HttpSession session = request.getSession();
      session.setAttribute("loginMember", member);
    }

    Cookie cookie = new Cookie("email", email);
    if (request.getParameter("saveEmail") == null) {
      cookie.setMaxAge(0);
    } else {
      cookie.setMaxAge(60 * 60 * 24 * 7); // 7일
    }

    response.addCookie(cookie);
    request.setAttribute("member", member);
    return "/auth/loginResult.jsp";
  }

  @RequestMapping(value = "/auth/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
    HttpSession session = request.getSession(); // 요청한 클라이언트의 전용 HttpSession 보관소를 얻는다.
    session.invalidate(); // 현재 세션을 무효화시킨다.
    return "redirect:../../";
  }
}
