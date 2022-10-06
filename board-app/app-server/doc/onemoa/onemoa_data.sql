load data local infile '/Users/bebeco/bitcamp-project/DB/파일명.csv' into table [DB명].[테이블명]] fields terminated by ',';

-- 직업번호
insert into job(jno, name) values('1', '학생');
insert into job(jno, name) values('2', '직장인');

-- 회원
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('1', 'user1@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '1', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('2', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '1', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('3', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01011112222', '5555', '기본주소', '상세주소', '1', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 

