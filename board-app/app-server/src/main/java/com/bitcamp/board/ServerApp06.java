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
// 3) 스레드를 이용하여 여러 클라이언트를 동시 접속 처리
// 4) 클라이언트가 보낸 요청 값을 받아서 그대로 돌려준다.
// 5) 요청/응답을 무한 반복한다.
// 6) quit 명령을 보내면 연결 끊기

public class ServerApp06 {

  // breadcrumb 메뉴를 저장할 스택을 준비
  public static Stack<String> breadcrumbMenu = new Stack<>();

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8888)) {

      System.out.println("서버 실행 중...");

      while (true) {
        Socket socket = serverSocket.accept();

        new Thread(() -> {
          try (DataOutputStream out = new DataOutputStream(socket.getOutputStream());
              DataInputStream in = new DataInputStream(socket.getInputStream())) {
            System.out.println("클라이언트 접속!");

            StringWriter strOut = new StringWriter();
            PrintWriter tempOut = new PrintWriter(strOut);

            welcome(tempOut);
            out.writeUTF(strOut.toString());

            while (true) {
              String request = in.readUTF();
              if (request.equals("quit")) {
                break;
              }
              out.writeUTF(request);
            }

            System.out.println("클라이언트와 접속 종료!");

          } catch (Exception e) {
            System.out.println("클라이언트와 통신하는 중 오류 발생!");
            e.printStackTrace();
          }
        }).start();
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
