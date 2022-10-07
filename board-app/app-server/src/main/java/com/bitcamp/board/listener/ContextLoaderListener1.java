package com.bitcamp.board.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import com.bitcamp.servlet.DispathcerServlet;

// 웹 애플리케이션이 시작되었을 때 공유할 자원을 준비시키거나 해제하는 일을 한다.
// @WebListener
public class ContextLoaderListener1 implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유 자원을 준비 중!!");

    try {
      ServletContext ctx = sce.getServletContext();

      // 자바 코드로 서블릿 객체를 직접 생성하여 서버에 등록하기
      DispathcerServlet servlet = new DispathcerServlet();
      Dynamic config = ctx.addServlet("DispathcerServlet", servlet);
      config.addMapping("/service/*");
      System.out.println("자바 코드로 서블릿 객체를 직접 생성");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
