/*
 * 게시글 메뉴 처리 클래스
 */

package com.bitcamp.board;

public class BoardHandler {

  static int boardCount = 0;

  static final int SIZE = 5;

  static int[] no = new int[SIZE];
  static String[] title = new String[SIZE];
  static String[] content = new String[SIZE];
  static String[] writer = new String[SIZE];
  static String[] password = new String[SIZE];
  static int[] viewCount = new int[SIZE];
  static long[] createDate = new long[SIZE];

  //게시글 목록을 처리하는 코드
  static void processList() {
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
  static void processDetail() {
    System.out.println("[게시글 상세보기]");

    int boardNo = Prompt.inputInt("조회할 게시글 번호?");

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
  static void processInput() {
    System.out.println("[게시글 등록]");

    if (boardCount == SIZE) {
      System.out.println("게시글을 더이상 저장할 수 없습니다.");
      System.out.println();
      return;
    }

    title[boardCount] = Prompt.inputString("제목? ");
    content[boardCount] = Prompt.inputString("내용? ");
    writer[boardCount] = Prompt.inputString("작성자? ");
    password[boardCount] = Prompt.inputString("암호? ");

    no[boardCount] = boardCount == 0 ? 1 : no[boardCount - 1] + 1;

    viewCount[boardCount] = 0;
    createDate[boardCount] = System.currentTimeMillis();
    boardCount++;
  }
} //BoardHandler
