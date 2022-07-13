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

public class App04 {

  public static void main(String[] args) {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다!");
    System.out.println();

    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

    int number = 0;
    String title = "";
    String content = "";
    String writer = "";
    String password = "";
    int viewCount = 0;
    long createDate = 0;

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

      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        System.out.println("[게시글 목록]");
        System.out.println("번호 제목 조회수 작성자 등록일");

        System.out.print(1);
        System.out.print("\t");
        System.out.print("제목입니다1");
        System.out.print('\t');
        System.out.print(20 + "\t");
        System.out.print("홍길동\t");
        System.out.print("2022-07-08\r\n");

        System.out.print(
          2 + "\t" + "제목입니다2\t" + 11 + "\t" + "홍길동\t" + "2022-07-08\n"
        );

        System.out.println(
          3 + "\t제목입니다3\t" + 31 + "\t" + "임꺽정\t2022-07-08"
        );

        System.out.printf(
          "%d\t%s\t%d\t%s\t%s\n",
          4,
          "제목입니다4",
          45,
          "유관순",
          "2022-07-08"
        );
      } else if (menuNo == 2) {
        viewCount++;
        System.out.println("[게시글 상세보기]");

        System.out.printf("번호: %d\n", number);
        System.out.printf("제목: %s\n", title);
        System.out.printf("내용: %s\n", content);
        System.out.printf("조회수: %d\n", viewCount);
        System.out.printf("작성자: %s\n", writer);

        // Date 도구함의 도구를 쓸 수 있도록 데이터를 준비시킨다.
        // new Date(밀리초)
        //    => 지정한 밀리초를 가지고 날짜 관련 도구를 사용할 수 있도록 설정한다.
        java.util.Date date = new java.util.Date(createDate);

        // Date 도구함을 통해 설정한 정보를 가지고 printf()를 실행한다.
        // %tY : date에 설정된 날짜 정보에서 년도만 추출한다.
        System.out.printf("등록일: %tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS\n", date);
      } else if (menuNo == 3) {
        System.out.println("[게시글 등록]");
        System.out.print("제목? ");
        title = keyboardInput.nextLine();
        System.out.print("내용? ");
        content = keyboardInput.nextLine();
        System.out.print("작성자? ");
        writer = keyboardInput.nextLine();
        System.out.print("암호? ");
        password = keyboardInput.nextLine();

        number++;
        viewCount = 0;
        createDate = System.currentTimeMillis();
      } else {
        System.out.println("메뉴 번호가 옳지 않습니다!");
      }

      System.out.println();
    } // while

    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  }
}
