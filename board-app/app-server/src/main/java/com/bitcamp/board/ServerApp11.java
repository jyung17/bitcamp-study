package com.bitcamp.board;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.bitcamp.board.handler.BoardHandler;
import com.bitcamp.board.handler.MemberHandler;
import com.bitcamp.handler.Handler;
import com.bitcamp.util.BreadCrumb;

// 1) 클라이언트 접속 시 환영 메시지 전송
// 2) 여러 클라이언트를 순차적으로 처리
// 3) 스레드를 이용하여 여러 클라이언트를 동시 접속 처리
// 4) 클라이언트가 보낸 요청 값을 받아서 그대로 돌려준다.
// 5) 요청/응답을 무한 반복한다.
// 6) quit 명령을 보내면 연결 끊기
// 7) 환영 메시지 후에 메인 메뉴를 응답한다.
// 8) 사용자가 선택한 메뉴 번호의 유효성을 검증한다.
// 9) 메인 메뉴 선태에 따라 핸들러를 실행하여 클라이언트에게 하위 메뉴를 출력한다.
// - Handler 인터페이스 변경
// - AbstractHandler 추상 클래스의 execute() 변경
// 10) Breadcrumb 기능을 객체로 분리한다.
// - BreadCrum 클래스를 정의한다.
// 11) 코드 리팩토링
// - execute() 메서드 정의: main() 메서드의 코드를

public class ServerApp11 {

  // 메인 메뉴 목록 준비
  private String[] menus = {"게시판", "회원"};
  private int port;
  ArrayList<Handler> handlers = new ArrayList<>();

  // extract mthod 자주 사용되는코드 반복적으로 사용되는 코드 주석을 부터야하는 코드
  // 차라리 뺴서 별도 메서드로 구현하는게 유지보수하는거에 좋다.
  public static void main(String[] args) {
    ServerApp11 app = new ServerApp11(8888);
    app.execute();
  }

  public ServerApp11(int port) {
    this.port = port;
    handlers.add(new BoardHandler(null));
    handlers.add(new MemberHandler(null));
  }

  public void execute() {
    try (ServerSocket serverSocket = new ServerSocket(this.port)) {

      System.out.println("서버 실행 중...");

      while (true) {
        new Thread(new ServiceProcessor(serverSocket.accept())).start();
        System.out.println("클라이언트 접속!");
        // 클라이언트 연결을 기다리고있다가 연결되는 순간
        // socket을 리턴하면 그 socket을 가지고 serviceprocessor를 만든 이후에
        // new Thread에 주면 ServiceProcessor을 별도의 스레드로 실행한다. .start();      

        // -> serverSocket.accept()
        //      -> new ServiceProcessor(serverSocket.accept())
        //          -> new Thread(new ServiceProcessor(serverSocket.accept())).start();
      }
    } catch (Exception e) {
      System.out.println("서버 실행 중 오류 발생!");
      e.printStackTrace();
    }
  }

  /*
    public static void main2(String[] args) {
      try (// DAO가 사용할 커넥션 객체 준비
          Connection con =
              DriverManager.getConnection("jdbc:mariadb://localhost:3306/studydb", "study", "1111")) {
        System.out.println("[게시글 관리 클라이언트]");
  
        welcome();
  
        // DAO 객체를 준비한다.
        MariaDBBoardDao boardDao = new MariaDBBoardDao(con);
        MariaDBMemberDao memberDao = new MariaDBMemberDao(con);
  
  
        // "메인" 메뉴의 이름을 스택에 등록한다.
        breadcrumbMenu.push("메인");
  
        // 메뉴명을 저장할 배열을 준비한다.
        
  
        loop: while (true) {
  
          printTitle();
          printMenus(menus);
          System.out.println();
  
          try {
            
  
            // 메뉴에 진입할 때 breadcrumb 메뉴바에 그 메뉴를 등록한다.
            breadcrumbMenu.push(menus[mainMenuNo - 1]);
  
  
            breadcrumbMenu.pop();
  
          } catch (Exception ex) {
            System.out.println("입력 값이 옳지 않습니다.");
          }
  
        } // while
        Prompt.close();
  
        System.out.println("종료!");
      } catch (Exception e) {
        System.out.println("시스템 오류 발생!");
        e.printStackTrace();
      }
    }
  */

  //인스턴스에서 인스턴스 맴버를 사용하지않으면 인스턴스로 만들 필요가없다 -> static
  static void welcome(DataOutputStream out) throws Exception {
    try (StringWriter strOut = new StringWriter(); PrintWriter tempOut = new PrintWriter(strOut);) {
      tempOut.println("[게시판 애플리케이션]");
      tempOut.println();
      tempOut.println("환영합니다!");
      tempOut.println();
      out.writeUTF(strOut.toString());
    }
  }

  static void error(DataOutputStream out, Exception e) throws Exception {
    try (StringWriter strOut = new StringWriter(); PrintWriter tempOut = new PrintWriter(strOut);) {
      tempOut.printf("실행 오류:%s\n", e.getMessage());
      out.writeUTF(strOut.toString());
    } catch (Exception e2) {
      e.printStackTrace();
    }
  }

  private void printMainMenus(DataOutputStream out) throws Exception {
    try (StringWriter strOut = new StringWriter(); PrintWriter tempOut = new PrintWriter(strOut)) {

      for (int i = 0; i < menus.length; i++) {
        // 인스턴스 맴버, 같은 인스턴스맴버끼리는 인스턴스 변수를 사용할 수 있다.
        tempOut.printf("  %d: %s\n", i + 1, menus[i]);
      }
      tempOut.printf("메뉴를 선택하세요[1..%d](quit: 종료) ", menus.length);
      out.writeUTF(strOut.toString());
    }
  }


  // Main Menu처리
  void processMainMenu(DataInputStream in, DataOutputStream out, String request) throws Exception {
    try {
      int menuNo = Integer.parseInt(request);
      if (menuNo < 1 || menuNo > menus.length) {
        throw new Exception("메뉴 번호가 옳지 않습니다.");
      }
      BreadCrumb breadcrumb = BreadCrumb.getBreadCrumbOfCurrentThread();
      breadcrumb.put(menus[menuNo - 1]);
      handlers.get(menuNo - 1).execute(in, out);
      breadcrumb.pickUp();

    } catch (Exception e) {
      error(out, e);
    }
  }

  private class ServiceProcessor implements Runnable {

    Socket socket;
    // 람다문법으로 들어갔는데 왜 클래스로 뽑냐
    // -> 사이즈가 작을때는 람다로 소스코드가 커지니까 (계층이 들여쓰기 시작되면서 복잡해짐, 간단해야하는데 복잡해짐)
    // -> 이런경우는 람다 문법으로 적절하지 않음
    // 람다 문멉은 코드가 짧고 직관적일때 사용하기 좋다.
    // 문법은 상황에 맞게(이점이 사라질수 있음)

    public ServiceProcessor(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (Socket s = this.socket; // -> 위의 Socket socket은 인스턴스 변수이므로 close 되지 않음 그래서 새로 생성함.
          DataOutputStream out = new DataOutputStream(s.getOutputStream());
          DataInputStream in = new DataInputStream(s.getInputStream())) {

        // 접속한 클라이언트의 이동 경로를 보관할 breacrumb 객체 준
        BreadCrumb breadcrumb = new BreadCrumb(); // 현재 스레드 보관소에 저장된다.
        breadcrumb.put("메인");

        // 클라이언트에게 환영 메시지를 보낸다.
        welcome(out);

        while (true) {
          // 클라이언트가 요청 정보를 읽는다.
          String request = in.readUTF();
          if (request.equals("quit")) {
            break;
          } else if (request.equals("menu")) { // 클라이언트에게 응답한다.
            printMainMenus(out);
          } else {
            processMainMenu(in, out, request);
          }
        }
        System.out.println("클라이언트와 접속 종료!");

      } catch (Exception e) {
        System.out.println("클라이언트와 통신하는 중 오류 발생!");
        e.printStackTrace();
      }
    }

  }
}
