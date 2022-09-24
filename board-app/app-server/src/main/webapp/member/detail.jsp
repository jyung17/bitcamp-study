<%@page import="com.bitcamp.board.domain.Member"%>
<%@page import="com.bitcamp.board.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<%!MemberDao memberDao;

  public void jspInit() {
    memberDao = (MemberDao) this.getServletContext().getAttribute("memberDao");
  }%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
</head>
<body>
  <h1>회원 상세 정보</h1>

<%
  int memberNo = Integer.parseInt(request.getParameter("no")); try { Member
  member = memberDao.findByNo(memberNo); if (member == null) {
%>
  <p>해당 번호의 게시글이 없습니다.</p>
<%
  } else {
%>
  <form action='update'>
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input name='no' type='number' value='<%=member.no%>'
          readonly='false'></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><input name='name' type='text' value='<%=member.name%>'></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input name='email' type='text' value='<%=member.email%>'></td>
      </tr>
      <tr>
        <th>패스워드</th>
        <td><input name='password' type='password'></td>
      </tr>
      <tr>
        <th>등록일</th>
        <td><%=member.createdDate%></td>
      </tr>
    </table>
    <p>
      <button type='submit'>변경</button>
      <a href='delete?no=<%=member.no%>'>삭제</a>
    </p>
  </form>
<%
  } } catch (Exception e) {
%>
  <p>실행 중 오류 발생!</p>
<%
  }
%>
</body>
</html>