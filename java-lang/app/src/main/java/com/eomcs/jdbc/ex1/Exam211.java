// JDBC 프로그래밍 - DBMS에 연결하기
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam211 {

  public static void main(String[] args) throws Exception {



    try (java.sql.Connection con =
        DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", // jdbcURL
            "study", // username
            "1111" // password
        );) {

      System.out.println("DBMS와 연결됨!");

      System.out.println(con.getClass().getName());

    }
    System.out.println("DBMS와 연결 해제됨!");
  }
}


