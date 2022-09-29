<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>bitcamp</title>
</head>
<body>
  <h1>회원 상세 정보-(JSP + Servlet + EL)</h1>

  <form action='update' method="post">
    <table border='1'>
      <tr>
        <th>번호</th>
        <td><input name='no' type='number' value='${member.no}' readonly='false'></td>
      </tr>
      <tr>
        <th>이름</th>
        <td><input name='name' type='text' value='${member.name}'></td>
      </tr>
      <tr>
        <th>이메일</th>
        <td><input name='email' type='text' value='${member.email}'></td>
      </tr>
      <tr>
        <th>패스워드</th>
        <td><input name='password' type='password'></td>
      </tr>
      <tr>
        <th>등록일</th>
        <td>${member.createdDate}</td>
      </tr>
    </table>
    <p>
      <button type='submit'>변경</button>
      <a href='delete?no=${member.no}'>삭제</a>
    </p>
  </form>
</body>
</html>
