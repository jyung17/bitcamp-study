-- 회원
DROP TABLE IF EXISTS member RESTRICT;

-- 공모전
DROP TABLE IF EXISTS contest RESTRICT;

-- 재능판매
DROP TABLE IF EXISTS product RESTRICT;

-- 재능 판매 첨부파일
DROP TABLE IF EXISTS product_file RESTRICT;

-- 공모전 첨부파일
DROP TABLE IF EXISTS contest_file RESTRICT;

-- 공지사항
DROP TABLE IF EXISTS notice RESTRICT;

-- 포트폴리오
DROP TABLE IF EXISTS portfolio RESTRICT;

-- 재능판매카테고리
DROP TABLE IF EXISTS product_category RESTRICT;

-- 1 : 1 문의
DROP TABLE IF EXISTS qna RESTRICT;

-- 문의카테고리
DROP TABLE IF EXISTS qna_category RESTRICT;

-- 후기 게시판
DROP TABLE IF EXISTS product_review RESTRICT;

-- 후기 첨부파일
DROP TABLE IF EXISTS product_review_file RESTRICT;

-- 공모전 카테고리
DROP TABLE IF EXISTS contest_category RESTRICT;

-- 포트폴리오 첨부파일
DROP TABLE IF EXISTS portfolio_file RESTRICT;

-- 1 : 1 문의 첨부파일
DROP TABLE IF EXISTS qna_file RESTRICT;

-- 주최기관
DROP TABLE IF EXISTS contest_organization RESTRICT;

-- 위시리스트
DROP TABLE IF EXISTS wishlist RESTRICT;

-- 팀원모집
DROP TABLE IF EXISTS team RESTRICT;

-- 팀원모집분야지원
DROP TABLE IF EXISTS team_field_member RESTRICT;

-- 모집분야
DROP TABLE IF EXISTS team_field RESTRICT;

-- FAQ
DROP TABLE IF EXISTS faq RESTRICT;

-- 관심사
DROP TABLE IF EXISTS interest RESTRICT;

-- 관리자
DROP TABLE IF EXISTS admin_member RESTRICT;

-- 주문내역
DROP TABLE IF EXISTS product_order RESTRICT;

-- 1대1대화
DROP TABLE IF EXISTS message RESTRICT;

-- 직업
DROP TABLE IF EXISTS job RESTRICT;

-- 1대1대화 첨부파일
DROP TABLE IF EXISTS message_file RESTRICT;