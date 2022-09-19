package com.bitcamp.jong;

import static org.reflections.scanners.Scanners.TypesAnnotated;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.WebServlet;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Test {

  public static void main(String[] args) throws Exception {
    Reflections reflections = new Reflections("com.bitcamp.jong");

    Map<String, Object> servletMap = new HashMap<>();

    Const constt = new Const();
    //    QueryFunction<Store, String> fileter1 = TypesAnnotated.with(WebServlet.class);
    //    System.out.println("servlets: " + fileter1);
    //
    //    QueryFunction<Store, Class<?>> fileter2 = fileter1.asClass();
    //    System.out.println("servlets2: " + fileter2);
    //
    //    Set<Class<?>> servlets3 = reflections.get(fileter2);
    //    System.out.println("servlets3: " + servlets3);

    Set<Class<?>> servletsClassInfoList =
        reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
    System.out.println("servlets: " + servletsClassInfoList);


    for (Class<?> servletClassInfo : servletsClassInfoList) {
      // 서블릿 클래스의 붙은 WebServelt 애노테이션으로부터 path를 꺼낸다.
      String servletPath = servletClassInfo.getAnnotation(WebServlet.class).value();
      System.out.println("servletPath: " + servletPath);

      // 생성자의 파라미터의 타입을 알아내, 해당 객체를 주입한다.
      // 
      Constructor<?> constructor = servletClassInfo.getConstructors()[0];
      System.out.println("constructor: " + constructor);
      System.out.println(constructor.getParameters());
      Parameter[] params = constructor.getParameters();
      System.out.println("params: " + params);
      System.out.println("params[0].getType(): " + params[0].getType());
      System.out.println(params[0].getType() == Const.class);
      //      servletMap.put(servletPath, constructor.newInstance(constt));
    }
    //
    //    System.out.println(servletMap);
    //
    //    String query = "no=1&title=aaaa&content=bbb";
    //    System.out.println(query.length());
    //
    //    Map<String, String> paramMap = new HashMap<>();
    //    if (query != null && query.length() > 0) { // 예) no=1&title=aaaa&content=bbb
    //      String[] entries = query.split("&");
    //      for (String entry : entries) { // 예) no=1
    //        String[] kv = entry.split("=");
    //        // 웹브라우저가 보낸 파라미터 값은 저장하기 전에 URL 디코딩 한
    //        paramMap.put(kv[0], URLDecoder.decode(kv[1], "UTF-8"));
    //      }
    //
    //      System.out.println(paramMap);
    //
    //      for (String key : paramMap.keySet()) {
    //        System.out.println("key : " + key + " / value : " + paramMap.get(key));
    //      }
    //    }
  }
}
