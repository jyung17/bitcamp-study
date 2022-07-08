/*
 * 게시판 관리 애플리케이션
 * 비트캠프 20220704
 */

package com.bitcamp.board;

// import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    System.out.println("[게시판 애플리케이션]");
    System.out.println();
    System.out.println("환영합니다.");
    System.out.println();
    java.util.Scanner keyboardInput = new java.util.Scanner(System.in);

    while (true) {
      System.out.println("메뉴:");
      System.out.println("  1: 게시글 목록");
      System.out.println("  2: 게시글 상세보기");
      System.out.println();
      System.out.print("메뉴를 선택하세요[1..2](0: 종료) ");

      int menuNo = keyboardInput.nextInt(); // 여러번 받으려고 하면 한번 받고 엔터가 남아있어서 에러남
      keyboardInput.nextLine(); // 입력한 숫자 뒤에 남아 있는 줄바꿈 코드 제거

      System.out.println("==> " + menuNo);

      if (menuNo == 0) {
        break;
      } else if (menuNo == 1) {
        BoardListApp.main(args);

        // System.out.println("[게시글 목록]");
        // System.out.println("번호\t제목\t조회수\t작성자\t등록일");
        // System.out.print(1);
        // System.out.print("\t");
        // System.out.print("제목입니다1");
        // System.out.print("\t");
        // System.out.print(20 + "\t");
        // System.out.print("홍길동\t");
        // System.out.print("2022-07-08\r\n");

        // System.out.println(2 + "\t" + "제목입니다2\t"
        // + 11 + "\t" + "홍길동\t" + "2022-07-08");

        // System.out.println(2 + "\t" + "제목입니다3\t"
        // + 22 + "\t" + "홍길동\t" + "2022-07-08");

        // System.out.printf("%d\t%s\t%d\t%s\t%s\n", 4, "제목입니다", 33, "유관순",
        // "2022-07-08");

      } else if (menuNo == 2) {
        System.out.println("게시글 상세보기");
        BoardDetailApp.main(args);

        // System.out.println("[게시판 상세보기]");
        // System.out.printf("번호: %d\n", 1);
        // System.out.printf("제목: %s\n", "제목입니다1.");
        // System.out.printf("내용: %s\n", "내용입니다1.");
        // System.out.printf("조회수: %s\n", 100);
        // System.out.printf("작성자: %s\n", "홍길동");
        // System.out.printf("등록일: %s\n", "2022-07-08");

      } else {
        System.out.println("메뉴 번호가 옳지 않습니다.");
      }

      if (menuNo < 1 || menuNo > 2) {
        System.out.println("1에서 2사이의 메뉴 번호를 입력하세요.: ");
        // menuNo = keyboardInput.nextInt();
      } else {
        System.out.println("메뉴 번호 ==> " + menuNo);
      }
    } // while
    System.out.println("안녕히 가세요!");
    keyboardInput.close();
  }
}
