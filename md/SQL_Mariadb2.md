```sql
-- 수강생
CREATE TABLE stnt (
    mno    INTEGER     NOT NULL COMMENT '수강생번호', -- 수강생번호
    work   CHAR(1)     NOT NULL COMMENT '재직여부', -- 재직여부
    acc_no VARCHAR(20) NULL     COMMENT '통장번호', -- 통장번호
    bank   VARCHAR(50) NULL     COMMENT '은행명' -- 은행명
)
COMMENT '수강생';

-- 수강생
-- 수강생 테이블의 mno 컬럼에 PK_stnt 기본키로 설정
ALTER TABLE stnt
    ADD CONSTRAINT PK_stnt -- 수강생 기본키
        PRIMARY KEY (
            mno -- 수강생번호
        );
alter table stnt add constraint PK_stnt primary key(mno);

-- 수강생 유니크 인덱스
CREATE UNIQUE INDEX UIX_stnt
    ON stnt ( -- 수강생
        acc_no ASC, -- 통장번호
        bank ASC    -- 은행명
    );

```
