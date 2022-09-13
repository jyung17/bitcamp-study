package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

// 1) 클라이언트 접속 시 환영 메시지 전송
// 2) 여러 클라이언트를 순차적으로 처리
public class ServerApp02 {

  // breadcrumb 메뉴를 저장할 스택을 준비
  public static Stack<String> breadcrumbMenu = new Stack<>();

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("서버 실행 중...");

      while (true) {
        try (Socket socket = serverSocket.accept();
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream())) {
          System.out.println("클라이언트 접속!");

          StringWriter strOut = new StringWriter();
          PrintWriter tempOut = new PrintWriter(strOut);

          welcome(tempOut);

          // 클라이언트로 출력하기
          out.writeUTF(strOut.toString());

          System.out.println("클라이언트에게 응답!");

        } catch (Exception e) {
          System.out.println("클라이언트와 통신하는 중 오류 발생!");
          e.printStackTrace();
        }
      }

      //      System.out.println("서버 종료!");
    } catch (Exception e) {
      System.out.println("서버 실행 중 오류 발생!");
      e.printStackTrace();
    }
  }

  static void welcome(PrintWriter out) throws Exception {
    out.println("[게시판 애플리케이션]");
    out.println();
    out.println("환영합니다!");
    out.println();
  }

  static void printMenus(String[] menus) {
    for (int i = 0; i < menus.length; i++) {
      System.out.printf("  %d: %s\n", i + 1, menus[i]);
    }
  }

  protected static void printTitle() {
    StringBuilder builder = new StringBuilder();
    for (String title : breadcrumbMenu) {
      if (!builder.isEmpty()) {
        builder.append(" > ");
      }
      builder.append(title);
    }
    System.out.printf("%s:\n", builder.toString());
  }
}
