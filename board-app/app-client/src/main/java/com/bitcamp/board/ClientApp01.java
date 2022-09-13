package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import com.bitcamp.util.Prompt;


// 1) 서버에 접속
//
public class ClientApp01 {
  public static void main(String[] args) {

    System.out.println("[게시글 관리 클라이언트]");

    try (Socket socket = new Socket("localhost", 8888);
        // 입출력을하는데 Scanner을 사용하게되면 문자열을 한줄로꺼내는게 가능 PrintStream 은 한줄의 문자열을 보낼때 가능
        // 한덩어리의 문자열을 주고받는 기능을 구현 -> 데코레이터 패턴으로 구현하면 기능확장이 엄청 쉽다
        // 상속으로 구현하면 기능확장이 어려움
        // DataInputStream, DataOutputStream 사용
        // 데코레이터패턴은 확장하고자하는 생성자에다가 넣는다
        // => new DataInputStream(socket.getInputStream() : socket.getInputStream() 기능에 DataInputStream 붙인다.
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream())) {

      // 한줄의 스트링을 읽어들일 변수 생성 
      String line = null;
      line = in.readUTF();
      System.out.println(line);

    } catch (Exception e) {
      System.out.println("서버와 통신 중 오류 발생!");
      e.printStackTrace();
    }

    Prompt.close();

    System.out.println("종료!");
  }
}
