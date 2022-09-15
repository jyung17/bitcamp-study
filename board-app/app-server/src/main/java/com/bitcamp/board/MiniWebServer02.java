package com.bitcamp.board;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

// 1) 기본 웹 서버 만들기
// 2) 한글 콘텐트 응답하기
//
public class MiniWebServer02 {

  public static void main(String[] args) throws Exception {

    class MyhttpHandler implements HttpHandler {
      @Override
      public void handle(HttpExchange exchange) throws IOException {
        System.out.println("클라이언트가 요청함!");

        String response = "ABCabc123가각";
        byte[] bytes = response.getBytes("UTF-8");

        // 보내는 콘텐트의 MIME 타입이 무엇인지 응답 헤더에 설정한다.
        Headers responseHeaders = exchange.getResponseHeaders();
        responseHeaders.add("Content-Type", "text/plain; charset=UTF-8");

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
