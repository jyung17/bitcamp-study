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

public class App05 {

  public static void main(String[] args) {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();

    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

    final int SIZE = 5;
    int[] no = new int[SIZE];
    String[] title = new String[SIZE];
    String[] content = new String[SIZE];
    String[] writer = new String[SIZE];
    String[] password = new String[SIZE];
    int[] viewCount = new int[SIZE];
    long[] createDate = new long[SIZE];

    int boardCount = 0; // 저장된 게시글의 개수를 담는 변수

    while (true) {
      System.out.println("메뉴:");
      System.out.println("  1: 게시글 목록");
      System.out.println("  2: 게시글 상세보기");
      System.out.println("  3: 게시글 등록");
      System.out.println();
      System.out.print("메뉴를 선택하세요[1..3](0: 종료) ");

      int menuNo = keyboardInput.nextInt();
      keyboardInput.nextLine(); // 입력한 숫자 뒤에 남아 있는 줄바꿈 코드 제거
      System.out.println();

      System.out.println("-----------------------------------");
      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        System.out.println("[게시글 목록]");
        System.out.println("번호 제목 조회수 작성자 등록일");

        // 날짜 정보에서 값을 추출하여 특정 포맷의 문자열로 만들어줄 도구를 준비
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat(
          "yyyy-MM-dd"
        );
        int i = 0;
        while (i < boardCount) {
          // 밀리초 데이터 ==> Date 도구함으로 날짜 정보를 설정
          java.util.Date date = new java.util.Date(createDate[i]);
          // 날짜 정보 ==> "yyyyMM-dd" 형식의 문자열
          String dateStr = formatter.format(date);
          System.out.printf(
            "%d\t%s\t%d\t%s\t%s\n",
            no[i],
            title[i],
            viewCount[i],
            writer[i],
            dateStr
          );
          i++;
        }
      } else if (menuNo == 2) {
        //viewCount[boardCount] += 1;
        System.out.println("[게시글 상세보기]");

        System.out.println("조회할 게시글 번호? ");
        String input = keyboardInput.nextLine();
        int boardNo = Integer.parseInt(input);

        // 해당 번호의 게시글이 몇 번 배열에 들어 있는지 알아내기
        int boardIndex = -1;
        int i = 0;
        while (i < boardCount) {
          if (no[i] == boardNo) {
            boardIndex = i;
            break;
          }
          i++;
        }

        // 사용자가 입력한 번호에 해당하는 게시글을 못 찾았다면,
        if (boardIndex == -1) {
          System.out.println("해당 번호의 게시글이 없습니다!");
          System.out.println();
          continue;
        }

        System.out.printf("번호: %d\n", no[boardIndex]);
        System.out.printf("제목: %s\n", title[boardIndex]);
        System.out.printf("내용: %s\n", content[boardIndex]);
        System.out.printf("조회수: %d\n", viewCount[boardIndex]);
        System.out.printf("작성자: %s\n", writer[boardIndex]);

        // Date 도구함의 도구를 쓸 수 있도록 데이터를 준비시킨다.
        // new Date(밀리초)
        //    => 지정한 밀리초를 가지고 날짜 관련 도구를 사용할 수 있도록 설정한다.
        java.util.Date date = new java.util.Date(createDate[boardIndex]);

        // Date 도구함을 통해 설정한 정보를 가지고 printf()를 실행한다.
        // %tY : date에 설정된 날짜 정보에서 년도만 추출한다.
        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", date);
      } else if (menuNo == 3) {
        System.out.println("[게시글 등록]");

        //배열의 크기를 초과하지 않았는지 검사한다.
        if (boardCount == SIZE) {
          System.out.println("게시글을 더이상 저장할 수 없습니다.");
          System.out.println();
          continue;
        }

        System.out.print("제목? ");
        title[boardCount] = keyboardInput.nextLine();
        System.out.print("내용? ");
        content[boardCount] = keyboardInput.nextLine();
        System.out.print("작성자? ");
        writer[boardCount] = keyboardInput.nextLine();
        System.out.print("암호? ");
        password[boardCount] = keyboardInput.nextLine();

        // if (boardCount == 0) {
        //   no[boardCount] = 1;
        // } else {
        //   no[boardCount] = no[boardCount - 1] + 1;
        // }

        no[boardCount] = boardCount == 0 ? 1 : no[boardCount - 1] + 1;

        viewCount[boardCount] = 0;
        createDate[boardCount] = System.currentTimeMillis();
        boardCount++;
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      System.out.println();
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  }
}
