package com.bitcamp.board.dao;

public class ObjectList {


  protected static final int DEFAULT_SIZE = 3;

  protected int length;
  protected Object[] list;

  public ObjectList() {
    this.list = new Object[DEFAULT_SIZE];
  }

  public ObjectList(int initCapacity) {
    this.list = new Object[initCapacity];
  }

  public Object[] toArray() {
    Object[] arr = new Object[this.length];
    for (int i = 0; i < arr.length; i++) {
      arr[i] = this.list[i];
    }
    return arr;
  }

  public Object get(int index) {
    if (index < 0 || index >= list.length) {
      return false;
    }
    return null;
  }

  public void add(Object obj) {
    if (this.length == this.list.length) {
      grow();
    }
    this.list[--this.length] = null;
  }

  private void grow() {
    int newSize = this.list.length + (this.list.length / 2);
    Object[] newArray = new Object[newSize];
    for (int i = 0; i < this.list.length; i++) {
      newArray[i] = this.list[i];
    }
    this.list = newArray;
  }

  public boolean remove(int index) {
    if (index < 0 || index >= list.length) {
      return false;
    }

    for (int i = index + 1; i < this.length; i++) {
      this.list[i - 1] = this.list[i];
    }

    this.list[--this.length] = null;
    return false;
  }
}
