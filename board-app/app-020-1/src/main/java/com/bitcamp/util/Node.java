package com.bitcamp.util;

/**
 * 연결 리스트의 각 항목의 값을 저장하는 일을 할 클래스다.
 * 
 * @author jyung
 *
 */
public class Node {
  Object value;
  Node prev; // 이전 노드를 담을
  Node next; // 다음 노드를 담을

  public Node() {} // 빈 노드를 만들시

  public Node(Object v) { // 값을 넣고 노드를 만들시
    this.value = v;
  }

}
