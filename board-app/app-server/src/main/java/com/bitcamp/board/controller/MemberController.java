package com.bitcamp.board.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.bitcamp.board.domain.Member;
import com.bitcamp.board.service.MemberService;

@Controller
//- 애노테이션을 붙일 때 객체 이름을 명시하면 그 이름으로 저장한다.
//- 프론트 컨트롤러는 페이지 컨트로러를 찾을 때 이 이름으로 찾을 것이다.
public class MemberController {

  MemberService memberService;

  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/member/form")
  public String form(HttpServletRequest request, HttpServletResponse response) throws Exception {
    return "/member/form.jsp";
  }

  @PostMapping("/member/add")
  public String add(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setCharacterEncoding("UTF-8");

    Member member = new Member();
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));

    memberService.add(member);

    return "redirect:list";
  }

  @GetMapping("/member/list")
  public String list(HttpServletRequest request, HttpServletResponse response) throws Exception {
    List<Member> members = memberService.list();
    request.setAttribute("members", members);

    return "/member/list.jsp";
  }

  @GetMapping("/member/detail")
  public String detail(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int memberNo = Integer.parseInt(request.getParameter("no"));

    Member member = memberService.get(memberNo);

    if (member == null) {
      throw new Exception("사용자 조회 실패!");
    }

    request.setAttribute("member", member);
    return "/member/detail.jsp";
  }

  @PostMapping("/member/update")
  public String update(HttpServletRequest request, HttpServletResponse response) throws Exception {
    request.setCharacterEncoding("UTF-8");

    Member member = new Member();
    member.setNo(Integer.parseInt(request.getParameter("no")));
    member.setName(request.getParameter("name"));
    member.setEmail(request.getParameter("email"));
    member.setPassword(request.getParameter("password"));

    if (!memberService.update(member)) {
      throw new Exception("사용자 변경 실패!");
    }

    return "redirect:list";
  }

  @GetMapping("/member/delete")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
    int no = Integer.parseInt(request.getParameter("no"));
    if (!memberService.delete(no)) {
      throw new Exception("사용자 삭제 실패!");
    }

    return "redirect:list";
  }
}
