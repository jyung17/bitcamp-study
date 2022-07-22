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

    loop: while (true) {

      System.out.println("메뉴:");
      System.out.println("  1: 게시판");
      System.out.println("  2: 독서록");
      System.out.println("  3: 방명록");
      System.out.println("  4: 공지사항");
      int displayMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..4](0: 종료) ");

      switch (displayMenuNo) {
        case 0:
          break loop;
        case 1:
          BoardHandler.execute();
          break;
        case 2:
          ReadingHandler.execute();
          break;
        case 3:
          VisitHandler.execute();
          break;
        case 4:
          NoticeHandler.execute();
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
