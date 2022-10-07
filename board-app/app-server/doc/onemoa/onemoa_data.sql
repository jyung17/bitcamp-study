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
values('1', 'user1@test.com', sha2('1111',256), '판매자닉네임', '판매자', '01011112222', '5555', '기본주소', '상세주소', '1', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('2', 'user2@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01022222222', '5555', '기본주소', '상세주소', '2', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('3', 'user3@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01033332222', '5555', '기본주소', '상세주소', '3', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('4', 'user4@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01044442222', '5555', '기본주소', '상세주소', '4', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('5', 'user5@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01055552222', '5555', '기본주소', '상세주소', '5', '프로필사진파일경로', '이메일토큰', true);
insert into member(mno, email, pwd, nick, name, tel, pstno, base_addr, detail_addr, jno, profil, token, status) 
values('6', 'user6@test.com', sha2('1111',256), '회원닉네임', '홍길동', '01066662222', '5555', '기본주소', '상세주소', '6', '프로필사진파일경로', '이메일토큰', true);

-- 관심사
1,010000
2,020000
3,030000
4,040000
5,050000
6,060000

-- 재능판매
1,010100,1,로고제작 공모전 488회우승 로고디자인 CI BI 드림, 로고 디자인 공모전 488회 우승 국내 로고 제작 경력 최다 디자이너가 직접 진행 상담은 무료입니다.:), 1000000, 0
2,010101,1,로고제작 공모전 488회우승 로고디자인 CI BI 드림, 로고 디자인 공모전 488회 우승 국내 로고 제작 경력 최다 디자이너가 직접 진행 상담은 무료입니다.:), 1000000, 100
3,020100,1,로고제작 공모전 488회우승 로고디자인 CI BI 드림, 로고 디자인 공모전 488회 우승 국내 로고 제작 경력 최다 디자이너가 직접 진행 상담은 무료입니다.:), 1000000, 1000
4,020101,1,로고제작 공모전 488회우승 로고디자인 CI BI 드림, 로고 디자인 공모전 488회 우승 국내 로고 제작 경력 최다 디자이너가 직접 진행 상담은 무료입니다.:), 1000000, 10000
5,030100,1,로고제작 공모전 488회우승 로고디자인 CI BI 드림, 로고 디자인 공모전 488회 우승 국내 로고 제작 경력 최다 디자이너가 직접 진행 상담은 무료입니다.:), 1000000, 100000
6,030101,1,로고제작 공모전 488회우승 로고디자인 CI BI 드림, 로고 디자인 공모전 488회 우승 국내 로고 제작 경력 최다 디자이너가 직접 진행 상담은 무료입니다.:), 1000000, 1000000