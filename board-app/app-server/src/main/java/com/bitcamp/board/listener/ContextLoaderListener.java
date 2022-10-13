package com.bitcamp.board.listener;

import java.util.EnumSet;
import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import com.bitcamp.board.config.AppConfig;
import com.bitcamp.board.filter.AdminCheckFilter;
import com.bitcamp.board.filter.LoginCheckFilter;

// 웹애플리케이션이 시작되었을 때 공유할 자원을 준비시키거나 해제하는 일을 한다.
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebListener
public class ContextLoaderListener implements ServletContextListener {
  @Override
  public void contextInitialized(ServletContextEvent sce) {
    System.out.println("공유 자원을 준비 중!!");
    try {

      // 웹 기능이 포함된 스프 IoC 컨테이너 준비
      AnnotationConfigWebApplicationContext iocContainer =
          new AnnotationConfigWebApplicationContext();

      iocContainer.register(AppConfig.class);

      //      System.out.println("-------스프링 모든 빈 출력하기-------");
      //      String[] beanDefinitionNames = iocContainer.getBeanDefinitionNames();
      //      for (String beanDefinitionName : beanDefinitionNames) {
      //        Object bean = iocContainer.getBean(beanDefinitionName);
      //        System.out.println("name = " + beanDefinitionName + " object = " + bean);
      //      }
      //      System.out.println("--------------");

      ServletContext ctx = sce.getServletContext();

      // 자바 코드로 서블릿 객체를 직접 생성하여 서버에 등록하기
      DispatcherServlet servlet = new DispatcherServlet(iocContainer);
      Dynamic config = ctx.addServlet("DispatcherServlet", servlet);
      config.addMapping("/service/*");
      config.setMultipartConfig(
          new MultipartConfigElement(this.getClass().getAnnotation(MultipartConfig.class)));
      config.setLoadOnStartup(1);

      // 필터 등록
      CharacterEncodingFilter filter = new CharacterEncodingFilter("UTF-8");
      FilterRegistration.Dynamic filterConfig = ctx.addFilter("CharacterEncodingFilter", filter);
      filterConfig.addMappingForServletNames(
          // CharacterEncodingFilter 이름으로된 filter를 추가해라 
          // FilterRegistration.Dynamic filterConfig 필터를 설정하는 설정객
          // filterConfig.addMappingForServletNames 서블릿 이름으로 필터를 연결
          // 요청이들어올때 DispatcherServlet전에 필터를 실행하려면 false
          // 어떤요청? DispatcherType.REQUEST
          // 서블릿이 있는데 요청이들어오면 그때 꽂는다.
          // 요청이들어왔는데 다른 서블릿이 다른 서블릿으로 FORWARD또는 INCLUDE할때도 필터를 꽂는다.
          EnumSet.of(DispatcherType.REQUEST, DispatcherType.INCLUDE, DispatcherType.FORWARD), false,
          "DispatcherServlet");

      AdminCheckFilter adminFilter = new AdminCheckFilter();
      FilterRegistration.Dynamic adminFilterConfig = ctx.addFilter("AdminCheckFilter", adminFilter);
      adminFilterConfig.addMappingForUrlPatterns(
          EnumSet.of(DispatcherType.REQUEST, DispatcherType.INCLUDE, DispatcherType.FORWARD), false,
          "/service/member/*");

      LoginCheckFilter loginFilter = new LoginCheckFilter();
      FilterRegistration.Dynamic loginFilterConfig = ctx.addFilter("LoginCheckFilter", loginFilter);
      loginFilterConfig.addMappingForUrlPatterns(
          EnumSet.of(DispatcherType.REQUEST, DispatcherType.INCLUDE, DispatcherType.FORWARD), false,
          "/service/*");

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
