package com.bitcamp.board.servlet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import servlet.Servlet;

public class BoardServlet implements Servlet {

  public BoardServlet(String dataName) {
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
