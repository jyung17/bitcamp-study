package com.bitcamp.board.handler;

import com.bitcamp.handler.AbstractHandler;
import java.io.DataInputStream;
import java.io.DataOutputStream;

public class BoardHandler extends AbstractHandler {

  private String dataName;
  private DataInputStream in;
  private DataOutputStream out;

  public BoardHandler(String dataName, DataInputStream in, DataOutputStream out) {
    super(new String[]{"목록", "상세보기", "등록", "삭제", "변경"});
    this.dataName = dataName;
    this.in = in;
    this.out = out;
  }

  @Override
  public void service(int menuNo) {
    try {
      switch (menuNo) {
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
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onList() {
    try {
      out.writeUTF(dataName);
      out.writeUTF("findAll");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onDetail() {
    try {
      out.writeUTF(dataName);
      out.writeUTF("findByNo");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onInput() throws Exception {
    try {
      out.writeUTF(dataName);
      out.writeUTF("insert");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onDelete() throws Exception {
    try {
      out.writeUTF(dataName);
      out.writeUTF("delete");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private void onUpdate() throws Exception {
    try {
      out.writeUTF(dataName);
      out.writeUTF("update");
      System.out.println(in.readUTF());

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
