DROP TABLE IF EXISTS member;

-- 공모전
DROP TABLE IF EXISTS contest;

-- 재능판매
DROP TABLE IF EXISTS product;

-- 재능 판매 첨부파일
DROP TABLE IF EXISTS product_file;

-- 공모전 첨부파일
DROP TABLE IF EXISTS contest_file;

-- 공지사항
DROP TABLE IF EXISTS notice;

-- 포트폴리오
DROP TABLE IF EXISTS portfolio;

-- 재능판매카테고리
DROP TABLE IF EXISTS product_category;

-- 1 : 1 문의
DROP TABLE IF EXISTS qna;

-- 문의카테고리
DROP TABLE IF EXISTS qna_category;

-- 후기 게시판
DROP TABLE IF EXISTS product_review;

-- 후기 첨부파일
DROP TABLE IF EXISTS product_review_file;

-- 공모전 카테고리
DROP TABLE IF EXISTS contest_category;

-- 포트폴리오 첨부파일
DROP TABLE IF EXISTS portfolio_file;

-- 1 : 1 문의 첨부파일
DROP TABLE IF EXISTS qna_file;

-- 주최기관
DROP TABLE IF EXISTS contest_organization;

-- 위시리스트
DROP TABLE IF EXISTS wishlist;

-- 팀원모집
DROP TABLE IF EXISTS team;

-- 팀원모집분야지원
DROP TABLE IF EXISTS team_field_member;

-- 모집분야
DROP TABLE IF EXISTS team_field;

-- FAQ
DROP TABLE IF EXISTS faq;

-- 관심사
DROP TABLE IF EXISTS onemoa_interest;

-- 관리자
DROP TABLE IF EXISTS admin_member;

-- 주문내역
DROP TABLE IF EXISTS product_order;

-- 1대1문의
DROP TABLE IF EXISTS message;

-- 직업
DROP TABLE IF EXISTS job;

-- 1대1문의 첨부파일
DROP TABLE IF EXISTS message_file;