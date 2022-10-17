package com.bitcamp.board.config;

import javax.servlet.Filter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

public class AdminWebApplicationInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null; // Root IoC의 설정은 다른 쪽에서 했기때문에 여기서 설정하지 않음.
    // Root IoC의 설정 공유함.
  }

  @Override
  protected String getServletName() {
    return "admin";
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    return new Class<?>[] {AdminAppWebConfig.class};
  }

  @Override
  protected String[] getServletMappings() {
    return new String[] {"/admin/*"};
  }

  @Override
  protected Filter[] getServletFilters() {
    return new Filter[] {new CharacterEncodingFilter("UTF-8"), new LoginCheckFilter(),
        new AdminCheckFilter()};
  }
}
