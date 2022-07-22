/*
 * 게시판 관리 애플리케이션 비트캠프 20220704
 */

// 1. javac
// javac -d app/bin/main/ app/src/main/java/com/bitcamp/board/App.java
// javac 명령어와 -d 옵션을 사용해서 app/bin/min 경로에 App.java를 컴파일하여 App.class파일을 생성
// 2. gradle classes -> 프로젝트와 종속된 모든 프로젝트들을 조립하고 테스트(컴파일)
// java -cp app/bin/main/ com.bitcamp.board.App
// 3. ./run.sh

package com.bitcamp.board;

// import java.util.Scanner;

public class App {

  public static void main(String[] args) {
    welcome();
    // 생성자는 인스턴스를 사용하기 전에 유용한 값으로 설정하게 만드는 아주 특별한 메소드이다 

    // 인스턴스를 생성할 때 생성자가 원하는 값을 반드시 줘야 한다.
    // 주지 않으면 컴파일 오류이다.!
    BoardHandler boardHandler = new BoardHandler();
    BoardHandler readingHandler = new BoardHandler("독서록");
    BoardHandler visitHandler = new BoardHandler("박명록");
    BoardHandler noticeHandler = new BoardHandler("공지사항");
    BoardHandler diaryHandler = new BoardHandler("일기장", 5);


    loop: while (true) {

      System.out.println("메뉴:");
      System.out.println("  1: 게시판");
      System.out.println("  2: 독서록");
      System.out.println("  3: 방명록");
      System.out.println("  4: 공지사항");
      System.out.println("  5: 일기장");
      int displayMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 종료) ");

      // 다른 인스턴스 메서드를 호출할 때 this에 보관된 인스턴스 주소를 사용한다.
      switch (displayMenuNo) {
        case 0:
          break loop;
        case 1:
          boardHandler.execute();
          break;
        case 2:
          readingHandler.execute();
          break;
        case 3:
          visitHandler.execute();
          break;
        case 4:
          noticeHandler.execute();
          break;
        case 5:
          diaryHandler.execute();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
    } // while
    System.out.println("안녕히 가세요!");
    Prompt.close();
  } // main

  // 프로그램 환영 메시지 출력 코드
  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }



} // app
