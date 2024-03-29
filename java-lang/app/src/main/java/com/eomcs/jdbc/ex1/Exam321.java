// JDBC 프로그래밍 - DBMS에 SQL문 보내기 : select
package com.eomcs.jdbc.ex1;

import java.sql.DriverManager;

public class Exam321 {

  public static void main(String[] args) throws Exception {
    try (
        java.sql.Connection con = DriverManager
            .getConnection("jdbc:mariadb://localhost:3306/studydb?user=study&password=1111");
        java.sql.Statement stmt = con.createStatement();

        java.sql.ResultSet rs = stmt.executeQuery("select * from x_board order by board_id desc");

    ) {

      System.out.println(rs.getClass().getName());

      // ResultSet 객체를 사용하여 
      // select의 실행 결과 중에서 한 레코드(row)를 서버에서 가져온다.
      //
      boolean isReceived = rs.next(); // 가져왔으면 true, 가져올 게 없다면 false
      // 용어정리
      // "레코드(record)"
      // => select를 실행한 후 생성된 결과이다.
      //

      if (isReceived) {
        // 서버에서 한 개 가져온 결과를 출력한다.
        System.out.printf("%s, %s, %s, %s, %s\n", //
            rs.getString(1), // board_id
            rs.getString(2), // title
            rs.getString(3), // contents
            rs.getString(4), // created_date
            rs.getString(5)); // view_count
        // getString(컬럼번호):
        // => DBMS에 설정된 컬럼의 값을 문자열로 리턴한다.
        // => select 문에 나열한 컬럼의 순서를 지정한다.
        //    단 번호는 0부터가 아니라 1부터 지정한다.
        // => select 문에 wildcard(*)를 사용했다면,
        //    테이블을 정의할 때 선언한 컬럼의 순서이다.
      } else {
        System.out.println("서버에서 한 개의 레코드를 가져오지 못했다!");
      }
    }
  }
}


