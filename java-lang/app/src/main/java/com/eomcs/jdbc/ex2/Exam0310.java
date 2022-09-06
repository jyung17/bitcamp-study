package com.eomcs.jdbc.ex2;

import java.util.Scanner;

public class Exam0310 {
  public static void main(String[] args) {
    Board board = new Board();

    try (Scanner keyScan = new Scanner(System.in)) {
      System.out.println("제목? ");
      board.setTitle(keyScan.nextLine());

      System.out.print("내용? ");
      board.setContent(keyScan.nextLine());

      System.out.print("입력하시겠습니까?(Y/n) ");
      String input = keyScan.nextLine();

      if (!input.equalsIgnoreCase("y") && input.length() != 0) {
        System.out.println("등록을 취소 하였습니다.");
        return;
      }
    }

  }
}
