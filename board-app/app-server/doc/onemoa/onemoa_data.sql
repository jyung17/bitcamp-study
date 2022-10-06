load data local infile '/Users/bebeco/bitcamp-project/DB/파일명.csv' into table [DB명].[테이블명]] fields terminated by ',';

-- UPDATE [테이블] SET [열] = '변경할값' WHERE [조건] 
-- update job set name='직장인' where jno=2;
-- 직업번호
insert into job(jno, name) values('1', '프리랜서');
insert into job(jno, name) values('2', '직장인');
insert into job(jno, name) values('3', '소상공인');
insert into job(jno, name) values('4', '스타트업 창업자');
insert into job(jno, name) values('5', '대학(원)생');
insert into job(jno, name) values('6', '취업준비생');

-- 회원
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('1', 'user1@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '1', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('2', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '2', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('3', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '3', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('4', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '4', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('5', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '5', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('6', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '6', '프로필사진파일경로', '이메일토큰', true);


