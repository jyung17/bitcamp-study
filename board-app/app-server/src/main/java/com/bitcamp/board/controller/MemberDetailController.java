package com.bitcamp.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@Controller
//- 애노테이션을 붙일 때 객체 이름을 명시하면 그 이름으로 저장한다.
//- 프론트 컨트롤러는 페이지 컨트로러를 찾을 때 이 이름으로 찾을 것이다.
public class MemberDetailController {

  MemberService memberService;

  public MemberDetailController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/member/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int memberNo = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(memberNo);

    if (member == null) {
      throw new Exception("사용자 조회 실패!");
    }

    request.setAttribute("member", member);
    return "/member/detail.jsp";
  }
}
