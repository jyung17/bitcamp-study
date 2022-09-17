package com.bitcamp.jong;

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

    Set<Class<?>> servlets = reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
    System.out.println(servlets);

    for (Class<?> servlet : servlets) {
      // 서블릿 클래스의 붙은 WebServelt 애노테이션으로부터 path를 꺼낸다.
      String servletPath = servlet.getAnnotation(WebServlet.class).value();
      System.out.println("servletPath: " + servletPath);

      // 생성자의 파라미터의 타입을 알아내, 해당 객체를 주입한다.
      Constructor<?> constructor = servlet.getConstructors()[0];
      System.out.println("constructor: " + constructor);
      System.out.println(constructor.getParameters());
      Parameter[] params = constructor.getParameters();
      System.out.println("params: " + params);
      System.out.println(params[0].getType() == Const.class);
      servletMap.put(servletPath, constructor.newInstance(constt));
    }

    System.out.println(servletMap);
  }
}
