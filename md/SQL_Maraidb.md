# mariadb 설치 및 설정

### mariadb 설치

[mac]

mariadb 설치

`brew install mariadb`

mariadb 설치 후 root 암호 변경

`sudo mysql_secure_installation`

mariadb 실행

`brew services start mariadb`

`brew services stop mariadb`

mariadb 실행

`brew services start mariadb`

`brew services stop mariadb`

# DDL

### 테이블 변경

기존에 있는 테이블 수정

- 테이블 생성

```sql
create table test1 (
  name varchar(3),
  kor int,
  eng int,
  math int,
  sum int,
  aver int
);

alter table test1 add column no int;
alter table test1 add column age int;
alter table test1 add column no2 int, add column age2 int;
```

- PK 컬럼 지정, UNIQUE 컬럼 지정, INDEX 컬럼 지정

```sql
alter table test1
  add constraint test1_pk primary key (no),
  add constraint test1_uk unique (name, age),
  add fulltext index test1_name_idx (name);
```

- 컬럼에 옵션 추가

```sql
alter table test1
  modify column name varchar(20) not null,
  modify column age int not null,
  modify column kor int not null,
  modify column eng int not null,
  modify column math int not null,
  modify column sum int not null,
  modify column aver float not null;
```

- 입력 테스트

```sql
insert into test1(no,name,age,kor,eng,math,sum,aver) values(1,'aaa',20,100,100,100,300,100);

insert into test1(no,name,age,kor,eng,math,sum,aver) values(2,'bbb',21,100,100,100,300,100);

/* 다음은 name과 age의 값이 중복되기 때문에 입력 거절된다.*/
insert into test1(no,name,age,kor,eng,math,sum,aver) values(3,'bbb',21,100,100,100,300,100);
```

### 컬럼 값 자동 증가

- 숫자 타입의 PK 컬럼 또는 Unique 컬럼인 경우 값을 1씩 자동 증가시킬 수 있다.
- 즉 데이터를 입력할 때 해당 컬럼의 값을 넣지 않아도 자동으로 증가된다.
- 단 삭제를 통해 중간에 비어있는 번호는 다시 채우지 않는다.
  즉 증가된 번호는 계속 앞으로 증가할 뿐이다.

- 테이블 생성

```sql
create table test1(
  no int not null,
  name varchar(20) not null
);
```

- 특정 컬럼의 값을 자동으로 증가하게 선언한다.
- 단 반드시 key(primary key 나 unique)여야 한다.

```sql
alter table test1
  modify column no int not null auto_increment; /* 아직 no가 pk가 아니기 때문에 오류*/

alter table test1
  add constraint primary key (no); /* 일단 no를 pk로 지정한다.*/

alter table test1
  add constraint unique (no); /* no를 unique로 지정해도 한다.*/

alter table test1
  modify column no int not null auto_increment; /* 그런 후 auto_increment를 지정한다.*/
```

- 입력 테스트

```sql
/* auto-increment 컬럼의 값을 직접 지정할 수 있다.*/
insert into test1(no, name) values(1, 'xxx');

/* auto-increment 컬럼의 값을 생략하면 마지막 값을 증가시켜서 입력한다.*/
insert into test1(name) values('aaa');

insert into test1(no, name) values(100, 'yyy');

insert into test1(name) values('bbb'); /* no는 101이 입력된다.*/

insert into test1(name) values('ccc'); /* no=102 */
insert into test1(name) values('ddd'); /* no=103 */

/* 값을 삭제하더라도 auto-increment는 계속 앞으로 증가한다.*/
delete from test1 where no=103;

insert into test1(name) values('eee'); /* no=104 */

insert into test1(name) values('123456789012345678901234');

/* 다른 DBMS의 경우 입력 오류가 발생하더라도 번호는 자동 증가하기 때문에
 * 다음 값을 입력할 때는 증가된 값이 들어간다.
 * 그러나 MySQL(MariaDB)는 증가되지 않는다.
 */
insert into test1(name) values('fff'); /* no=? */
```

## 뷰(view)

- 조회 결과를 테이블처럼 사용하는 문법
- select 문장이 복잡할 때 뷰로 정의해 놓고 사용하면 편리하다.

```sql
create table test1 (
  no int primary key auto_increment,
  name varchar(20) not null,
  class varchar(10) not null,
  working char(1) not null,
  tel varchar(20)
);

insert into test1(name,class,working) values('aaa','java100','Y');

insert into test1(name,class,working) values('bbb','java100','N');

insert into test1(name,class,working) values('ccc','java100','Y');

insert into test1(name,class,working) values('ddd','java100','N');

insert into test1(name,class,working) values('eee','java100','Y');

insert into test1(name,class,working) values('kkk','java101','N');

insert into test1(name,class,working) values('lll','java101','Y');

insert into test1(name,class,working) values('mmm','java101','N');

insert into test1(name,class,working) values('nnn','java101','Y');

insert into test1(name,class,working) values('ooo','java101','N');
```

- 직장인만 조회

```sql
select no, name, class from test1 where working = 'Y';
```

- 직장인만 조회한 결과를 가상 테이블로 만들기

```sql
create view worker
  as select no, name, class from test1 where working = 'Y';
```

- view가 참조하는 테이블에 데이터를 입력한 후 view를 조회하면?
- 새로 추가된 컬럼이 함께 조회된다.
- 뷰를 조회할 때 마다 매번 select 문장을 실행한다.
- 미리 결과를 만들어 놓는 것이 아니다.
- 일종의 조회 함수 역할을 한다.
- 목적은 복잡한 조회를 가상의 테이블로 표현할 수 있어 SQL문이 간결해진다.

```sql
insert into test1(name, class, working) values('ppp','java101','Y');
select * from worker;
```

### 뷰 삭제

```sql
drop view worker;
```

## 제약 조건 조회

- 테이블의 제약 조건 조회

```sql
select table_name, constraint_name, constraint_type from information_schema.table_constraints;
```

- 테이블의 키 컬럼 정보 조회

```sql
select table_name, column_name, constraint_name from information_schema.key_column_usage;
```

- 테이블과 컬럼의 키 제약 조건 조회

```sql
select
  t2.table_name,
  t2.column_name,
  t2.constraint_name,
  t1.constraint_type
from information_schema.table_constraints t1
  inner join information_schema.key_column_usage t2 on t2.constraint_name=t1.constraint_name;
```

# DML(Data Maniqulation Language)

데이터 등록, 변경, 삭제를 다루는 SQL 문법

## insert

- 데이터를 입력할 때 사용하는 문법.

```sql
/* 연락처 테이블 생성 */
create table test1 (
  no int not null,
  name varchar(20) not null,
  tel varchar(20) not null,
  fax varchar(20),
  pstno varchar(5),
  addr varchar(200)
);

/* PK 컬럼 지정 */
alter table test1 add constraint test1_pk primary key (no);

/* 자동 증가 컬럼 지정 */
alter table test1 modify column no int not null auto_increment;
```

- 전체 컬럼 값 입력하기

```sql
/* 컬럼을 지정하지 않으면
 * 테이블을 생성할 때 선언한 컬럼 순서대로
 * 값을 지정해야 한다.*/
insert into 테이블명 values(값,....);
insert into test1 values(null,'aaa','111','222','10101','seoul');

/* 컬럼을 명시할 수 있다. 이때 값을 입력하는 컬럼의 순서를 바꿀 수 있다. */
insert into 테이블명(컬럼,컬럼,...) values(값,값,...);
insert into test1(name,fax,tel,no,pstno,addr)
    values('bbb','222','111',null,'10101','seoul');
```

- 값을 입력할 컬럼을 선택하기. 단 필수 입력 컬럼은 반드시 선택해야 한다.

```sql
/* no 컬럼은 필수 입력 컬럼이지만,
  자동 증가 컬럼이기 때문에 값을 입력하지 않아도 된다.*/
insert into test1(name,tel) values('ccc','333');
```

### 여러 개의 값을 한 번에 insert 하기

```sql
insert into test1(name,tel) values
('aaa', '1111'),
('bbb', '2222'),
('ccc', '3333');
```

### select 결과를 테이블에 insert하기

```sql
create table test2 (
  no int primary key auto_increment,
  fullname varchar(20) not null,
  phone varchar(20) not null,
  kor int,
  eng int,
  math int
);

/*
  select 결과를 테이블에 바로 입력하기
  => select 결과의 컬럼명과 insert 테이블의 컬럼명이 같을 필요는 없다.
  => 그러나 결과의 컬럼 개수와 insert 하려는 컬럼 개수가 같아야 한다.
  => 결과의 컬럼 타입과 insert 하려는 컬럼의 타입이 같거나 입력 할 수 있는 타입이어야 한다.
*/
insert into test2(fullname,phone)
	select name, tel from test1 where addr='seoul';
```

## update

- 등록된 데이터를 변경할 때 사용하는 명령이다.

```sql
update 테이블명 set 컬럼명=값, 컬럼명=값, ... where 조건...;
update test1 set pstno='1111', fax='222' where no=3;
update test1 set tel='3030', fax='1212' where no=2;
```

## delete

- 데이터를 삭제할 때 사용하는 명령이다.

```sql
delete from 테이블명 where 조건;
delete from test1 where no=2 or no=3;

/* 조건을 지정하지 않으면 모든 데이터가 삭제된다. 주의!*/
delete from test1;
```

## autocommit

mysql은 autocommit의 기본 값이 true이다.
따라서 명령창에서 SQL을 실행하면 바로 실제 테이블에 적용된다.
수동으로 처리하고 싶다면 autocommit을 false로 설정하라!

autocommit=ON이면 데이터를 변경하는 쿼리(insert, update, delete)가 실행될 때마다 자동으로 commit이 처리되며, 이는 매 문장마다 commit 처리를 위한 부하(Disk 동기화, binary log 동기화 등)가 과다해져서 DB전체 성능에 영향을 줄 수 있고, 전체 작업 중 일부에서 오류가 발생했을 때 작업을 취소(rollback)할 수 없다.

```sql
set autocomit=false;
show variables like 'autocommit%';
```

https://mariadb.com/kb/en/start-transaction/

```sql
/* The START TRANSACTION or BEGIN statement begins a new transaction. */
start transaction;
commit;
rollback;
```

# DQL(Data Query Language)

데이터를 조회할 때 사용하는 문법

## 테스트 용 테이블 및 데이터 준비

```sql
create table test1 (
  no int primary key auto_increment,
  name varchar(20) not null,
  class varchar(10) not null,
  working char(1) not null,
  tel varchar(20)
);

insert into test1(name,class,working) values('aaa','java100','Y');
insert into test1(name,class,working) values('bbb','java100','N');
insert into test1(name,class,working) values('ccc','java100','Y');
insert into test1(name,class,working) values('ddd','java100','N');
insert into test1(name,class,working) values('eee','java100','Y');
insert into test1(name,class,working) values('kkk','java101','N');
insert into test1(name,class,working) values('lll','java101','Y');
insert into test1(name,class,working) values('mmm','java101','N');
insert into test1(name,class,working) values('nnn','java101','Y');
insert into test1(name,class,working) values('ooo','java101','N');
```

## select

- 테이블의 데이터를 조회할 때 사용하는 명령어

select \* from test1;
test1 -> 테이블명

select no, name from test1;
no, name -> 컬럼명

select no, name
from test1
where no > 10;

select no, name -> projection 대상
where no > 10; -> selection 조건

selection : 특정 조건의 데이터를 선택
projection : 결과로 추출할 컬럼을 지정(특정 컬럼의 값만 조회할 때)

```sql
/* 모든 컬럼 값 조회하기. 컬럼 순서는 테이블을 생성할 때 선언한 순서이다.*/
select * from 테이블;
select * from test1;

/* 특정 컬럼의 값만 조회할 때 => "프로젝션(projection)"이라 부른다.*/
select 컬럼명,컬럼명 from 테이블;
select no, name, tel from test1;

/* 가상의 컬럼 값을 조회하기*/
select no, concat(name,'(',class,')') from test1;
```

### 조회하는 컬럼에 별명 붙이기

- 별명을 붙이지 않으면 원래의 컬럼명이 조회 결과의 컬럼으로 사용된다.
- 위의 예제처럼 복잡한 식으로 표현한 컬럼인 경우 컬럼명도 그 식이 된다.
- 이런 경우 별명을 붙이면 조회 결과를 보기 쉽다.

```sql

```

### 조회할 때 조건 지정하기

## 연산자

### OR, AND, NOT

- OR : 두 조건 중에서 참인 것이 있으면 조회 결과 포함시킨다.
- AND : 두 조건 모두 참일 때만 조회 결과에 포함시킨다.
- NOT :

### like

- 문자열을 비교할 때 사용한다.

```sql
/* class 이름이 java로 시작하는 모든 학생 조회하기
 * => % : 0개 이상의 문자
 */
select *
from test1
where class like 'java%';

/* class 이름에 java를 포함한 모든 학생 조회하기
   이 경우 조회 속도가 느리다.*/
select *
from test1
where class like '%java%';

/* class 이름이 101로 끝나는 반의 모든 학생 조회하기 */
select *
from test1
where class like '%101';

/* 학생의 이름에서 첫번째 문자가 s이고 두번째 문자가 0인 학생 중에서
   딱 세자의 이름을 가진 학생을 모두 조회하라!*/

/* => %는 0자 이상을 의미하기 때문에 이 조건에 맞지 않다.*/
select *
from test1
where name like 's0%';

/* => _는 딱 1자를 의미한다.*/
select *
from test1
where name like 's0_';
```

## FK(foreign key) 제약 조건 설정

- 다른 테이블의 데이터와 연관된 데이터를 저장할 때 무효한 데이터가 입력되지 않도록 제어하는 문법.
- 다른 테이블의 데이터가 참조하는 데이터를 임의의 지우지 못하도록 제어하는 문법.
- 그래서 데이터의 무결성(data integrity; 결함이 없는 상태)을 유지하게 도와주는 문법이다.

다른 테이블의 PK를 참조하는 컬럼으로 선언한다.

```sql
alter table test2
add constraint test2_bno_fk foreign key (bno) references test1(no);

/* 기존에 테이블에 무효한 데이터가 있을 수 있기 때문에 먼저 테이블의 데이터를 지운다.*/
delete from test2;

/* */

alter table test2 add constraint test2_bno_fk foreign key (bno) references test1(no);
```
