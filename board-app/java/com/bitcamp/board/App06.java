/*
 * 게시판 관리 애플리케이션
 * 비트캠프 20220704
 */

// 1. javac
// javac -d app/bin/main/ app/src/main/java/com/bitcamp/board/App.java
// javac 명령어와 -d 옵션을 사용해서 app/bin/min 경로에 App.java를 컴파일하여 App.class파일을 생성
// 2. gradle classes -> 프로젝트와 종속된 모든 프로젝트들을 조립하고 테스트(컴파일)
// java -cp app/bin/main/ com.bitcamp.board.App
// 3. ./run.sh

package com.bitcamp.board;

// import java.util.Scanner;

public class App06 {

  static int boardCount = 0;

  static final int SIZE = 5;

  static int[] no = new int[SIZE];
  static String[] title = new String[SIZE];
  static String[] content = new String[SIZE];
  static String[] writer = new String[SIZE];
  static String[] password = new String[SIZE];
  static int[] viewCount = new int[SIZE];
  static long[] createDate = new long[SIZE];

  static java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

  public static void main(String[] args) {
    welcome();

    loop:while (true) {
      displayMenu();

      int menuNo = promptMenu();

      displayLine();

      switch (menuNo) {
        case 0:
          break loop;
        case 1:
          processBoardList();
          break;
        case 2:
          processBoardDetail();
          break;
        case 3:
          processBoardInput();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
      displayBlankLine();
      /*       if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        processBoardList();
      } else if (menuNo == 2) {
        processBoardDetail();
      } else if (menuNo == 3) {
        processBoardInput();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }
      System.out.println(); */
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  } //main

  //프로그램 환영 메시지 출력 코드
  static void welcome() {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();
  }

  //게시글 목록을 처리하는 코드
  static void processBoardList() {
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
      "yyyy-MM-dd"
    );

    System.out.println("[게시글 목록]");
    System.out.println("번호 제목 조회수 작성자 등록일");

    for (int i = 0; i < boardCount; i++) {
      java.util.Date date = new java.util.Date(createDate[i]);
      String dateStr = formatter.format(date);
      System.out.printf(
        "%d\t%s\t%d\t%s\t%s\n",
        no[i],
        title[i],
        viewCount[i],
        writer[i],
        dateStr
      );
    }
  }

  //게시글 상세보기를 처리하는 코드
  static void processBoardDetail() {
    System.out.println("[게시글 상세보기]");

    System.out.println("조회할 게시글 번호? ");
    String input = keyboardInput.nextLine();
    int boardNo = Integer.parseInt(input);

    int boardIndex = -1;

    for (int i = 0; i < boardCount; i++) {
      if (no[i] == boardNo) {
        boardIndex = i;
        break;
      }
    }

    if (boardIndex == -1) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      System.out.println();
      return; //continu(반복문으로 돌아감) -> return(메서드로 변경해서 반복문으로 돌아가려고 return을 사용하면 호출한 쪽(반복문)으로 되돌아감)
    }

    System.out.printf("번호: %d\n", no[boardIndex]);
    System.out.printf("제목: %s\n", title[boardIndex]);
    System.out.printf("내용: %s\n", content[boardIndex]);
    System.out.printf("조회수: %d\n", viewCount[boardIndex]);
    System.out.printf("작성자: %s\n", writer[boardIndex]);

    java.util.Date date = new java.util.Date(createDate[boardIndex]);

    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", date);
  }

  //게시글 입력을 처리하는 코드
  static void processBoardInput() {
    System.out.println("[게시글 등록]");

    if (boardCount == SIZE) {
      System.out.println("게시글을 더이상 저장할 수 없습니다.");
      System.out.println();
      return;
    }

    System.out.print("제목? ");
    title[boardCount] = keyboardInput.nextLine();
    System.out.print("내용? ");
    content[boardCount] = keyboardInput.nextLine();
    System.out.print("작성자? ");
    writer[boardCount] = keyboardInput.nextLine();
    System.out.print("암호? ");
    password[boardCount] = keyboardInput.nextLine();

    no[boardCount] = boardCount == 0 ? 1 : no[boardCount - 1] + 1;

    viewCount[boardCount] = 0;
    createDate[boardCount] = System.currentTimeMillis();
    boardCount++;
  }

  //메뉴를 출력하는 코드
  static void displayMenu() {
    System.out.println("메뉴:");
    System.out.println("  1: 게시글 목록");
    System.out.println("  2: 게시글 상세보기");
    System.out.println("  3: 게시글 등록");
    System.out.println();
    System.out.print("메뉴를 선택하세요[1..3](0: 종료) ");
  }

  //메뉴 번호 조건 검사 코드
  static void displayLine() {
    System.out.println("-----------------------------------");
  }

  // 메서드를 통해 특정 코드의 복잡함을 감출 수 있다. ==> encapsulation(캡슐화)
  static int promptMenu() {
    //방법 1:
    /*  
    String input = keyboardInput.nextLine();
    int menuNo = Integer.parseInt(input);
    return menuNo; 
*/
    //방법 2:
    int menuNo = keyboardInput.nextInt();
    keyboardInput.nextLine();
    return menuNo;
  }

  //결과 출력 후 빈 라인 출력 코드
  static void displayBlankLine() {
    System.out.println();
  }
} //app
