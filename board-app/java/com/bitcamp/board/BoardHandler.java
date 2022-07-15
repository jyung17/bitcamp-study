/*
 * 게시글 메뉴 처리 클래스
 */

package com.bitcamp.board;

public class BoardHandler {

  static int boardCount = 0;

  static final int SIZE = 5;

  // Board 인스턴스의 주소를 저장할 레퍼런스 배열을 만든다.
  static Board[] boards = new Board[SIZE];

  // 게시글 목록을 처리하는 코드
  static void processList() {
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

    System.out.println("[게시글 목록]");
    System.out.println("번호 제목 조회수 작성자 등록일");

    for (int i = 0; i < boardCount; i++) {
      Board board = boards[i];

      java.util.Date date = new java.util.Date(board.createdDate);
      String dateStr = formatter.format(date);
      System.out.printf("%d\t%s\t%d\t%s\t%s\n", board.no, board.title, board.viewCount,
          board.writer, dateStr);
    }
  }

  // 게시글 상세보기를 처리하는 코드
  static void processDetail() {
    System.out.println("[게시글 상세보기]");

    int boardNo = Prompt.inputInt("조회할 게시글 번호?");

    Board board = null;

    for (int i = 0; i < boardCount; i++) {
      board = boards[i];
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;
      }
    }

    if (board == null) {
      System.out.println("해당 번호의 게시글이 없습니다!");
      System.out.println();
      return; // continu(반복문으로 돌아감) -> return(메서드로 변경해서 반복문으로 돌아가려고 return을 사용하면 호출한 쪽(반복문)으로 되돌아감)
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("작성자: %s\n", board.writer);

    java.util.Date date = new java.util.Date(board.createdDate);

    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", date);
  }

  // 게시글 입력을 처리하는 코드
  static void processInput() {
    System.out.println("[게시글 등록]");

    if (boardCount == SIZE) {
      System.out.println("게시글을 더이상 저장할 수 없습니다.");
      System.out.println();
      return;
    }

    Board board = new Board();

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.password = Prompt.inputString("암호? ");

    board.no = boardCount == 0 ? 1 : boards[boardCount - 1].no + 1;

    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis();

    // 새로 만든 인스턴스 주소를 레퍼런스 배열에 저장한다.
    boards[boardCount] = board;


    boardCount++;
  }
} // BoardHandler
