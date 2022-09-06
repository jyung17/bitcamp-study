// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : select
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam0340 {

  public static void main(String[] args) throws Exception {
    try (
        java.sql.Connection con = DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();
        java.sql.ResultSet rs =
            stmt.executeQuery("select * from x_board order by board_id desc");) {

      // 반복문을 사용하면 서버에서 여러 개의 데이터를 가져올 수 있다.
      // - next()는 서버에서 레코드 1개를 가져온다.
      while (rs.next()) {
        System.out.printf("%d, %s, %s, %s, %d\n", rs.getInt("board_id"), rs.getString("title"),
            rs.getString("contents"), rs.getDate("created_date"), rs.getInt("view_count"));
      }
    }
  }
}

/* DB
MariaDB [studydb]> select * from x_board;
+----------+----------+----------+---------------------+------------+
| board_id | title    | contents | created_date        | view_count |
+----------+----------+----------+---------------------+------------+
|        1 | 제목1    | 내용     | 2022-09-06 10:23:39 |          0 |
|        2 | 제목2    | 내용     | 2022-09-06 10:23:39 |          0 |
|        3 | 제목3    | 내용     | 2022-09-06 10:29:28 |          1 |
|        4 | 제목4    | 내용     | 2022-09-06 10:23:39 |          0 |
|        5 | 제목5    | 내용     | 2022-09-06 10:23:39 |          0 |
|        6 | 제목6    | 내용     | 2022-09-06 10:23:39 |          0 |
|        7 | 제목10   | 내용     | 2022-09-06 10:36:35 |          0 |
|        8 | 제목11   | 내용     | 2022-09-06 10:39:51 |          0 |
+----------+----------+----------+---------------------+------------+
8 rows in set (0.002 sec)
----출력값---
8, 제목11, 내용, 2022-09-06, 0
7, 제목10, 내용, 2022-09-06, 0
6, 제목6, 내용, 2022-09-06, 0
5, 제목5, 내용, 2022-09-06, 0
4, 제목4, 내용, 2022-09-06, 0
3, 제목3, 내용, 2022-09-06, 1
2, 제목2, 내용, 2022-09-06, 0
1, 제목1, 내용, 2022-09-06, 0
*/

