// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : insert
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam311 {

  public static void main(String[] args) throws Exception {

    try (
        // DB연결
        java.sql.Connection con = DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");

        java.sql.Statement stmt = con.createStatement();) {

      int count = stmt.executeUpdate("insert into x_board(title,contents) values('제목11','내용')");
      System.out.printf("%d 개 입력 성공!", count);
    }
  }
}


