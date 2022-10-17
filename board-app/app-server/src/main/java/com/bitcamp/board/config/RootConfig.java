package com.bitcamp.board.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

@ComponentScan(value = "com.bitcamp.board",
    excludeFilters = @Filter(type = FilterType.REGEX, pattern = "com.bitcamp.board.controller.*"))
// com.bitcamp.board 패키지를 다 찾아서 애노테이션이 붙은 클래스찾아 객체를 생성하는데,
// "com.bitcamp.board.controller.*" 패키지는 제외한다.
// type = FilterType.REGEX : 정규표현식
// "com.bitcamp.board.controller.*"를 패턴으로 만드려면 타입을 FilterType.REGEX로 정해줘야 한다.
public class RootConfig {

  public RootConfig() {
    System.out.println("RootConfig() 생성자 호출됨!");
  }
}
