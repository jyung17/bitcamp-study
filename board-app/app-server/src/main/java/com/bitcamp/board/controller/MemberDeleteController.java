package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bitcamp.board.service.MemberService;
import com.bitcamp.servlet.Controller;


public class MemberDeleteController implements Controller {

  MemberService memberService;

  public MemberDeleteController(MemberService memberService) {
    this.memberService = memberService;
  }


  @Override
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    if (!memberService.delete(no)) {
      throw new Exception("사용자 삭제 실패!");
    }

    return "redirect:list";
  }
}
