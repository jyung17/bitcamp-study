/*
 * 게시판 관리 애플리케이션 비트캠프 20220704
 */

// 1. javac
// javac -d app/bin/main/ app/src/main/java/com/bitcamp/board/App.java
// javac 명령어와 -d 옵션을 사용해서 app/bin/min 경로에 App.java를 컴파일하여 App.class파일을 생성
// 2. gradle classes -> 프로젝트와 종속된 모든 프로젝트들을 조립하고 테스트(컴파일)
// java -cp app/bin/main/ com.bitcamp.board.App
// 3. ./run.sh

// 1) 게시판 메뉴 구조 변경
// 2) onBoardMenu() 메서드 추가
// - displayMenu() 메서드 제거 : onBoardMenu()로 코드를 옮긴다.
// - App02로 백업

package com.bitcamp.board;

// import java.util.Scanner;

public class App02 {

  public static void main(String[] args) {
    welcome();

    loop: while (true) {

      // 메인 메뉴 출력
      System.out.println("메뉴:");
      System.out.println("  1: 게시판");
      System.out.println("  2: 독서록");
      System.out.println("  3: 박명록");
      System.out.println("  4: 공지사항");
      System.out.println();
      int mainMenuNo = Prompt.inputInt("메뉴를 선택하세요[1..4](0: 종료) ");

      switch (mainMenuNo) {
        case 0:
          break loop;
        case 1: // 게시판
          onBoardMenu();
          break;
        case 2: // 독서록
          break;
        case 3: // 방명록
          break;
        case 4: // 공지사항
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      } // switch_mainMenuNo
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

  // 메뉴 번호 조건 검사 코드
  static void displayLine() {
    System.out.println("=================================");
  }

  // 결과 출력 후 빈 라인 출력 코드
  static void displayBlankLine() {
    System.out.println();
  }


  static void onBoardMenu() {
    while (true) {
      displayLine();
      System.out.println("메뉴:");
      System.out.println("  1: 목록");
      System.out.println("  2: 상세보기");
      System.out.println("  3: 등록");
      System.out.println("  4: 삭제");
      System.out.println("  5: 변경");
      System.out.println();

      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");
      displayLine();

      switch (menuNo) {
        case 0:
          return;
        case 1:
          BoardHandler.processList();
          break;
        case 2:
          BoardHandler.processDetail();
          break;
        case 3:
          BoardHandler.processInput();
          break;
        case 4:
          BoardHandler.processDelete();
          break;
        case 5:
          BoardHandler.processUpdate();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
      displayBlankLine();
    } // 게시판 while
  }

} // app
