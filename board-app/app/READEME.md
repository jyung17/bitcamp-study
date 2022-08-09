# board-app 프로젝트

## 버전

### 001. 프로젝트 준비 - Gradle 빌드 도구를 사용하여 프로젝트 준비하기

- Gradle 빌드 도구를 이용하여 프로젝트 폴더를 준비하는 방법

### 002. 리터럴과 콘솔 출력

- 실행할 수 있는 클래스를 만드는 방법 = main() 엔트리 포인트 이해
- 콘솔 출력 명령문을 작성하는 방법
- 리터럴 문법을 활용하는 방법
- CLI(command line interface) 환경에서 클래스를 실행하는 방법

#### 작업 내용

- 1단계 - 게시글 목록 출력하기
  - com.bitcamp.board.BoardListApp 클래스 추가
- 2단계 - 게시글 상세 보기
  - com.bitcamp.board.BoardDetailApp 클래스 추가

### 003. 키보드 입력과 변수, 조건문, 반복문

- 키보드 입력을 받는 방법
- 변수를 사용해 키보드 입력 값을 저장하는 방법
- 조건문을 사용해 실행을 분기하는 방법
- 비교 연산자를 사용하는 방법
- 반복문을 사용하여 특정 명령 블록을 반복적으로 실행하는 방법
- 반복을 종료하는 방법

#### 작업 내용

- 1단계 - 게시글 목록 및 상세보기 합치기
  - com.bitcamp.board.App 클래스 변경
  - com.bitcamp.board.BoardListApp 클래스 삭제
  - com.bitcamp.board.BoardDetailApp 클래스 삭제

### 004. 변수 사용법

- 게시글을 변수에 입력 받고 변수의 값을 출력하는 방법

#### 작업 내용

- 1단계 - 게시글을 입력 받기
- com.bitcamp.board.App 클래스 변경
  - 게시글 등록 메뉴를 처리하는 조건문 추가
  - 게시글 입력 값을 저장할 변수 추가
- 2단계 - 입력 받은 게시글을 출력하기
- com.bitcamp.board.App 클래스 변경
  - 게시글 상세보기 코드 변경
  - 설정된 날짜 정보에서 년-월-일 시:분 정보 추출하기

### 005. 배열 사용법

- 여러 개의 게시글을 저장하고 꺼내는 방법

#### 작업 내용

- 1단계 - 여러 개의 게시글 입력 받을 때 문제점
- com.bitcamp.board.App 클래스 변경

  - 여러 개의 게시글을 저장할 수 있는 변수 준비
  - App.java.01 백업 소스 확인

- 2단계 - 배열 문법을 사용하여 여러 개의 게시글을 입력 받기
- com.bitcamp.board.App 클래스 변경

  - 게시글 데이터를 저장할 변수를 배열로 선언한다.
  - 배열의 크기는 final 변수로 지정한다.

- 3단계 - 배열에서 특정 번호의 게시글을 조회하기
- com.bitcamp.board.App 클래스 변경

  - 게시글 번호로 배열 인덱스를 찾는다.
  - 해당 인덱스의 게시글을 출력한다.

- 4단계 - 게시글 목록 출력하기
- com.bitcamp.board.App 클래스 변경
  - 배열에 저장된 개수만큼 게시글 목록을 출력하기
  - for 문을 이용하여 반복문을 처리

### 006. 메서드 사용법(with static)

- 코드를 관리하기 쉽게 기능 단위로 분리하기
- 스태틱 메서드 간에 변수를 공유하기: static 변수 사용

#### 작업 내용

- 1단계 - 메뉴를 처리하는 코드를 별도의 블록으로 묶는다.
- com.bitcamp.board.App 클래스 변경
  - 프로그램 환영 메시지 출력 코드 ==> welcome() {}
  - 게시글 목록을 처리하는 코드 ==> processBoardList() {}
  - 게시글 상세보기를 처리하는 코드 ==> processBoardDetail() {}
  - 게시글 입력을 처리하는 코드 ==> processBoardInput() {}
  - 메뉴를 출력하는 코드 ==> displayMenu() {}
  - 실행 결과 구분선을 출력하는 코드 ==> displayLine() {}
  - 메뉴 번호를 입력 받는 코드 ==> promptMenu() {}
  - 메뉴 번호 조건 검사 코드 ==> if 문을 switch 문으로 변경
  - 결과를 출력 후 빈 라인 출력 코드 ==> displayBlankLine();

### 007. 클래스 사용법

- 역할에 따라 메서드를 분류하기
- 필요에 따라 메서드 추가하기: inputInt(), inputString()
- 필요가 없어진 메서드는 삭제하기: promptMenu()

#### 작업 내용

- 1단계 - 게시글을 처리하는 메서드를 별도의 클래스로 분류한다
- com.bitcamp.board.BoardHandler 클래스 생성
  - App 클래스에 processBoardList() {} 가져온다.
    - 메서드 이름을 processList()로 변경한다.
  - App 클래스에 processBoardDetail() {} 가져온다.
    - 메서드 이름을 processDetail()로 변경한다.
  - App 클래스에 processBoardInput() {} 가져온다.
    - 메서드 이름을 processInput()로 변경한다.
- com.bitcamp.board.App 클래스 변경

- 2단계 - 사용자에게 프롬프트를 제공한 클래스를 추가한다.
- com.bitcamp.board.Prompt 클래스 생성
  - inputInt() 메서드 추가
  - inputString() 메서드 추가
  - inputInt(String) 메서드 추가
  - inputString(String) 메서드 추가
- com.bitcamp.board.App 클래스 변경
  - Prompt 클래스를 이용하여 사용자 입력 받기
- com.bitcamp.board.BoardHandler 클래스 변경
  - Prompt 클래스를 이용하여 사용자 입력 받기

### 008. 클래스 사용법 II

- 클래스 문법을 사용하여 데이터 타입 설계하기
- 클래스와 인스턴스, 레퍼런스의 관계
- 레퍼런스 배열과 인스턴스를 다루는 방법
- 인스턴스의 변수에 값을 넣고 꺼내는 방법
- 배열에서 값을 삭제하는 방법
- 배열에 있는 인스턴스의 변수 값을 변경하는 방법

#### 작업 내용

- 1단계 - 게시글 데이터를 저장할 메모리를 설계한다.
- com.bitcamp.board.Board 클래스 생성

- 2단계 - 게시글 처리에 배열을 사용한다.
- com.bitcamp.board.BoardHandler 클래스 변경

  - 기존의 게시글 관련 변수 배열을 Board 레퍼런스 배열로 대체
  - 게시글 입력, 목록, 상세보기 메서드를 변경한다.

- 3단계 - 게시글 삭제 메뉴를 추가한다.
- com.bitcamp.board.App 클래스 변경
- com.bitcamp.board.BoardHandler 클래스 변경

- 4단계 - 게시글 변경 메뉴를 추가한다.
- com.bitcamp.board.App 클래스 변경
- com.bitcamp.board.BoardHandler 클래스 변경

### 009. 리팩토링: 함수 추출 및 함수 옮기기

- 게시판을 추가할 수 있도록 메뉴 구조를 정리
- 게시판 메뉴를 다루는 코드: 메서드로 추출
- 게시판 메뉴를 다루는 메서드를 BoardHandler 로 이동: 메서드 옮기기
- 메서드 기능에 맞춰 이름 변경

#### 작업 내용

- 1단계 - 메뉴 구조를 변경한다.
- com.bitcamp.board.App 클래스 변경

  - App01.java 로 백업

- 2단계 - 리팩토링: 게시판 메뉴를 다루는 코드를 메서드로 추출한다.
- com.bitcamp.board.App 클래스 변경

  - onBoardMenu() 메서드 추가
  - displayMenu() 메서드 제거: onBoardMenu()로 코드를 옮긴다.
  - App02.java 로 백업

- 3단계 - 리팩토링: 게시판 메뉴를 출력하는 메서드를 BoardHandler로 옮긴다.
- com.bitcamp.board.App 클래스 변경
  - onBoardMenu(), displayLine(), displayBlankLine() 메서드를 BoardHandler 로 옮긴다.
- com.bitcamp.board.BoardHandler 클래스 변경
  - onBoardMenu(), displayLine(), displayBlankLine() 메서드 추가
  - displayLine() ==> displayHeadline() 이름 변경
  - onBoardMenu() ==> execute() 이름 변경

### 010. 스태틱 필드의 한계

- 클래스 복제를 이용하여 다양한 게시판 추가하기
- 클래스 복제 방식의 한계와 문제점 이해
  - 기능 추가/변경/삭제 할 때, 복제해서 만든 모든 코드에도 적용해야 한다.
  - 유지보수가 힘든 구조다.

#### 작업 내용

- 1단계 - 독서록 게시판을 추가한다.
- com.bitcamp.board.ReadingHandler 클래스 추가
  - BoardHandler 클래스를 복제하고, 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경

  - 독서록 메뉴를 실행할 수 있도록 코드 변경

- 2단계 - 방명록을 추가한다.
- com.bitcamp.board.VisitHandler 클래스 추가
  - BoardHandler 클래스를 복제하고, 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경

  - 방명록 메뉴를 실행할 수 있도록 코드 변경

- 3단계 - 공지사항 게시판을 추가한다.
- com.bitcamp.board.NoticeHandler 클래스 추가
  - BoardHandler 클래스를 복제하고, 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경

  - 공지사항 메뉴를 실행할 수 있도록 코드 변경

- 4단계 - 게시판의 글목록 크기를 자동으로 증가시킨다.
- com.bitcamp.board.BoardHandler 클래스 변경

  - processInput() 메서드 변경

- 5단계 - 나머지 게시판의 글목록 크기를 자동으로 증가시킨다.
- com.bitcamp.board.ReadingHandler 클래스 변경
  - processInput() 메서드 변경
- com.bitcamp.board.VisitHandler 클래스 변경
  - processInput() 메서드 변경
- com.bitcamp.board.NoticeHandler 클래스 변경
  - processInput() 메서드 변경

### 011. 인스턴스 필드와 인스턴스 메서드, 생성자 사용법

- BoardHandler의 스태틱 필드를 인스턴스 필드로 변경
- BoardHandler의 스태틱 메서드를 인스턴스 메서드로 변경
- BoardHandler에서 게시판을 제목을 다룰 수 있게 변경
- 생성자를 도입하여 title 필드를 필수 입력으로 설정
- 기타 초기 값을 설정하는 생성자를 추가

#### 작업 내용

- 1단계 - BoardHandler의 필드와 메서드를 인스턴스 멤버로 전환한다.
- com.bitcamp.board.BoardHandler 클래스 변경
  - 관련 필드를 인스턴스 필드로 변경한다.
  - 인스턴스 필드를 다루는 메서드는 인스턴스 메서드로 변경한다.
- com.bitcamp.board.App 클래스 변경

  - BoardHandler의 인스턴스를 만들어 다양한 게시판을 관리한다.

- 2단계 - 각 게시판의 제목을 따로 다룰 수 있게 한다.
- com.bitcamp.board.BoardHandler 클래스 변경
  - 게시판 제목을 저장할 인스턴스 필드 title을 추가한다.
  - 게시판 제목을 출력할 수 있도록 관련 메서드를 변경한다.
- com.bitcamp.board.App 클래스 변경

  - BoardHandler의 인스턴스를 만들 때 각 게시판에 대해 title 필드를 설정한다.

- 3단계 - 게시판의 제목을 설정하지 않으면 쓸 수 없도록 제한을 가한다.
- com.bitcamp.board.BoardHandler 클래스 변경

  - 인스턴스를 생성활 때 게시판 제목을 저장하는 title 필드의 값을 반드시 입력하도록 생성자를 추가한다.
  - 인스턴스 메서드가 제대로 작업할 수 있도록 인스턴스 필드를 유효한 값으로 설정하기 위해 생성자를 이용한다.

- 4단계 - 리팩토링: 사용자의 명령을 처리하는 메서드의 이름을 적절하게 변경한다.
- com.bitcamp.board.BoardHandler 클래스 변경

  - processList() ==> onList()
  - processDetail() ==> onDetail()
  - processInput() ==> onInput()
  - processDelete() ==> onDelete()
  - processUpdate() ==> onUpdate();

- 5단계 - 다양한 상황에서 사용할 생성자를 추가한다.
- com.bitcamp.board.BoardHandler 클래스 변경
  - Board() 기본 생성자 추가
  - Board(int) 생성자 추가

### 012. 인스턴스 목록을 다루는 코드를 분리: High Cohesion 구현(재사용성 강화)

- GRASP의 원칙 중에서 High Cohesion을 구현한다.
- BoardHandler의 역할에서 데이터 목록을 다루는 일을 BoardList로 옮긴다.

#### 작업 내용

- 1단계 - BoardHandler에서 인스턴스 목록을 다루는 코드를 분리한다.
- com.bitcamp.board.BoardHandler 클래스 변경
  - 목록과 관련된 필드를 BoardList 클래스로 옮긴다.
  - 각 메서드에서 데이터 목록을 다루는 코드를 BoardList 클래스로 옮긴다.
- com.bitcamp.board.BoardList 클래스 추가
  - 관련 필드와 메서드를 정의한다.
  - Board[] toArray() => 목록 조회
  - Board get(int boardNo) => 상세 조회
  - void add(Board board) => 글 등록
  - boolean remove(int boardNo) => 글 삭제
  - void grow() => 글 등록시 게시글 배열에 공간이 없으면 배열 길이 증가
  - int nextNo()
- com.bitcamp.board.App 클래스 변경
  - BoardHandler의 생성자 변경에 맞춰 코드 변경

### 013. 회원관리 기능 추가: CRUD 구현

- CRUD 구현을 훈련한다.

#### 작업 내용

- 1단계 - 게시판 기능을 모방하여 회원 관리 기능을 구현한다.
  - com.bitcamp.board.Member 클래스 추가
  - com.bitcamp.board.MemberHandler 클래스 추가
  - com.bitcamp.board.MemberList 클래스 추가
  - com.bitcamp.board.App 클래스 변경

### 014. 패키지를 이용하여 클래스를 분류하는 방법 + 접근 제어 조정

- 유지보수하기 좋게 클래스를 역할에 따라 분류한다.
- 패키지 분류에 따라 멤버의 접근 범위를 조정한다.

#### 작업 내용

- 1단계 - 데이터 타입에 해당하는 클래스를 별도의 패키지로 분류한다.
- com.bitcamp.board.domain 패키지 생성
  - 데이터 타입을 담는 패키지 명
    - domain|vo(value object)|dto(data transfer object)
  - Board, Member 클래스를 이 패키지로 옮긴다.
    - 접근 범위를 조정해야 한다.
    - public: 모두 공개
    - protected: 같은 패키지 + 자식 클래스
    - (default): 같은 패키지
    - private: 그 멤버를 가지고 있는 클래스 안에서만 접근 가능
- 2단계 - 데이터의 저장과 조회를 다루는 클래스를 별도의 패키지로 분류한다.
  데이터의 저장과 조회를 "퍼시스턴스(persistence)" 라 부른다.
- com.bitcamp.board.dao 패키지 생성

  - XxxList 클래스를 이 패키지로 옮긴다.
  - 접근 범위를 조정한다.
    - 외부에 공개할 멤버(변수,메서드): public
    - 내부에서만 사용할 멤버: private

- 3단계 - UI를 처리하는 클래스를 별도의 패키지로 분류한다.
- com.bitcamp.board.handler

  - XxxHandler 클래스를 이 패키지로 옮긴다.
  - 접근 범위를 조정한다.

- 4단계 - 유틸리티에 해당하는 클래스를 별도의 패키지로 분류한다.
- com.bitcamp.util 패키지 생성
  - Prompt 클래스를 이 패키지로 옮긴다.

### 015. 공통 코드(필드,메서드)를 공유하는 방법 : 상속

- 서로 관련된 클래스에 공통으로 나타나는 코드가 있다면 상속을 이용하여 공유한다.
- 일반화(generalization)
  - 클래스들의 공통 코드(필드, 메서드)를 추출하여 별도의 클래스로 정의하는 것.
  - 이렇게 정의한 클래스를 공유하는 것.
- 전문화(specialization)
  - 기존 클래스를 연결하고 필드나 변수를 추가하여 역할을 특화시키는 것.
- 다형성(polymorphism): 상황에 맞춰 여러 용도로 사용되는 것
  - 다형적 변수(polymorphic variables):
    - 상위 타입의 변수는 하위 타입의 개체를 가리킬 수 있다.
  - 오버라이딩(Overriding)
    - 상속 받은 수퍼 클래스의 메서드를 서브 클래스의 역할에 맞춰 재정의 하는 것.
  - 오버로딩(Overloading)
    - 파라미터의 타입이나 개수, 순서가 다르더라도 같은 기능을 수행하는 메서드에 대해 같은 이름을 부여함으로써 프로그래밍의 일관성을 제공하는 문법

### 작업 내용

- 1단계 - BoardList와 MemberList의 공통 필드와 메서드를 찾아 분리한다.
- com.bitcamp.util.ObjectList 클래스 생성

  - 여러 프로젝트에서 사용할 수 있도록 패키지를 조정한다.

- 2단계 - ObjectList를 상속 받아 BoardList와 MemberList를 정의한다.
- com.bitcamp.board.dao.BoardList 클래스 변경
- com.bitcamp.board.dao.MemberList 클래스 변경

  - ObjectList를 상속 받은 후 몇몇의 메서드를 오버라이딩 할 필요가 있음 확인하기 위해 기능을 변경한다.
  - 회원 번호 대신 이메일로 찾고 삭제하도록 변경한다.

- 3단계 - 상속의 일반화를 통해 구조가 변경된 것에 맞춰 XxxHandler를 변경한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
- com.bitcamp.board.handler.MemberHandler 클래스 변경

### 016. 예외를 처리하는 방법 1

- 예외가 발생했을 때 시스템을 멈추지 않는 방법
- 리턴 값을 통해서 예외 상황을 호출자에게 알린다.
- 리턴 값을 검사하여 예외 상황에 대해 조치를 취한다.

#### 작업 내용

- com.bitcamp.util.Prompt 클래스 변경
  - inputInt() 메서드에 예외 처리 문법 적용
  - 예외가 발생하면 리턴 값으로 예외 상황을 알린다.
  - 예외 정보를 즉시 출력한다.
    - 호출자가 원하는 방식으로 출력하지 못하는 문제가 있다.

### 017. 예외를 처리하는 방법 2

- 예외가 발생했을 때 시스템을 멈추지 않는 방법
- 예외가 발생하는 메서드를 호출할 쪽에서 처리하기
- 프로그램 동작에 따라 예외 처리 코드를 두는 곳이 다르다.

#### 작업 내용

- 1단계 - 메인 메뉴를 잘못 입력 했을 때 발생한 예외를 처리한다.
- com.bitcamp.board.App 클래스 변경

  - 메뉴 번호 입력 받는 부분에 try ~ catch ~ 적용

- 2단계 - 게시판 메뉴를 잘못 입력 했을 때 발생한 예외를 처리한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경

  - execute() 메서드에 try ~ catch ~ 적용

- 3단계 - 게시글 조회, 변경, 삭제 메뉴에서 발생한 예외를 처리한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 에 try ~ catch ~ 적용

예외 처리 코드는 프로그램 동작에 따라 적용이 달라진다.

### 018. 예외를 발생시키는 방법

- 비정상적인 상황을 알릴 때 리턴 값 대신 예외를 발생시키기
- 메서드 안에서 발생한 예외를 호출자에게 위임하는 방법
- 메서드에서 발생한 예외를 try ~ catch ~ 로 처리하는 방법
- 여러 메서드에서 발생한 예외를 한 메서드로 몰아서 처리하는 방법

#### 작업 내용

- 1단계 - 예외 상황이 발생했을 때 특정 값을 리턴하는 대신 오류 정보를 던진다.
- com.bitcamp.util.ObjectList 클래스 변경

  - get() 변경: 오류 상황일 때(인덱스가 무효할 때) 예외를 발생시킨다.
  - remove() 변경: 오류 상황일 때(인덱스가 무효할 때) 예외를 발생시킨다.
  - 이 메서드를 호출하는 쪽에서 좀 더 정교하게 제어할 수 있도록 도와 준다.

- 2단계 - 메서드에서 예외를 던졌을 때 직접 처리하는 대신 호출자에게 위임한다.
- com.bitcamp.board.dao.BoardList 클래스 변경
  - ObjectList의 get(), remove() 메서드가 예외를 던질 때 처리하지 말고 호출자에게 위임한다.
- com.bitcamp.board.dao.MemberList 클래스 변경

  - ObjectList의 get(), remove() 메서드가 예외를 던질 때 처리하지 말고 호출자에게 위임한다

- 3단계 - XxxList 가 던진 예외를 XxxHandler에서 처리한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 메서드 각각에서 예외를 처리한다.
  - BoardHandler01.java
- com.bitcamp.board.handler.MemberHandler 클래스 변경

  - onDetail(), onUpdate(), onDelete() 메서드 각각에서 예외를 처리한다.
    - 메서드 안의 코드를 통째로 try {} 안에 둔다.
  - MemberHandler01.java

- 4단계 - 메서드에서 발생한 예외를 한 곳에서 처리한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 메서드에서 예외를 처리하는 대신
    execute() 메서드에서 예외를 몰아 처리한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - onDetail(), onUpdate(), onDelete() 메서드에서 예외를 처리하는 대신
    execute() 메서드에서 예외를 몰아 처리한다.

### 019. 사용자 정의 예외를 다루는 방법

- ObjectList 에서 발생하는 예외에 대해 사용자 정의 예외를 던진다.
- Throwable 을 사용하는 대신 애플리케이션 예외 Exception을 사용한다.

#### 작업 내용

- 1단계 - ObjectList 에서 발생하는 예외 상황을 표현할 사용자 정의 예외를 만든다.
- com.bitcamp.util.ListException 클래스 생성

  - get()과 remove()에서 예외가 발생하면 이 클래스의 객체를 만들어 던진다.

- 2단계 - 사용자 정의 예외(ListException)를 적용한다.
- com.bitcamp.util.ObjectList 클래스 변경
  - get(), remove() 메서드에서 예외를 발생시킬 때 ListException을 던진다.
- com.bitcamp.board.dao.BoardList 클래스 변경
  - ObjectList 변경에 맞춰 예외 코드를 변경한다.
- com.bitcamp.board.dao.MemberList 클래스 변경

  - ObjectList 변경에 맞춰 예외 코드를 변경한다.

- 3단계 - XxxList 를 사용하는 XxxHandler 클래스를 변경한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - BoardList 변경에 맞춰 예외 코드를 변경한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - MemberList 변경에 맞춰 예외 코드를 변경한다.
- com.bitcamp.board.App 클래스 변경
  - Throwable 대신 애플리케이션 예외 Exception 으로 교체한다.
  - 즉 시스템 예외인 Error 계열 예외는 다루지 않는다.

### 020. 자료구조를 구현하고 다루는 방법: Linked List 구현 및 사용

- 크기를 고정하는 배열 대신 크기를 변경할 수 있는 동적 리스트를 구현한다.
- LinkedList의 구현 방법과 동작 원리를 이해한다.
- 상속의 문제점 이해한다.
  - 수퍼 클래스와 서브 클래스의 강한 결합은 기능 변경을 어렵게 한다.
  - 유지보수가 어렵다.

#### 작업 내용

- 1단계 - 링크드리스트에서 값을 저장하는 일을 할 Node 클래스를 정의한다.
- com.bitcamp.util.Node 클래스 생성

  - 값을 저장할 필드와, 이전 노드/다음 노드 주소를 저장할 필드를 선언한다.

- 2단계 - Node 목록을 관리할 LinkedList 클래스를 정의한다.
- com.bitcamp.util.LinkedList 클래스 생성
  - 클래스 필드 및 생성자 정의
  - append() 메서드 구현
  - retrieve(int) 메서드 구현
  - delete(int) 메서드 구현
  - length() 메서드 구현
  - getArray() 메서드 구현
- 3단계 - BoardList와 MemberList의 수퍼 클래스를 ObjectList에서 LinkedList로 교체한다.
- com.bitcamp.board.dao.BoardList 클래스 변경
  - 수퍼 클래스 교체에 맞춰 오버라이딩 메서드 변경
- com.bitcamp.board.dao.MemberList 클래스 변경

  - 수퍼 클래스 교체에 맞춰 오버라이딩 메서드 변경

- 4단계 - BoardList와 MemberList의 변경에 맞춰 XxxHandler 클래스를 변경한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - BoardList 변경에 맞춰 맞춰 오버라이딩 메서드의 이름을 변경한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - MemberList 변경에 맞춰 맞춰 오버라이딩 메서드의 이름을 변경한다.

### 021. 공통 코드(필드,메서드)를 공유하는 방법 : 연관(association)

- 상속 대신 연관을 이용하여 기존 코드를 활용한다.
- 019 버전의 코드를 연관(위임) 방식으로 변경한다.
- 019 -> 021

#### 작업 내용

- 1단계 - ObjectList를 상속하는 대신 연관(포함) 관계로 바꾼다.
- com.bitcamp.board.dao.BoardList 클래스 변경
  - ObjectList를 포함하는 관계로 바꾼다.
  - 기능을 ObjectList 로 위임할 수 있도록 메서드를 추가, 변경한다.
  - 서브 클래스가 아닌 관계로 클래스 이름을 BoardDao로 변경한다.
  - 메서드 이름도 데이터를 다루는 이름으로 적절하게 변경한다.
    - 기존의 ObjectList 는 인스턴스를 다룬다는 의미로 메서드 이름도 그에 맞춰서 지었다.
    - BoardDao은 인스턴스라는 기술적인 용어 대신 데이터에 초점을 맞춘다.
    - 따라서 데이터에 초점을 맞춘 메서드 이름으로 변경한다.
- com.bitcamp.board.dao.MemberList 클래스 변경

  - BoardList를 변경한 것과 똑같이 처리한다.

- 2단계 - BoardDao와 MemberDao에 맞춰 XxxHandler를 변경한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - BoardList 대신 ObjectList에 의존하고 있는 BoardDao를 사용한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - MemberList 대신 ObjectList에 의존하고 있는 MemberDao를 사용한다.

### 022. 자료구조를 구현하고 다루는 방법: Linked List 구현 및 사용

- 021 버전을 바탕으로 LinkedList 적용한다.
- 상속이 아닌 연관(위임) 구조일 때 기능 교체의 이점을 확인한다.

#### 작업 내용

- 1단계 - LinkedList 를 구현한다.
- 020 버전에서 구현한 LinkedList 관련 클래스를 가져온다.

- 2단계 - BoardDao와 MemberDao는 ObjectList 대신 LinkedList를 사용한다.
- com.bitcamp.board.dao.BoardDao 클래스 변경
  - 의존 객체를 ObjectList 에서 LinkedList로 교체한다.
- com.bitcamp.board.dao.MemberDao 클래스 변경
  - 의존 객체를 ObjectList 에서 LinkedList로 교체한다.

### 023. 메서드 사용법을 규격화하여 객체 사용 방법을 일관성 있게 만들기: 인터페이스

- 021 버전의 코드를 가져온다.
- 인터페이스 문법을 이용하여 목록을 다루는 객체의 사용법을 규격화 한다.
- ObjectList를 List 규격에 맞춰 구현한다.

#### 작업 내용

- 0단계 - 코드 준비
- 021 버전의 소스를 가져온다.

- 1단계 - 목록을 다루는 객체가 가져야 할 메서드의 형식을 정한다.
- com.bitcamp.util.List 인터페이스 생성
  - 목록을 다루는 메서드를 선언한다.
- 2단계 - List 규격에 따라 ObjectList를 구현한다.
- com.bitcamp.util.Object 클래스 변경

  - List 인터페이스를 구현한다.

- 3단계 - XxxDao에서 의존 객체를 가리킬 때는 클래스명 대신 인터페이스 이름을 사용한다.
- com.bitcamp.board.dao.BoardDao 클래스 변경
  - ObjectList 객체의 주소를 담는 필드를 List 타입으로 변경한다.
  - List 규격에 따라 메서드를 호출한다.
- com.bitcamp.board.dao.MemberDao 클래스 변경
  - ObjectList 객체의 주소를 담는 필드를 List 타입으로 변경한다.
  - List 규격에 따라 메서드를 호출한다.

### 024. List 규격에 맞춰 LinkedList 구현하고 적용하기

- List 규격에 맞춰 LinkedList 클래스를 만든다.
- 기존의 ObjectList 대신 LinkedList 클래스로 교체한다.
- 인터페이스를 도입했을 때 이점을 확인한다.

#### 작업 내용

- 1단계 - List 규격에 맞춰 LinkedList를 구현한다.
- com.bitcamp.util.LinkedList 클래스 생성
  - 022 버전의 LinkedList 클래스를 가져온다.
  - List 인터페이스를 구현한다.
- 2단계 - XxxDao에서 사용하는 ObjectList를 LinkedList로 교체한다.
- com.bitcamp.dao.BoardDao 클래스 변경
  - ObjectList 대신 LinkedList로 교체한다.
- com.bitcamp.dao.MemberDao 클래스 변경
  - ObjectList 대신 LinkedList로 교체한다.

### 025. 추상 클래스를 활용하여 인터페이스의 일부를 미리 구현하기

- 추상 클래스를 이용하여 List 규격의 메서드 중 서브 클래스에게 상속해 줄 일부 메서드를 미리 구현한다.
- ObjectList와 LinkedList 클래스는 추상 클래스를 상속 받아서 List 규격을 간접적으로 구현한다.

#### 작업 내용

- 1단계 - List 규격에 맞춰 AbstractList를 구현한다.
- com.bitcamp.util.AbstractList 추상클래스 생성
  - size 필드와 size() 메서드를 구현한다.
- 2단계 - ObjectList와 LinkedList는 AbstractList를 상속한다.
- com.bitcamp.util.ObjectList 클래스 변경
  - AbstractList가 구현하지 않은 List의 나머지 메서드를 구현한다.
- com.bitcamp.util.LinkedList 클래스 변경
  - AbstractList가 구현하지 않은 List의 나머지 메서드를 구현한다.

### 026. 중첩 클래스 문법을 이용하여 클래스 사용 범위를 제한하기

- 특정 클래스 안에서만 사용될 클래스라면 그 클래스 내부에 정의하는 것이 유지보수에 좋다.
- 패키지 클래스인 Node 클래스를 LinkedList의 스태틱 중첩 클래스로 전환하여 LinkedList를 다룰 때만 Node 클래스를 유지보수 할 수 있게 사용 범위를
  제한한다.

#### 작업 내용

- 1단계 - LinkedList가 사용하는 Node 클래스를 중첩 클래스를 변경한다.
- com.bitcamp.util.LinkedList 클래스 변경
  - Node 클래스를 중첩 클래스로 정의한다.
- com.bitcamp.util.Node 클래스 삭제

### 027. 스택 자료 구조를 활용하여 브래드크럼 메뉴 만들기

- 스택(stack) 자료구조를 구현한다.
- 스택 자료구조를 활용하여 breadcrumb 메뉴를 만든다.

#### 작업 내용

- 1단계 - LinkedList 상속 받아 Stack 클래스를 구현한다.
- com.bitcamp.util.Stack 클래스 생성

  - LinkedList를 상속한다.
  - push()/pop() 메서드를 추가로 정의한다.

- 2단계 - 메뉴의 제목을 저장할 수 있도록 스택 객체를 준비한다.
- com.bitcamp.board.App 클래스 변경

  - Stack 객체를 준비한다.
    - 여러 클래스에서 공통으로 사용할 수 있도록 static 멤버로 선언한다.
    - 여러 클래스에서 접근할 수 있도록 public으로 공개한다.
  - 메뉴 출력을 리팩토링 한다.

- 3단계 - 메뉴에 진입할 때 그 메뉴의 이름을 스택에 저장한다.
- com.bitcamp.board.App 클래스 변경
  - 애플리케이션을 실행할 때 "메인" 메뉴 이름을 스택에 추가한다.
  - 메뉴의 제목을 출력할 때 스택에서 문자열을 꺼내 출력한다.
  - breadcrumb 메뉴바 적용에 따라 기존 코드를 리팩토링 한다.
- com.bitcamp.board.handler.XxxHandler 클래스 변경
  - 핸들러를 실행할 때 해당 핸들러의 메뉴 이름을 스택에 등록한다.
  - 핸들러의 서브 메뉴 실행을 마치면 스택에 등록된 메뉴를 제거한다.
  - breadcrumb 메뉴바 적용에 따라 기존 코드를 리팩토링 한다.

### 028. 인터페이스를 이용하여 핸들러의 사용법을 규격화 하기

- 핸들러의 사용법을 인터페이스로 규격화시킨다.
- 기존의 핸들러를 인터페이스 규칙에 따라 구현한다.
- App 클래스는 핸들러 규칙에 따라 사용한다.
  - 인터페이스의 레퍼런스 배열을 이용하여 여러 개의 핸들러 객체를 관리한다.
  - 인터페이스 규칙에 따라 핸들러를 실행한다.

#### 작업 내용

- 1단계 - 핸들러의 사용법을 인터페이스로 규격화 한다.
- com.bitcamp.handler.Handler 인터페이스 생성

  - 핸들러 사용 규칙을 정의한다.

- 2단계 - 핸들러 사용 규칙에 따라 BoardHandler와 MemberHandler를 구현한다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - Handler 인터페이스를 구현한다.
- com.bitcamp.board.handler.MemberHandler 클래스 변경

  - Handler 인터페이스를 구현한다.

- 3단계 - Handler 규칙에 따라 핸들러 객체를 실행한다.
- com.bitcamp.board.App 클래스 변경
  - Handler 객체를 레퍼런스 배열로 관리한다.
  - 핸들러를 실행할 때 규칙에 따라 메서드를 호출한다. switch 문 제거!

### 029. 추상 클래스를 사용하여 핸들러의 공통 기능 구현하기: 템플릿 메서드 패턴 적용

- Handler 인터페이스를 미리 구현한 추상 클래스를 생성한다.
- 추상 클래스에서 핸들러의 공통 기능을 정의한다.
- XxxHandler 에서 나머지 기능을 구현한다.

#### 작업 내용

- 1단계 - Handler 규격에 맞춰 구현체를 제작한다.
- com.bitcamp.handler.AbstractHandler 추상 클래스 생성

  - Handler 규격에 맞춰 x 구현한다.
  - 템플릿 메서드 패턴을 적용한다.

- 2단계 - AbstractHandler를 상속 받아서 BoardHandler, MemberHandler를 만든다.
- com.bitcamp.board.handler.BoardHandler 클래스 변경
  - service() 추상 메서드 구현
- com.bitcamp.board.handler.MemberHandler 클래스 변경
  - service() 추상 메서드 구현

### 030. List가 특정 타입의 목록만 다루게 하는 방법: 제네릭 문법 적용

- 한 개의 클래스를 정의하여 타입 별로 클래스가 있는 것처럼 사용한다.
  - 즉 타입 파라미터를 이용하여 목록에서 특정 타입의 값만 다루도록 제한한다.
  - 형변환 없이 목록에 들어 있는 데이터를 꺼낸다.
- 이를 통해 각 타입 별로 전용 클래스가 있는 효과를 누린다.

#### 작업 내용

- 1단계 - List 인터페이스에 제네릭을 적용한다.
- com.bitcamp.util.List 인터페이스 변경

  - 목록에서 다루는 항목의 타입을 제네릭으로 설정한다.

- 2단계 - List 구현체에 제네릭을 적용한다.
- com.bitcamp.util.AbstractList 추상 클래스 변경
- com.bitcamp.util.ObjectList 클래스 변경
- com.bitcamp.util.LinkedList 클래스 변경

- 3단계 - XxxDao 클래스는 제네릭이 적용된 List 구현체 사용한다.
- com.bitcamp.board.dao.BoardDao 클래스 변경
- com.bitcamp.board.dao.MemberDao 클래스 변경

### 031. 데이터 조회 로직을 객체화 하기: Iterator 패턴 적용

- 데이터 조회 규격을 Iterator 인터페이스로 정의한다.
- List 구현체에서 Iterator 규격을 따르도록 변경한다.
- 객체 목록을 다룰 때 Iterator 구현체를 사용한다.

#### 작업 내용

- 1단계 - Iterator 인터페이스를 정의한다.
- com.bitcamp.util.Iterator 인터페이스 생성

- 2단계 - List 규격에 Iterator 를 리턴하는 규칙을 추가한다.
- com.bitcamp.util.List 인터페이스 변경

  - iterator() 규칙 추가

- 3단계 - AbstractList 에서 iterator() 메서드를 구현한다.
- com.bitcamp.util.AbstractList 클래스 변경

- 4단계 - XxxDao 에서 목록을 가져올 때 Iterator를 사용한다.
  toArray() 대신 iterator() 사용을 통해 Iterator 객체 사용법 훈련.
- com.bitcamp.board.dao.XxxDao 클래스 변경

- 5단계 - Stack의 toString() 메서드를 구현할 때 Iterator를 사용한다.
- com.bitcamp.util.Stack 클래스 변경

  - 제네릭을 적용한다.
  - toString()에서 Iterator를 사용한다.

- 6단계 - App 클래스에서 Stack 을 만들 때 제네릭을 적용한다.
- com.bitcamp.board.App 클래스 변경

### 032. 기존 List 구현체를 자바 컬렉션 API로 교체하기: java.util 패키지의 클래스 사용

- 기존의 List 관련 클래스를 모두 자바 컬렉션 API로 변환한다.

#### 작업 내용

- 1단계 - 기존의 목록 관련 클래스를 자바 컬렉션 API로 교체한다.
- com.bitcamp.util.List 인터페이스 삭제
- com.bitcamp.util.AbstractList 추상 클래스 삭제
- com.bitcamp.util.ObjectList 클래스 삭제
- com.bitcamp.util.LinkedList 클래스 삭제
- com.bitcamp.util.Stack 클래스 삭제
- com.bitcamp.board.dao.BoardDao 클래스 변경
- com.bitcamp.board.dao.MemberDao 클래스 변경
- com.bitcamp.board.App 클래스 변경
