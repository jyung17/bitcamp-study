package com.bitcamp.board.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@Controller // 페이지 컨트롤러에 붙이는 애노테이션
//- 애노테이션을 붙일 때 객체 이름을 명시하면 그 이름으로 저장한다.
//- 프론트 컨트롤러는 페이지 컨트로러를 찾을 때 이 이름으로 찾을 것이다.
@RequestMapping("/auth/")
public class AuthController {

  MemberService memberService;

  public AuthController(MemberService memberService) {
    this.memberService = memberService;
  }

  //@RequestMapping(value = "/auth/form", method = RequestMethod.GET)
  // InternalResourceViewResolver 사용
  //  @GetMapping("form")
  //  public View form() throws Exception {
  //    return new JstlView("/auth/form.jsp");
  //  } // JSTL에 담아서 리턴해도 된다

  // InternalResourceViewResolver 사용후
  @GetMapping("form")
  public String form() throws Exception {
    return "auth/form";
  } // JSTL에 담아서 리턴해도 된다

  //@RequestMapping(path = "/auth/login", method = RequestMethod.POST)
  @PostMapping("login")
  public ModelAndView login(String email, String password, String saveEmail,
      HttpServletRequest request, HttpSession session, HttpServletResponse response)
      throws Exception {

    Member member = memberService.get(email, password);

    if (member != null) {
      session.setAttribute("loginMember", member);
    }

    Cookie cookie = new Cookie("email", email);
    if (saveEmail == null) {
      cookie.setMaxAge(0);
    } else {
      cookie.setMaxAge(60 * 60 * 24 * 7); // 7일
    }

    response.addCookie(cookie);

    ModelAndView mv = new ModelAndView("auth/loginResult");
    mv.addObject("member", member);
    return mv;
  }

  //@RequestMapping(value = "/auth/logout", method = RequestMethod.GET)
  @GetMapping("logout")
  public String logout(HttpSession session) throws Exception {
    session.invalidate(); // 현재 세션을 무효화시킨다.
    return "redirect:../../";
  }
}
