package com.bitcamp.util;

public class LinkedListTest {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    LinkedList list = new LinkedList();
    list.append("홍길동");
    list.append("임꺽정");
    list.append("유관순");
    list.append("안중근");

    //    System.out.println(list.retrieve(-1));
    System.out.println(list.retrieve(0));
    System.out.println(list.retrieve(1));
    System.out.println(list.retrieve(2));
    System.out.println(list.retrieve(3));
    //    System.out.println(list.retrieve(4));

    // 중간 노드 삭제 테스트
    list.delete(2);
    printList(list);

    // 맨 앞 노드 삭제 테스트
    list.delete(0);
    printList(list);

    // 맨 끝 노드 삭제 테스트
    list.delete(1);
    printList(list);

    // 마지막 남은 노드 삭제 테스트
    list.delete(0); // 임꺽정 삭
    printList(list);


    // 완전히 삭제한 다음에 다시 입력할 경우 제대로 동작하는지 테스트
    list.append("홍길동");
    list.append("임꺽정");
    list.append("유관순");
    list.append("안중근");
    printList(list);
  }

  public static void printList(LinkedList list) {
    System.out.println("----------------");
    for (int i = 0; i < list.length(); i++) {
      System.out.println(list.retrieve(i));
    }
  }
}
