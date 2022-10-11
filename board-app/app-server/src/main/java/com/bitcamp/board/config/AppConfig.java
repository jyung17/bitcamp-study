package com.bitcamp.board.config;

import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

// 스프링 IoC 컨테이너의 설정을 수행하는 클래스
// 1) DB 커넥션 객체 관리자 준비 : DataSource
// 2) 트랜잭션 관리자 준비 : PlaqtformTransactionManager
// 3) 어떤패키지의 있는 객체를 자동으로 생성할 것인지 지정한다.
@ComponentScan(value = "com.bitcamp.board")
// - com.bitcamp.board 패키지 및 그 하위 패키지에 소속된 클래스 중에서
//   @Component, @Controller, @Service, @Repository 등의 애노테이션이 붙은 클래스를 찾아
//   객체를 생성한다.
public class AppConfig {

  public AppConfig() {
    System.out.println("1) AppConfig() 생성자 호출됨!");
  }

  // DataSource를 생성하는 메서드를 호출하라고 표시한다.
  // 메서드가 리턴한 객체는 @Bean 애노테이션에 지정된 이름으로 컨테이너에 보관될 것이다.
  @Bean
  public DataSource createDataSource() {
    System.out.println("2) createDataSource() 호출됨!");

    DriverManagerDataSource ds = new DriverManagerDataSource();
    ds.setDriverClassName("org.mariadb.jdbc.Driver");
    ds.setUrl("jdbc:mariadb://localhost:3306/studydb");
    ds.setUsername("study");
    ds.setPassword("1111");
    return ds;
    //객체가 리턴한 값을 transactionManager라는 이름으로 저장한다.
  }

  @Bean("transactionManager")
  public PlatformTransactionManager createTransactionManager(DataSource ds) {
    // Spring IoC 컨테이너는 이 메서드를 호출하기 전에 
    // 이 메서드가 원하는 파라미터 값인 DataSource를 먼저 생성한다.
    // => createDataSource() 메서드를 먼저 호출한다.
    System.out.println("3) createTransactionManager() 호출됨!");
    return new DataSourceTransactionManager(ds);
  }
}
