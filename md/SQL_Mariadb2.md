# JOIN

### cross join = Cartesian product

두 테이블의 데이터를 1:1로 모두 연결한다.
첫 번째 테이블의 행 수에 두 번째 테이블의 행 수를 곱한 결과 집합을 생성

```sql
select m.mno, s.mno
from memb m cross join stnt as s;

/* 예전 문법 */
select m.mno, s.mno
from memb m, stnt as s;
```

### natural join

같은 이름을 가진 컬럼 값을 기준으로 레코드를 연결한다.

```sql
select m.mno, name, s.mno, work, bank
from memb m natural join stnt s;

/* 예전 문법 */
select m.mno, name, s.mno, work, bank
from memb m, stnt s
where m.mno=s.mno;
```

- natual join 의 문제점
  1. 두 테이블의 조인 기준이 되는 컬럼 이름이 다를 때 연결되지 못한다.
  2. 상관 없는 컬럼과 이름이 같을 때 잘못 연결된다.
  3. 같은 이름의 컬럼이 여러 개 있을 경우 잘못 연결된다.
     모든 컬럼의 값이 일치할 경우에만 연결되기 때문

만약에 두 테이블에 같은 이름을 가진 컬럼이 여러 개 있다면,
join ~ using(기준컬럼)을 사용하여 두 테이블의 데이터를 연결할 때 기준이 될 컬럼을 지정한다.

### join ~ using

USING 의 역할
두 개의 테이블이 내부 조인으로 조인 될 때 조인하고자 하는 두 테이블의 컬럼명이 같을 경우 조인 조건을 길게 적지 않고 간단하게 적을 수 있도록 하는 역할

```sql
select m.mno, name, s.mno, work, bank
from memb m join stnt s using (mno);
```

- natural join 의 문제점 2
  두 테이블에 같은 이름의 컬럼 없을 경우 연결하지 못한다.
  만약 두 테이블에 같은 이름을 가진 컬럼이 없으면, 또한 Join usin으로도 해결할 수 없다.
  이럴 경우 `join ~ on 컬럼a=컬럼b` 문법을 사용하여 각 테이블의 어떤 컬럼과 값을 비교할 것인지 지정한다.

``
https://stackoverflow.com/questions/1018822/inner-join-on-vs-where-clause

```sql
select m.mno, name, s.mno, work, bank
from memb m inner join stnt s on m.mno=s.mno;

/* inner는 생략 가능하다 */
select m.mno, name, s.mno, work, bank
from memb m join stnt s on m.mno=s.mno;
/* 즉 inner join 은 기준 컬럼의 값이 일치할 때만 데이터를 연결한다. */

/* 예전의 조인 문법 = inner join */
select m.mno, name, s.mno, work, bank
from memb m, stnt s
where m.mno=s.mno;
```

### outer join(외부조인)

OUTER JOIN은 조인하는 여러테이블에서 한 쪽에는 데이터가 있고, 한 쪽에는 데이터가 없는 경우, 데이터가 있는 쪽 테이블의 내용을 모두 출력하는 것입니다. 즉, 조건에 맞지 않아도 해당하는 행을 출력하고 싶을 때 사용할 수 있습니다.

```sql
/* => 만약 기준 컬럼의 값과 일치하는 데이터가 없어서
      다른 테이블의 데이터와 연결되지 않았다 하더라도
      결과로 뽑아내고 싶다면 outer join을 사용하라!
      */
/* 즉 아직 강의실이 배정되지 않은 강의 데이터도 출력하고 싶을 때 출력하고 싶은 테이블을 바깥쪽 테이블로 지정하라!
*/

select
  r.rno,
  r.name,
  r.loc,
  l.titl
from room r
  inner join lect l on r.rno = l.rno;

select
  r.rno,
  r.name,
  r.loc,
  l.titl
from room r
  left outer join lect l on r.rno = l.rno;
```

```sql
/* 여러 테이블의 데이터를 연결하기
    => 다음의 결과가 출력될 수 있도록 수강 신청 데이터를 출력하시오!
    수강신청번호, 강의명, 학생명, 재직여부, 수강신청일, 강의실명, 매니저명, 직위 */

/* 1단계: 수강신청 데이터를 출력 */
select la.lano, la.lno, la.mno, la.rdt
from lect_appl la;

/* 2단계: 수강신청한 학생의 번호 대신 이름을 출력 */
select la.lano, la.lno, m.name, la.rdt
from lect_appl la
     inner join memb m on la.mno=m.mno;

select * from lect_appl la inner join memb m on la.mno=m.mno;

/* 3단계: 수강 신청한 학생의 재직 여부 출력
 * => inner join 에서 inner는 생략 가능
 */
select la.lano, la.lno, m.name, s.work, la.rdt
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno;

select *
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno;

/* 4단계: 수상신청한 강의 번호 대신 강의명을 출력 */
select la.lano, l.titl, m.name, s.work, la.rdt, l.rno
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno;

select *
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno;

/* 5단계: 강의실 이름을 출력한다.
 * => 강의실 번호는 lect 테이블 데이터에 있다.
 * => 강의실 이름은 room 테이블 데이터에 있다.
 */
select la.lano, l.titl, m.name, s.work, la.rdt, r.name, l.mno
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno;

select *
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno;

select la.lano, l.titl, m.name, s.work, la.rdt, r.name, l.mno
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno
        join room r on l.rno=r.rno;
/* 6단계: 매니저 이름을 출력
 * => 매니저 번호는 lect 테이블에 있다.
 * => 매니저 이름은 memb 테이블에 있다.
 */
select
  la.lano,
  l.titl,
  m.name member_name,
  s.work,
  la.rdt,
  r.name room_name,
  m2.name manager_name
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno
        left outer join memb m2 on l.mno=m2.mno;

/* 7단계: 매니저의 직위 출력
 * => 매니저 번호는 lect 테이블 있다.
 * => 매니저 직위는 mgr 테이블에 있다.
 */
select
  la.lano,
  l.titl,
  m.name snm,
  s.work,
  la.rdt,
  r.name rnm,
  m2.name mnm,
  mr.posi
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno
        left outer join memb m2 on l.mno=m2.mno
        left outer join mgr mr on l.mno=mr.mno;



select
 *
from lect_appl la
        join memb m on la.mno=m.mno
        join stnt s on la.mno=s.mno
        join lect l on la.lno=l.lno
        left outer join room r on l.rno=r.rno
        left outer join memb m2 on l.mno=m2.mno
        left outer join mgr mr on l.mno=mr.mno;

/* */
```
