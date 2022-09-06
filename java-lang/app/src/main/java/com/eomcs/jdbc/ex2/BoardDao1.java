package com.eomcs.jdbc.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BoardDao1 {
  public int delete(int no) throws Exception {
    try (
        Connection con = DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        Statement stmt = con.createStatement()) {

    }

    return 0;
  }

}
