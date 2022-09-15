package com.bitcamp.board;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import com.bitcamp.board.handler.WelcomeHandler;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// 1) 기본 웹 서버 만들기
// 2) 한글 콘텐트 응답하기
// 3) HTML 콘텐트를 출력하기
// 4) 메인 화면을 출력하는 요청처리 객체를 분리하기
public class MiniWebServer04 {

  public static void main(String[] args) throws Exception {

    class MyhttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함!");
        URI requestUri = exchange.getRequestURI();
        //        System.out.println("getScheme(): " + requestUri.getScheme());
        //        System.out.println("getHost(): " + requestUri.getHost());
        //        System.out.println("getPort(): " + requestUri.getPort());
        //        System.out.println("getPath(): " + requestUri.getPath()); // /board/list -> resource path
        //        System.out.println("getQuery(): " + requestUri.getQuery()); // ?no=2&name=ok -> queryString
        String path = requestUri.getPath();

        WelcomeHandler welcomeHandler = new WelcomeHandler();

        byte[] bytes = null;

        try (StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter)) {

          if (path.equals("/")) {
            welcomeHandler.service(printWriter);
          } else {

          }

          bytes = stringWriter.toString().getBytes("UTF-8");
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
}