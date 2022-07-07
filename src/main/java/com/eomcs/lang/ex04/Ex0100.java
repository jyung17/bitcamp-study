package com.eomcs.lang.ex04;

public class Ex0100 {
    public static void main(String[] args) {
        int i;
    }
}


/*
# 변수(Variables)
- 값을 저장하는 메모리

# 변수 선언
- 값을 저장하는 메모리를 준비하는 명령이다.
- 값을 저장할 메모리의 조율와 크기를 결정하고 그 메모리에 이름을 부여한다.
- 변수를 선언한 후 바로 그 이름을 사용하여 메모리에 접근하고 값을 넣고 꺼낸다.
- 보통 "변수를 생성한다"라고 표현하기도 한다.
- 문법
메모리의 종류 메모리이름;
데이터 타입 변수;
int a;

```java
public class Exam0100 {
    public static void main(String[] args) {
        int a;
    }
}
```

- int : 값을 저장할 메모리의 종류. '데이터 타입(data type; 자료형)'이라 부른다.
- a : 메모리를 가리키는 이름. '변수(variables)'라 부른다.

의미
- 정수 값을 담을 메모리를 준비하고 그 메모리의 이름을 a 라고 하자.

## 변수의 이름
- 보통 소문자로 시작한다.
- 대소문자를 구분한다.
- 여러 단어로 구성된 경우 두 번째 단어의 시작 알파벳은 대문자로 한다.
- 예) fistName, createdDate, userId
- 상수인 경우 보통 모두 대문자로 이름을 짓는다. 단어와 단어 사이는 _를 사용한다.
- 예) USER_TYPE, USER_MANAGER

# 한 문장에서 여러 개의 변수를 선언하기
- 한 문장으로 같은 유형의 변수를 여러 개 선언할 수 있다.
- 문법
  데이터타입 변수1, 변수2, 변수3;


한 번에 한 개씩 변수를 선언할 수 있고, 콤마(,)를 사용하여 여러 개의 변수를 한 번에 선언할 수 있다.
```java
public class Exam0120 {
    public static void main(String[] args) {
        int i1;
        int i2;
        int i3;

        int j1, j2, j3;
    }
}
```

# 변수에 값 할당
- 변수가 가리키는 메모리에 값을 저장하는 것
- 문법
    변수명 = 변수 또는 리터럴;
- 용어
    = : 할당 연산자(assignment operator)
    l-value : = 왼쪽에 있는 변수를 가리킨다. l-value는 리터럴이 될 수 없다.
    r-value : = 오른쪽에 있는 변수나 리터럴을 가리킨다.
- 의미
    = 오른쪽에 지정된 값을 왼쪽 변수가 가리키는 메모리에 저장.

```java
public class Exam0130 {
    public static void main(Stirng[] args) {
        int age;
        age = 20;
    }
}
```
표현
- age 변수가 가리키는 메모리에 20을 저장하라!
- age라는 이름의 메모리에 20을 저장하라!
- age 변수에 20을 저장하라!
- age에 20을 저장하라!(실무에서는 주로 이 표현을 사용한다)

# 변수 선언과 값 할당을 동시에 하기
- 변수와 동시에 값을 즉시 저장할 수 잇다.
- 문법
    데이터타입 변수명 = 값;

```java
public class Exam0140 {
    public static void main(String[] args){
        int age = 20;
    }
}
```
변수 선언 + 값 저장
- 이렇게 변수 선언과 값 저장을 한 번에 하는 것을 '변수 초기화 문장'이라 부른다.

# 여러 개의 변수를 한 번에 선언하고 초기화도 함께 수행하기

```java
public class Exam0150 {
    public static coid main(String[] args) {
        //여러 개의 변수를 선언할 때도 한 개를 선언할 때와 마찬가지로 값을 저장할 수 있다.
        int a = 100, a = 200;
    }
}
```


*/