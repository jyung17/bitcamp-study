package com.bitcamp.board;

import static org.reflections.scanners.Scanners.TypesAnnotated;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.reflections.Reflections;
import com.bitcamp.board.dao.BoardDao;
import com.bitcamp.board.dao.MariaDBBoardDao;
import com.bitcamp.board.dao.MariaDBMemberDao;
import com.bitcamp.board.dao.MemberDao;
import com.bitcamp.board.handler.ErrorHandler;
import com.bitcamp.servlet.Servlet;
import com.bitcamp.servlet.annotation.Repository;
import com.bitcamp.servlet.annotation.WebServlet;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class MiniWebServer {

  //  public static void main(String[] args) throws Exception {
  //    // 클래스를 찾아주는 도구를 준비
  //    Reflections reflections = new Reflections("com.bitcamp.board");
  //
  //    // 지정된 패키지에서 @WebServlet 애노테이션이 붙은 클래스를 모두 찾는다.
  //    // 검색필터 1) WebServlet 애노테이션이 붙어 있는 클래스의 이름들을 모두 찾아라
  //    //    QueryFunction<Store, String> 검색필터1 = TypesAnnotated.with(WebServlet.class);
  //    // 검색필터 2) 찾은 클래스 이름을 가지고 클래스를 로딩하여 Method Area 영역에 로딩하여
  //    //            Class 객체 목록을 리턴하라!
  //    //    QueryFunction<Store, Class<?>> 검색필터2 = 검색필터1.asClass();
  //    // 위의 두 검색 조건으로 클래스를 찾는다.
  //    //    Set<Class<?>> 서블릿클래스들 = reflections.get(검색필터2);
  //
  //    Set<Class<?>> servlets = reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
  //    for (Class<?> servlet : servlets) {
  //      WebServlet anno = servlet.getAnnotation(WebServlet.class);
  //      System.out.printf("%s ---> %s\n", anno.value(), servlet.getName());
  //    }
  //  }

  public static void main(String[] args) throws Exception {
    Connection con =
        DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111");
    //
    //    BoardDao boardDao = new MariaDBBoardDao(con);
    //    MemberDao memberDao = new MariaDBMemberDao(con);

    // 객체(Dao, 서블릿)를 보관할 맵을 준비
    Map<String, Object> objMap = new HashMap<>();

    // DAO 객체를 찾아 맵에 보관한다.
    Reflections reflections = new Reflections("com.bitcamp.board"); // "com" com하위패키지에서 확인
    Set<Class<?>> classes = reflections.get(TypesAnnotated.with(Repository.class).asClass());
    for (Class<?> clazz : classes) {
      String objNmae = clazz.getAnnotation(Repository.class).value();
      Constructor<?> constructor = clazz.getConstructor(Connection.class);
      objMap.put(objNmae, constructor.newInstance(con));
    }
    //
    //    // DAO 객체를 맵에 보관한다.
    //    objMap.put("boardDao", boardDao);
    //    objMap.put("memberDao", memberDao);

    // WebServlet 애노테이션이 붙은 클래스를 찾아 객체를 생성한 후 맵에 저장한다.
    // 맵에 저장할 때 사용할 key는 WebServlet 애노테이션에 설정된 값이다.
    Set<Class<?>> servlets = reflections.get(TypesAnnotated.with(WebServlet.class).asClass());
    // TypesAnnotated 클래스와 인터페이스 타입을 찾는다. 애노테이션도 타입으로 봄? -> 컴파일을 하면 다 클래스로 구분됨
    for (Class<?> servlet : servlets) {
      // 서블릿 클래스의 붙은 WebServelt 애노테이션으로부터 path를 꺼낸다.
      String servletPath = servlet.getAnnotation(WebServlet.class).value();

      // 생성자의 파라미터의 타입을 알아내, 해당 객체를 주입한다.
      Constructor<?> constructor = servlet.getConstructors()[0];
      Parameter[] params = constructor.getParameters();

      if (params.length == 0) { // 생성자의 파라미터가 없다면, 즉 기본 생성자라면
        objMap.put(servletPath, constructor.newInstance());
        System.out.println(servlet.getName());
      } else { // 생성자의 파라미터가 있다면,
        // 그 파라미터 타입과 일치하는 객체를 찾는다.
        Object argument = findObject(objMap, params[0].getType());
        if (argument != null) { // 생성자의 파라미터 타입과 일치하는 객체를 찾았다면
          objMap.put(servletPath, constructor.newInstance(argument));
        }
      }
    }

    Servlet errorHandler = new ErrorHandler();

    class MyhttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함!");
        URI requestUri = exchange.getRequestURI();

        String path = requestUri.getPath();
        //String query = requestUri.getQuery(); // 디코딩을 제대로 수행하지 못한다.!
        String query = requestUri.getRawQuery();

        byte[] bytes = null;

        try (StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter)) {

          Map<String, String> paramMap = new HashMap<>();
          if (query != null && query.length() > 0) { // 예) no=1&title=aaaa&content=bbb
            String[] entries = query.split("&");
            for (String entry : entries) { // 예) no=1
              String[] kv = entry.split("=");
              // 웹브라우저가 보낸 파라미터 값은 저장하기 전에 URL 디코딩 한
              paramMap.put(kv[0], URLDecoder.decode(kv[1], "UTF-8"));
            }
          }

          System.out.println(requestUri);
          System.out.println(query);
          System.out.println(paramMap);

          Servlet servlet = (Servlet) objMap.get(path);

          if (servlet != null) {
            servlet.service(paramMap, printWriter);
          } else {
            errorHandler.service(paramMap, printWriter);
          }

          bytes = stringWriter.toString().getBytes("UTF-8");
        } catch (Exception e) {
          bytes = "요청 처리 중 오류 발생!".getBytes("UTF-8");
          e.printStackTrace(); // 서버 콘솔 창에 오류에 대한 자세한 내용을 출력한다.
        }

        // 보내는 콘텐트의 MIME 타입이 무엇인지 응답 헤더에 설정한다.
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "text/html; charset=UTF-8");

        exchange.sendResponseHeaders(200, bytes.length);

        OutputStream out = exchange.getResponseBody();

        out.write(bytes);
        out.close();
      }
    }

    HttpServer server = HttpServer.create(new InetSocketAddress(8888), 0); // 팩토리 메서드 패턴
    server.createContext("/", new MyhttpHandler());
    server.setExecutor(null);
    server.start();
    System.out.println("서버 시작!");
  }

  private static Object findObject(Map<String, Object> objMap, Class<?> type) {
    // 맵에 들어 있는 객체를 모두 꺼낸다.
    Collection<Object> values = objMap.values();

    // 꺼낸 객체들 중에 해당 타입의 인스턴스가 있는지 알아 본다.
    for (Object value : values) {
      if (type.isInstance(value)) { // 주어진 찾으려는 타입과 일치하는 객체를 찾았다면
        return value; // 그 객체를 리턴한다.
      }
    }
    return null; // 못 찾았으면 null을 리턴한다.
  }
}
