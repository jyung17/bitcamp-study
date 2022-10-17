package com.bitcamp.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@ComponentScan(value = "com.bitcamp.board.controller.admin")
public class AdminAppWebConfig {

  public AdminAppWebConfig() {
    System.out.println("adminAppWebConfig() 생성자 호출됨!");
  }

  // Spring WebMVC의 기본 ViewResolver를 교체한다.
  @Bean
  public ViewResolver viewResolver() {
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setViewClass(JstlView.class); // 주어진 URL을 처리할 객체 => JSP 실행시킨다.
    viewResolver.setPrefix("/WEB-INF/jsp/"); //
    viewResolver.setSuffix(".jsp");
    return viewResolver;
  }
}
