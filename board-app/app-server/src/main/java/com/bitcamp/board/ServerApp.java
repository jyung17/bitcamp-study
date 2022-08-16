package com.bitcamp.board;

import com.bitcamp.board.servlet.BoardServlet;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

  public static void main(String[] args) {
    System.out.println("[게시글 데이터 관리 서버]");

    try (
        ServerSocket serverSocket = new ServerSocket(8888);) {

      System.out.println("서버 소켓 준비 완료!");

      try (Socket socket = serverSocket.accept();
          DataInputStream in = new DataInputStream(socket.getInputStream());
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

        System.out.println("클라이언트와 연결 되었음!");

        BoardServlet boardServlet = new BoardServlet("board");
        BoardServlet readingServlet = new BoardServlet("reading");
        BoardServlet visitServlet = new BoardServlet("visit");
        BoardServlet noticeServlet = new BoardServlet("notice");
        BoardServlet dailyServlet = new BoardServlet("daily");

        while (true) {
          String dataName = in.readUTF();

          if (dataName.equals("exit")) {
            break;
          }

          switch (dataName) {
            case "board":
              boardServlet.service(in, out);
              break;
            case "reading":
              readingServlet.service(in, out);
              break;
            case "visit":
              visitServlet.service(in, out);
              break;
            case "notice":
              noticeServlet.service(in, out);
              break;
            case "daily":
              dailyServlet.service(in, out);
              break;
            default:
              out.writeUTF("fail");
          }
        }

        System.out.println("클라이언트와 연결을 끊었음!");
      } // 안쪽 try
    } catch (Exception e) {
      e.printStackTrace();
    } // 바깥 쪽 Try

    System.out.println("서버 종료!");
  }
}
