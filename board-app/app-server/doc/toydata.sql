-- 회원 데이터 입력
insert into app_member(mno,name,email,pwd) values(1,'user1', 'user1@test.com', sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(2,'user2', 'user2@test.com', sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(3,'user3', 'user3@test.com', sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(4,'user4', 'user4@test.com', sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(5,'user5', 'user5@test.com', sha2('1111',256));
insert into app_member(mno,name,email,pwd) values(6,'admin', 'admin@test.com', sha2('1111',256));

-- 회원 게시글 데이터 입력
insert into app_board(bno,title,cont,mno) values(11, '제목1', '내용', 1);
insert into app_board(bno,title,cont,mno) values(12, '제목2', '내용', 1);
insert into app_board(bno,title,cont,mno) values(13, '제목3', '내용', 1);
insert into app_board(bno,title,cont,mno) values(14, '제목4', '내용', 2);
insert into app_board(bno,title,cont,mno) values(15, '제목5', '내용', 2);
insert into app_board(bno,title,cont,mno) values(16, '제목6', '내용', 4);

-- 1:1 문의 게시글 데이터 입력
insert into app_inquiry_board(iq_no, iq_title, iq_cont, iq_type, mno) values(21, '1:1문의 게시판', '1:1문의 게시판 내용', '재능 판매 및 구매/콘테스트/기타', 1);
insert into app_inquiry_board(iq_no, iq_title, iq_cont, iq_type, mno) values(22, '1:1문의 게시판', '1:1문의 게시판 내용', '재능 판매 및 구매/콘테스트/기타', 1);
insert into app_inquiry_board(iq_no, iq_title, iq_cont, iq_type, mno) values(23, '1:1문의 게시판', '1:1문의 게시판 내용', '재능 판매 및 구매/콘테스트/기타', 1);
insert into app_inquiry_board(iq_no, iq_title, iq_cont, iq_type, mno) values(24, '1:1문의 게시판', '1:1문의 게시판 내용', '재능 판매 및 구매/콘테스트/기타', 2);
insert into app_inquiry_board(iq_no, iq_title, iq_cont, iq_type, mno) values(25, '1:1문의 게시판', '1:1문의 게시판 내용', '재능 판매 및 구매/콘테스트/기타', 2);
insert into app_inquiry_board(iq_no, iq_title, iq_cont, iq_type, mno) values(26, '1:1문의 게시판', '1:1문의 게시판 내용', '재능 판매 및 구매/콘테스트/기타', 4);