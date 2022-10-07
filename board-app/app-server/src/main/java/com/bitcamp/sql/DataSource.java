package com.bitcamp.sql;

import java.sql.Connection;
import java.sql.DriverManager;

// 스레드 전용 DB 커넥션을 제공하는 일을 한다.
// DataSource : 커넥션 관리자
public class DataSource {
  String jdbcUrl;
  String username;
  String password;

  // ThreadLocal을 이용하면 쓰레드 영역에 변수를 설정할 수 있기 때문에, 
  // 특정 쓰레드가 실행하는 모든 코드에서 그 쓰레드에 설정된 변수 값을 사용할 수 있게 된다. 

  //스레드 전용 DB 커넥션 보관소
  ThreadLocal<Connection> conStore = new ThreadLocal<>();

  public DataSource(String driver, String jdbcUrl, String username, String password)
      throws Exception {
    // JDBC Driver 클래스 로딩하기
    //  Class.forName("org.mariadb.jdbc.Driver");
    Class.forName(driver);
    this.jdbcUrl = jdbcUrl;
    this.username = username;
    this.password = password;
  }

  //  Connection con =
  //      DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
  public Connection getConnection() throws Exception {
    Thread currThread = Thread.currentThread();
    System.out.printf("%s=> getConnection() 호출\n", currThread.getName());

    // 현재 스레드의 보관소에서 DB 커넥션 객체를 꺼낸다.
    Connection con = conStore.get();
    if (con == null) { // 현재 스레드 보관소에 커넥션 객체가 없다면, 
      con = DriverManager.getConnection(jdbcUrl, username, password); // 새로 생성
      conStore.set(con); // 새로 만든 DB 커넥션 객체를 다음에 다시 사용할 수 있도록 보관한다.
      System.out.printf("%s=> Connection 생성\n", currThread.getName());
    }
    return con;
  }
}
