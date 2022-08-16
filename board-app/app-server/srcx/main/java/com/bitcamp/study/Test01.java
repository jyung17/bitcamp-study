package com.bitcamp.study;

import com.bitcamp.board.domain.Board;
import com.bitcamp.board.domain.Member;
import com.google.gson.Gson;

public class Test01 {

  public static void main(String[] args) {
    Board b = new Board();
    b.no = 100;
    b.title = "제목입니다.";
    b.content = "내용입니다.";
    b.writer = "홍길동";
    b.password = "1111";
    b.createdDate = System.currentTimeMillis();

    // Object --> JSON 문자열
    Gson gson = new Gson();
    String json = gson.toJson(b);
    System.out.println(json);

    Board b2 = gson.fromJson(json, Board.class);
    System.out.println(b2);
    System.out.println(b == b2);

    Member m = new Member();
    m.no = 200;
    m.name = "홍길동";
    m.email = "Test@Gmail.com";
    m.password = "1111";
    m.createdDate = System.currentTimeMillis();

    Gson gson1 = new Gson();
//    String j
  }
}
