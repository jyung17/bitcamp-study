package com.bitcamp.board;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// @Transactional 애노테이션을 사용하여
// 트랜잭션을 제어할 수 있게 기능을 활성화 시킨다.
@EnableTransactionManagement
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    System.out.println("비트캠프 프로젝트!!");
    SpringApplication.run(App.class, args);
  }

  @GetMapping("/")
  public String welcome() {
    return "welcome";
  }
}
