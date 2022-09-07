// 게시물 관리 - 조회 + PreparedStatement 적용
package com.eomcs.jdbc.ex3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam331123 {

  public static void main(String[] args) throws Exception {
    String str = String.format("where board_id=%d", 32);

    try (
        Connection con = DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        PreparedStatement stmt = con.prepareStatement("select * from x_board" + str)) {


      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          System.out.printf("제목: %s\n", rs.getString("title"));
          System.out.printf("내용: %s\n", rs.getString("contents"));
          System.out.printf("등록일: %s\n", rs.getInt("board_id"));
          System.out.printf("조회수: %d\n", rs.getInt("view_count"));
        } else {
          System.out.println("해당 번호의 게시물이 존재하지 않습니다.");
        }
      }
    }
  }
}


