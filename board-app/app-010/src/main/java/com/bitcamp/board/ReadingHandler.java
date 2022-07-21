/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board;

public class ReadingHandler {

  static int boardCount = 0; // 저장된 게시글의 개수

  static final int DEFAULT_SIZE = 3;

  static Board[] boards = new Board[DEFAULT_SIZE];

  static void excute() {
    while (true) {
      System.out.println("독서록:");
      System.out.println("  1: 목록");
      System.out.println("  2: 상세보기");
      System.out.println("  3: 등록");
      System.out.println("  4: 삭제");
      System.out.println("  5: 변경");

      int menuNo = Prompt.inputInt("메뉴를 선택하세요[1..5](0: 이전) ");

      displayHadeLine();

      switch (menuNo) {
        case 0:
          return;
        case 1:
          ReadingHandler.processList();
          break;
        case 2:
          ReadingHandler.processDetail();
          break;
        case 3:
          ReadingHandler.processInput();
          break;
        case 4:
          ReadingHandler.processDelete();
          break;
        case 5:
          ReadingHandler.processUpdate();
          break;
        default:
          System.out.println("메뉴 번호가 옳지 않습니다.");
      }
      displayBlankLine();
    }
  }

  // 메뉴 번호 조건 검사 코드
  static void displayHadeLine() {
    System.out.println("-----------------------------------");
  }

  // 결과 출력 후 빈 라인 출력 코드
  static void displayBlankLine() {
    System.out.println();
  }

  static void processList() {
    // 날짜 정보에서 값을 추출하여 특정 포맷의 문자열로 만들어줄 도구를 준비
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

    System.out.println("[독서록 목록]");
    System.out.println("번호 제목 조회수 작성자 등록일");

    for (int i = 0; i < boardCount; i++) {
      Board board = boards[i];
      // 밀리초 데이터 ==> Date 도구함으로 날짜 정보를 설정
      java.util.Date date = new java.util.Date(board.createdDate);

      // 날짜 정보 ==> "yyyy-MM-dd" 형식의 문자열
      String dateStr = formatter.format(date);

      System.out.printf("%d\t%s\t%d\t%s\t%s\n", board.no, board.title, board.viewCount,
          board.writer, dateStr);
    }
  }

  static void processDetail() {
    System.out.println("[독서록 상세보기]");

    int boardNo = Prompt.inputInt("조회할 번호? ");

    // 해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    Board board = null;
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        board = boards[i];
        break;
      }
    }

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (board == null) {
      System.out.println("해당 번호의 독서록이 없습니다!");
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("작성자: %s\n", board.writer);
    java.util.Date date = new java.util.Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
  }

  static void processInput() {
    System.out.println("[독서록 등록]");

    Board board = new Board();
    // 배열의 크기를 초과하지 않았는지 검사한다
    if (boardCount == boards.length) {
      //새로 만들 배열의 크기를 계산한다.
      int newSize = boards.length + (boards.length >> 1);
      // 새 배열 준비
      Board[] newArray = new Board[newSize];
      // 기존 배열의 값을 새 배열에 넣는다.
      for (int i = 0; i < boards.length; i++) {
        newArray[i] = boards[i];
      }
      // 기존 배열(주소)을 버리고 새 배열(주소)을 사용한다.
      boards = newArray;
      //      return;
    }

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.password = Prompt.inputString("암호? ");

    board.no = boardCount == 0 ? 1 : boards[boardCount - 1].no + 1;

    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis();

    boards[boardCount] = board;

    boardCount++;

    System.out.println("독서록을 등록했습니다.");
  }

  static void processDelete() {
    System.out.println("[독서록 삭제]");

    int boardNo = Prompt.inputInt("삭제할 독서록 번호? ");
    int boardIndex = -1;
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        boardIndex = i;
        break;
      }
    }

    for (int i = boardIndex + 1; i < boardCount; i++) {
      boards[i - 1] = boards[i];
    }
    // boardCount--;
    boards[--boardCount] = null;

    if (boardIndex == -1) {
      System.out.println("해당 번호의 독서록이 없습니다.!");
      return;
    }
  }

  static void processUpdate() {
    System.out.println("[독서록 변경]");
    int boardNo = Prompt.inputInt("변경할 독서록 번호");

    // 변경할 게시글 번호 잘못 입력시 함수 빠져나가기 위해 사용하지 않는 -1로 초기화
    int boardIndex = -1;
    for (int i = 0; i < boardCount; i++) {
      if (boards[i].no == boardNo) {
        boardIndex = i;
      }
    }

    if (boardIndex == -1) {
      System.out.println("해당 번호의 독서록이 없습니다.!");
      return;
    }

    System.out.printf("제목?(%s)", boards[boardIndex].title);
    String updateTitle = Prompt.inputString();
    System.out.printf("내용?(%s)", boards[boardIndex].content);
    String updateContent = Prompt.inputString();
    String updateYN = Prompt.inputString("변경하시겠습니까?(y/n) : ");

    // ==은 주소값을 비교하므로 euals메서드들 사용하여 문자열 내용을 비교
    if ("y".equals(updateYN)) {
      boards[boardIndex].title = updateTitle;
      boards[boardIndex].content = updateContent;
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }
  }
}
