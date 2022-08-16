/*
 * 게시글 메뉴 처리 클래스
 */
package com.bitcamp.board.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import servlet.Servlet;

public class BoardServlet implements Servlet {

  //  // 게시글 목록을 관리할 객체 준비
  //  private BoardDao boardDao;

  public BoardServlet(String dataName) {
    //    // 수퍼 클래스의 생성자를 호출할 때 메뉴 목록을 전달한다.
    //    super(new String[] {"목록", "상세보기", "등록", "삭제", "변경"});
    //
    //    boardDao = new BoardDao(filename);
    //
    //    try {
    //      boardDao.load();
    //    } catch (Exception e) {
    //      System.out.printf("%s 파일 로딩 중 오류 발생!\n", filename);
    //      //      e.printStackTrace();
    //    }
  }

  @Override
  public void service(DataInputStream in, DataOutputStream out) {
    try {
      String command = in.readUTF();

      switch (command) {
        case "findAll":
          out.writeUTF("success");
          break;
        case "findByNo":
          out.writeUTF("success");
          break;
        case "insert":
          out.writeUTF("success");
          break;
        case "update":
          out.writeUTF("success");
          break;
        case "delete":
          out.writeUTF("success");
          break;
        default:
          out.writeUTF("fail");
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}


