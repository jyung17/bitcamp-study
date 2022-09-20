package com.bitcamp.young;

import static org.reflections.scanners.Scanners.TypesAnnotated;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import com.bitcamp.servlet.annotation.WebServlet;

public class Test {

  public static void main(String[] args) throws Exception {
    // TODO Auto-generated method stub
    Reflections reflections = new Reflections("com.bitcamp.young");
    //System.out.println(reflections);

    // 지정된 패키지에서 @WebServlet 애노테이션이 붙은 클래스를 모두 찾는다.
    // 검색필터 1) WebServlet 애노테이션이 붙어 있는 클래스의 이름들을 모두 찾아라!
    //    QueryFunction<Store, String> servlet1 = TypesAnnotated.with(WebServlet.class);
    //    System.out.println(servlet1);
    //
    //    // 검색필터 2) 찾은 클래스 이름을 가지고 클래스를 Method Area 영역에 로딩하여
    //    //             Class 객체 목록을 리턴하라!
    //    QueryFunction<Store, Class<?>> servlet2 = servlet1.asClass();
    //    System.out.println(servlet2);
    //
    //    // 위의 두 검색 조건으로 클래스를 찾는다.
    //    Set<Class<?>> servlet3 = reflections.get(servlet2);
    //    System.out.println(servlet3);

    Map<String, Object> serveltMap = new HashMap<>();

    BoardDao boardDao = null;

    // /A -> new A(boardDao)
    Set<Class<?>> servlets = reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
    System.out.println(servlets);

    for (Class<?> servlet : servlets) {
      String servletPath = servlet.getAnnotation(WebServlet.class).value();
      System.out.println(servletPath);
      Constructor<?> constructor = servlet.getConstructors()[0];
      System.out.println(constructor);
      Parameter[] params = constructor.getParameters();
      serveltMap.put(servletPath, constructor.newInstance(boardDao));
    }
  }
}
