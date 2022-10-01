package com.bitcamp.board.domain;

public class AttachedFile {
  private int no;
  private String filepath;


  public AttachedFile() {}

  public AttachedFile(String filepahth) {
    this.filepath = filepahth;
  }

  @Override
  public String toString() {
    return "AttachedFile [no=" + no + ", filepath=" + filepath + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getFilepath() {
    return filepath;
  }

  public void setFilepath(String filepath) {
    this.filepath = filepath;
  }


}
