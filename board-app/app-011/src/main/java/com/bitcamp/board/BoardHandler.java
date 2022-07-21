/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board;

import java.util.Date;

public class BoardHandler {
  // 모든 게시판이 공유하는 데이터는 클래스 변수에 저장한다.
  // 왜? 클래스 변수는 클래스를 로딩할 때 한 번만 생성되기 때문이다.
  static final int DEFAULT_SIZE = 3;
  // 각 게시판이 별도로 관리해야 할 데이터는 인스턴스 변수로 선언한다.
  // 왜? 인스턴스 변수는 게시판 별로 생성할 수 있기 때문이다.

  int boardCount; // 저장된 게시글의 개수
  Board[] boards;
  String title = "";

  // 클래스 생성자가 정의되어 있지 않으면
  // 다음과 같이 파라미터가 없는 기본 생성자를 컴파일러가 자동으로 추가 된다.
  // 기본 생성자 ?
  // - 파라미터가 없다.
  // - 메서드 몸체는 비어 있다.
  // - 메서드의 접근 범위는 무조건 공개(public)이다.
  public BoardHandler() {
    this.boards = new Board[DEFAULT_SIZE];
    this.title = "게시판";
  }

  // 제목을 입력 받는 생성자
  public BoardHandler(String title) {
    this.boards = new Board[DEFAULT_SIZE];
    this.title = title;
  }

  // 배열의 기본 크기를 설정하는 생성자
  public BoardHandler(int initSize) {
    this.boards = new Board[initSize];
    this.title = "게시판";
  }

  // 제목과 배열의 기본 크기 설정 값을 입력 받는 생성자
  public BoardHandler(String title, int initSize) {
    this.boards = new Board[initSize];
    this.title = title;
  }

  void excute() {
    // App 클래스에서 이 메서드를 호출할 때 BoardHandler의 인스턴스 주소를 줄 것이다.
    // 그 주소는 this 라는 내장 변수에 보관될 것이다.
    while (true) {
      System.out.printf("%s:\n", this.title);
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
          this.onList();
          break;
        case 2:
          this.onDetail();
          break;
        case 3:
          this.onInput();
          break;
        case 4:
          this.onDelete();
          break;
        case 5:
          this.onUpdate();
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

  void onList() {
    // 인스턴스 메서드는 호출될 때 넘겨 받은 인스턴스 주소를 this라는 내장 변수에 보관한다.
    // 날짜 정보에서 값을 추출하여 특정 포맷의 문자열로 만들어줄 도구를 준비
    java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");

    System.out.printf("[%s 목록]\n", this.title);
    System.out.println("번호 제목 조회수 작성자 등록일");

    for (int i = 0; i < this.boardCount; i++) {
      Board board = this.boards[i];

      Date date = new Date(board.createdDate);

      String dateStr = formatter.format(date);

      System.out.printf("%d\t%s\t%d\t%s\t%s\n", board.no, board.title, board.viewCount,
          board.writer, dateStr);
    }
  }

  void onDetail() {
    System.out.printf("[%s 상세보기]\n", this.title);

    int boardNo = Prompt.inputInt("조회할 " + this.title + " 번호? ");

    // 해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
    Board board = null;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        board = this.boards[i];
        break;
      }
    }

    // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면
    if (board == null) {
      System.out.printf("해당 번호의 %s이 없습니다!\n", this.title);
      return;
    }

    System.out.printf("번호: %d\n", board.no);
    System.out.printf("제목: %s\n", board.title);
    System.out.printf("내용: %s\n", board.content);
    System.out.printf("조회수: %d\n", board.viewCount);
    System.out.printf("작성자: %s\n", board.writer);
    Date date = new Date(board.createdDate);
    System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM\n", date);
  }

  void onInput() {
    System.out.printf("[%s 등록]\n", this.title);

    Board board = new Board();
    // 배열의 크기를 초과하지 않았는지 검사한다 
    // -> 배열의 크기를 초과하면 배열의 크기를 50% 증가시킨다.
    if (boardCount == this.boards.length) {
      //새로 만들 배열의 크기를 계산한다.
      int newSize = this.boards.length + (this.boards.length >> 1);
      // 새 배열 준비
      Board[] newArray = new Board[newSize];
      // 기존 배열의 값을 새 배열에 넣는다.
      for (int i = 0; i < this.boards.length; i++) {
        newArray[i] = this.boards[i];
      }
      // 기존 배열(주소)을 버리고 새 배열(주소)을 사용한다.
      this.boards = newArray;
      //      return;
      System.out.println("배열 크기 변경 완료");
    }

    board.title = Prompt.inputString("제목? ");
    board.content = Prompt.inputString("내용? ");
    board.writer = Prompt.inputString("작성자? ");
    board.password = Prompt.inputString("암호? ");

    board.no = this.boardCount == 0 ? 1 : this.boards[this.boardCount - 1].no + 1;

    board.viewCount = 0;
    board.createdDate = System.currentTimeMillis();

    this.boards[this.boardCount] = board;

    this.boardCount++;

    System.out.printf("%s을 등록했습니다.\n", this.title);
  }

  void onDelete() {
    System.out.printf("[%s 삭제]\n", this.title);

    int boardNo = Prompt.inputInt("삭제할 " + this.title + " 번호? ");
    int boardIndex = -1;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        boardIndex = i;
        break;
      }
    }

    for (int i = boardIndex + 1; i < this.boardCount; i++) {
      this.boards[i - 1] = this.boards[i];
    }
    // boardCount--;
    this.boards[--boardCount] = null;

    if (boardIndex == -1) {
      System.out.printf("해당 번호의 %s이 없습니다.!\n", this.title);
      return;
    }
  }

  void onUpdate() {
    System.out.printf("[%s 변경]\n", this.title);
    int boardNo = Prompt.inputInt("변경할 " + this.title + " 번호");

    // 변경할 게시글 번호 잘못 입력시 함수 빠져나가기 위해 사용하지 않는 -1로 초기화
    int boardIndex = -1;
    for (int i = 0; i < this.boardCount; i++) {
      if (this.boards[i].no == boardNo) {
        boardIndex = i;
      }
    }

    if (boardIndex == -1) {
      System.out.printf("해당 번호의 %s이 없습니다.!\n", this.title);
      return;
    }

    System.out.printf("제목?(%s)", this.boards[boardIndex].title);
    String updateTitle = Prompt.inputString();
    System.out.printf("내용?(%s)", this.boards[boardIndex].content);
    String updateContent = Prompt.inputString();
    String updateYN = Prompt.inputString("변경하시겠습니까?(y/n) : ");

    // ==은 주소값을 비교하므로 euals메서드들 사용하여 문자열 내용을 비교
    if ("y".equals(updateYN)) {
      this.boards[boardIndex].title = updateTitle;
      this.boards[boardIndex].content = updateContent;
      System.out.println("변경했습니다.");
    } else {
      System.out.println("변경 취소했습니다.");
    }
  }
}
