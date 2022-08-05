package com.eomcs.design_pattern.iterator.ctest.after1;

public class ArrayListInterator<E> implements Iterator<E> {

  ArrayList<E> list;
  int index = 0;

  public ArrayListIterator(ArrayList<E> list) {
    this.list = list;
  }

  @Override
  public boolean hasNext() {
    return index < list.size();
  }

  @Override
  public E next() {
    return list.get(index++);
  }

}
