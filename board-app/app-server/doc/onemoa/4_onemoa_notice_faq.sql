-- 포트폴리
INSERT INTO onemoa.portfolio (ptno, mno, title, cont, cdt) VALUES (1, 1, '명함디자인', '제가 직접 디자인한 명함입니다.
심플한 디자인이 포인트이고 고급스러운 느낌을
주기 위해 무게감 있는 색상을 사용하여 
그 분위기를 더해주었습니다.', '2022-11-21');
INSERT INTO onemoa.portfolio (ptno, mno, title, cont, cdt) VALUES (2, 1, '패키지디자인', '제가 디자인한 패키지 디자인입니다.
각 상품들이 돋보일 수 있도록 디자인하였고 고급스러운 느낌을
주기 위해 무게감 있는 색상을 사용하여 그 분위기를 더해주었습니다.
', '2022-11-21');
INSERT INTO onemoa.portfolio (ptno, mno, title, cont, cdt) VALUES (3, 1, '일러스트 디자인', '제가 그린 삽화입니다.
부드럽고 따뜻한 색감을 사용하여 포근한 느낌으로 그렸습니다.

', '2022-11-21');
INSERT INTO onemoa.portfolio (ptno, mno, title, cont, cdt) VALUES (4, 2, '제품 촬영', '제가 찍은 제품 사진입니다.
상품이 최대한 잘 부각되도록 촬영하였고
직접 보정까지한 작품입니다.

', '2022-11-21');
INSERT INTO onemoa.portfolio (ptno, mno, title, cont, cdt) VALUES (5, 2, '로고 디자인', '제가 직접 디자인한 로고입니다.
심플한 디자인이 포인트이고 고급스러운 느낌을
주기 위해 무게감 있는 색상을 사용하여 
그 분위기를 더해주었습니다.', '2022-11-21');
INSERT INTO onemoa.portfolio (ptno, mno, title, cont, cdt) VALUES (6, 3, '로고 디자인', '심플한 디자인이 포인트이고 고급스러운 느낌을
주기 위해 무게감 있는 색상을 사용하여 
그 분위기를 더해주었습니다.', '2022-11-21');
INSERT INTO onemoa.portfolio (ptno, mno, title, cont, cdt) VALUES (7, 3, '메뉴판 제작', '제가 디자인한 메뉴판입니다.
심플한 디자인이 포인트이고 맛깔스러운 색감을 사용하여
메뉴들이 돋보이게 디자인하였습니다.', '2022-11-21');


-- 포트폴리오 첨부파일
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (1, '명함1.png', '8f888d0f-b23a-447e-8337-4df38c34fe63', 1);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (2, '명함2.png', '3346abdf-2e75-447f-9095-5dfd2446cb67', 1);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (3, '명함3.png', 'e4c4a111-23af-4887-919e-ede64cf8e1b4', 1);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (4, '명함4.png', 'f4f1eacb-96e6-4697-bf33-b8eaa2741fb7', 1);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (5, '명함5.png', 'e3270608-2f0c-405c-8157-bc3ade7555f5', 1);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (6, '스크린샷 2022-11-21 오후 5.09.43.png', 'b27b3614-1494-4120-80e1-a98504ff1fec', 2);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (8, '스크린샷 2022-11-21 오후 5.09.59.png', '7dab3ded-ea4b-4832-86aa-48149c72edf5', 2);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (9, '스크린샷 2022-11-21 오후 5.10.06.png', '76a3e9d2-0d42-41d2-b130-6cc1b99f25b2', 2);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (10, '스크린샷 2022-11-21 오후 5.10.33.png', '6b93879c-5a3c-4c36-ae06-5b73f7748b72', 2);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (11, '스크린샷 2022-11-21 오후 5.19.10.png', '4062a7a7-73d0-490e-bf5d-6fb021f6abda', 3);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (12, '스크린샷 2022-11-21 오후 5.19.15.png', '0ab4be02-2f0c-4b73-866f-1a1825bd235f', 3);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (13, '스크린샷 2022-11-21 오후 5.19.24.png', 'ab3a4f56-a1d5-4846-8697-c56f9e81997b', 3);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (14, '스크린샷 2022-11-21 오후 5.23.47.png', 'b0dc5f31-2e8b-4fdb-bc27-31e4c9d2e376', 4);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (15, '스크린샷 2022-11-21 오후 5.23.56.png', '5978c6ea-05d8-43c4-a535-759c2f9cfb76', 4);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (16, '스크린샷 2022-11-21 오후 5.24.02.png', 'e506766d-569f-4400-88e7-129bddf381a9', 4);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (17, '스크린샷 2022-11-21 오후 5.24.09.png', 'c204db01-3db9-4711-8dec-21807257f4fc', 4);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (18, '스크린샷 2022-11-21 오후 5.30.31.png', 'de734606-6bb0-430e-8099-950cfdab59b6', 5);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (19, '스크린샷 2022-11-21 오후 5.30.43.png', '143d21fc-7b7b-4abf-a0af-74900b31c607', 5);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (20, '스크린샷 2022-11-21 오후 5.31.04.png', '1a83f737-7d3a-45e2-978d-721eb8af9135', 5);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (21, '스크린샷 2022-11-21 오후 5.34.14.png', 'df35448e-c940-4c52-8ff1-57b466736944', 6);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (22, '스크린샷 2022-11-21 오후 5.34.20.png', 'aa40e264-dda8-4626-bd8e-5cdbb53c3463', 6);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (23, '스크린샷 2022-11-21 오후 5.34.29.png', '2d4f91bc-9bff-4a36-90c4-a2d5795c4c37', 6);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (24, '스크린샷 2022-11-21 오후 5.35.36.png', '7fede83f-bb6b-43f8-9e49-101eec851a3d', 7);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (25, '스크린샷 2022-11-21 오후 5.35.43.png', '7c3a9121-20b8-4157-af7e-8c7a3244a50d', 7);
INSERT INTO onemoa.portfolio_file (ptfno, fname, fpath, ptno) VALUES (26, '스크린샷 2022-11-21 오후 5.36.00.png', '334f5ac8-f57a-4cd6-a4e6-0d0f44939cee', 7);
