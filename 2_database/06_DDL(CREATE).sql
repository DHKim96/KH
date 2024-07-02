/*
    * DDL
        : 데이터 정의 언어
          오라클에서 제공하는 객체를 새로 만들고(CREATE)
                                구조를 변경하고(ALTER)
                                구조 자체를 삭제(DELETE)
         즉, 실제 데이터 값이 아닌 규칙 자체를 정의하는 언어
         
         오라클에서의 객체(구조)
            : 테이블, 뷰, 시퀀스, 인덱스, 패키지, 트리거, 프로시저, 함수, 동의어, 사용자
            
        <CREATE>
            : 객체를 새로 생성하는 구문
*/

/*
    1. 테이블 생성
        1.1. 테이블이란?
                : 행과 열로 구성되는 가장 기본적인 데이터베이스 객체
                  모든 데이터들은 테이블을 통해서 저장됨
                  (DBMS 용어 중 하나로, 데이터를 일종의 표 형태로 표현한 것)
        1.2. 테이블 생성
                : CREATE TABLE 테이블명(
                        컬럼명 자료형(크기),
                        컬럼명 자료형(크기),
                        컬럼명 자료형, ...
                    }
                * 자료형
                    - 문자(CHAR(바이트 크기) | VARCHAR2(바이트 크기))
                        **CHAR
                            : 최대 2000BYTE까지 지정 가능
                              고정길이(고정된 글자 수의 데이터가 담길 경우)
                              지정한 크기보다 더 작은 값이 들어오면 공백으로라도 채워서 처음 지정한 크기를 만들어줌
                        **VARCHAR2
                            : 최대 4000BYTE까지 지정 가능
                              가변길이(몇 글자의 데이터가 담길지 모르는 경우)
                              담긴 값에 따라서 공간 크기가 맞춰짐
                    - 숫자(NUMBER)
                    - 날짜(DATE)
                    
               
*/
             
-- 회원에 대한 데이터를 담기 위한 테이블 MEMBER 생성
CREATE TABLE MEMBER(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20),
    MEM_PWD VARCHAR2(20),
    MEM_NAME VARCHAR2(20),
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    MEM_DATE DATE
);

SELECT * FROM MEMBER;

DROP TABLE MEMBER;

/* 
    데이터 딕셔너리
        : 다양한 객체들의 정보를 저장하고 있는 시스템 테이블
*/

SELECT * FROM USER_TABLES;
SELECT * FROM USER_TAB_COLUMNS;
--------------------------------------------------------------------------------
/*
    2. 컬럼에 주석달기(컬럼에 대한 간단한 설명)
    
        [표현법]
        COMMENT ON COLUMN 테이블명.컬럼명 IS '주석내용';
        (잘못 작성 시 새로 수정 가능)
*/

    COMMENT ON COLUMN MEMBER.MEM_NO IS '회원번호';
    -- > MEMBER 테이블 MEN_NO 컬럼에 회원번호라는 코멘트가 달림
    COMMENT ON COLUMN MEMBER.MEM_ID IS '회원아이디';
    COMMENT ON COLUMN MEMBER.MEM_PWD IS '회원비밀번호';
    COMMENT ON COLUMN MEMBER.MEM_NAME IS '회원명';
    COMMENT ON COLUMN MEMBER.GENDER IS '성별(남/여)';
    COMMENT ON COLUMN MEMBER.PHONE IS '전화번호';
    COMMENT ON COLUMN MEMBER.EMAIL IS '이메일';
    COMMENT ON COLUMN MEMBER.MEM_DATE IS '회원가입일';

/* 
    테이블 삭제하고자 할 때
       : DROP TABLE 테이블명;
*/
DROP TABLE MEMBER;

/*
    테이블에 데이터를 추가하는 구문
        : INSERT INTO 테이블명 VALUES(값1, 값2, ...)
            (이때 값들은 컬럼 순서대로 그에 맞는 타입의 데이터들을 기입해야 함)
*/

INSERT INTO MEMBER
VALUES(1, 'USER1', 'PASS1', '홍길동', '남', '010-1111-2222', 'AAAA@NAVER.COM', '24/02/23');
    
SELECT * FROM MEMBER;

INSERT INTO MEMBER
VALUES(2, 'USER2', 'PASS2', '홍길순', NULL, NULL, NULL, SYSDATE);

--------------------------------------------------------------------------------
/*
    <제약 조건>
        : 원하는 데이터값(유효한 형식의 값)만 유지하기 위해서 특정 컬럼에 설정하는 제약
          데이터 무결성 보장을 목적으로 함
          
          제약조건을 부여하는 방식은 크게 2가지 존재(컬럼 레벨 방식 / 테이블 레벨 방식)
          
    1. 종류
        : NOT NULL, UNIQUE, CHECK, PRIMARY KEY, FOREIGN KEY
*/

/*
    1.1. NOT NULL 제약조건
        : 해당 컬럼에 반드시 값이 존재해야만 할 경우(즉, 절대 NULL이 들어오면 안되는 경우)
          삽입 / 수정 시 NULL 값을 허용하지 않도록 제한
        
         NOT NULL 은 무조건 컬럼 레벨 방식으로만 가능
*/


CREATE TABLE MEM_NOTNULL(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL,
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50)
);

INSERT INTO MEM_NOTNULL
VALUES(1, 'USER1', 'PASS1', '홍길동', '남', '010-1111-2222', 'AAAA@NAVER.COM');

SELECT * FROM MEM_NOTNULL;

INSERT INTO MEM_NOTNULL
VALUES(2, 'USER2', 'PASS2', '홍길순', NULL, NULL, NULL);

INSERT INTO MEM_NOTNULL
VALUES(2, NULL, 'PASS2', '홍길순', NULL, NULL, NULL);
-- 아이디에 NULL 을 기입하자 의도된 오류 발생(NOT NULL 제약조건에 위배되어 오류 발생)

INSERT INTO MEM_NOTNULL
VALUES(3, 'USER2', 'PASS2', '홍길순', NULL, NULL, NULL);
-- 아이디가 중복되었음에도 불구하고 추가됨

-----------------------------------------------------------------------------
/*
    1.2. UNIQUE 제약조건
        : 해당 컬럼에 중복된 값이 들어가서는 안될 경우 사용
          컬럼값에 중복값을 제한하는 제약조건
          삽입 / 수정 시 기존에 있는 데이터값 중 중복값이 있을 경우 오류를 발생시킴
          컬럼 레벨 / 테이블 레벨 모두 사용 가능
*/
DROP TABLE MEM_UNIQUE;

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER NOT NULL,
    MEM_ID VARCHAR2(20) NOT NULL UNIQUE, -- 컬럼 레벨 방식
    MEM_PWD VARCHAR2(20) NOT NULL,
    MEM_NAME VARCHAR2(20) NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50)
    -- UNIQUE(MEM_ID) -- 테이블 레벨 방식
);

INSERT INTO MEM_UNIQUE
VALUES(1, 'USER1', 'PASS1', '홍길동', '남', '010-1111-2222', 'AAAA@NAVER.COM');


SELECT * FROM MEM_UNIQUE;

INSERT INTO MEM_UNIQUE
VALUES(2, 'USER1', 'PASS2', '홍길순', '여', NULL, NULL);
-- UNIQUE 제약 조건에 위배되었으므로 INSERT 실패
-- 오류 unique constraint (KH.SYS_C007028) violated 에서
-- SYS_C007028 은 제약 조건의 이름임
-- > 쉽게 파악하기가 어려움
--> 제약조건 부여시 제약 조건명을 지정해주지 않으면 시스템에서 이름을 부여함

--------------------------------------------------------------------------------
/*
    * 제약조건 부여시 제약조건명까지 지어주는 방법
    
     > 컬럼레벨방식
        CREATE TABLE 테이블명(
            컬럼명 자료형 [CONSTRAINT 제약조건명] 제약조건
        )
        
    > 테이블 레벨 방식
        CREATE TABLE 테이블명(
            컬럼명 자료형,
            컬럼명 자료형,
            [CONSTRAINT 제약조건명] 제약조건(컬럼명)
        )
*/
DROP TABLE MEM_UNIQUE;

CREATE TABLE MEM_UNIQUE(
    MEM_NO NUMBER CONSTRAINT MEMNO_NT NOT NULL,
    MEM_ID VARCHAR2(20) CONSTRAINT MEMID_NT NOT NULL, -- 컬럼 레벨 방식
    MEM_PWD VARCHAR2(20) CONSTRAINT MEMPWD_NT NOT NULL,
    MEM_NAME VARCHAR2(20) CONSTRAINT MEMNAME_NT NOT NULL,
    GENDER CHAR(3),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    CONSTRAINT MEMID_UQ UNIQUE(MEM_ID) -- 테이블 방식
);

INSERT INTO MEM_UNIQUE
VALUES(1, 'USER1', 'PASS1', '홍길동', '남', '010-1111-2222', 'AAAA@NAVER.COM');

INSERT INTO MEM_UNIQUE
VALUES(2, 'USER2', 'PASS2', '홍길순', '여', NULL, NULL);

INSERT INTO MEM_UNIQUE
VALUES(3, 'USER3', 'PASS3', '김개똥', NULL, NULL, NULL);

INSERT INTO MEM_UNIQUE
VALUES(4, 'USER4', 'PASS4', '최개똥', NULL, NULL, NULL);

SELECT * FROM MEM_UNIQUE;

--------------------------------------------------------------------------------
/*
    1.3. CHECK(조건식)
        : 해당 컬럼에 들어올 수 있는 값에 대한 조건을 제시해둘 수 있음
          해당 조건에 만족하는 데이터값만 담길 수 있음
          컬럼레벨 테이블레벨 가능
*/

CREATE TABLE MEM_CHECK(
    MEM_NO NUMBER  NOT NULL,
    MEM_ID VARCHAR2(20)  NOT NULL,
    MEM_PWD VARCHAR2(20)  NOT NULL,
    MEM_NAME VARCHAR2(20)  NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남', '여')), -- 남, 여
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    UNIQUE(MEM_ID)
    -- CHECK(GENDER IN ('남', '여')) 가능
);

INSERT INTO MEM_CHECK
VALUES(1, 'USER1', 'PASS1', '홍길동', '남', '010-1111-2222', 'AAAA@NAVER.COM');

SELECT * FROM MEM_CHECK;

INSERT INTO MEM_CHECK
VALUES(2, 'USER2', 'PASS2', '홍길순', 'ㅇ', NULL, NULL);
--> CHECK 제약 조건에 위배되어 에러 발생
--> 만일 GENDER 컬럼에 데이터를 넣고자 한다면 CHECK 제약 조건에 만족하는 값을 넣어야 함

INSERT INTO MEM_CHECK
VALUES(2, 'USER2', 'PASS2', '홍길순', NULL, NULL, NULL);
--> NULL은 값 자체가 없다는 의미이기 때문에 CHECK 제약 조건에서 걸러지지 않고
--> 따로 NOT NULL 조건을 부여해야 거를 수 있음

--------------------------------------------------------------------------------
/*
    1.4. PRIMARY KEY(기본키) 제약조건
        : 테이블에서 각 행(ROW)을 식별하기 위해 사용될 컬럼에 부여하는 제약 조건(식별자 역할)
        
          EX) 회원번호, 학번, 군번, 부서코드, 직급코드, 주문번호, 택배운송장번호, 예약번호 등등 ...
          
          PRIMARY KEY 제약 조건을 부여 -> NOT NULL + UNIQUE 와 같음
          
          ※ 유의사항
            : 한 테이블당 오직 한 개만 설정 가능
*/

CREATE TABLE MEM_PRI(
    MEM_NO NUMBER CONSTRAINT MEMNO_PK PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL,
    MEM_PWD VARCHAR2(20)  NOT NULL,
    MEM_NAME VARCHAR2(20)  NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남', '여')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    UNIQUE(MEM_ID)
    -- 또는 PRIMARY KEY(MEM_NO)
);

INSERT INTO MEM_PRI
VALUES(1, 'USER1', 'PASS1', '홍길동', '남', '010-1111-2222', 'AAAA@NAVER.COM');

INSERT INTO MEM_PRI
VALUES(1, 'USER2', 'PASS2', '홍길순', '여', NULL, NULL);
-- > 기본키에 중복값을 담으려고 할 때 unique 제약조건 위반 오류 보고

INSERT INTO MEM_PRI
VALUES(NULL, 'USER2', 'PASS2', '홍길순', '여', NULL, NULL);
-- > 기본키에 NULL 을 담으려고 할 때 NOT NULL 제약조건 위반 오류 보고

INSERT INTO MEM_PRI
VALUES(2, 'USER2', 'PASS2', '홍길순', '여', NULL, NULL);

CREATE TABLE MEM_PRI2(
    MEM_NO NUMBER,
    MEM_ID VARCHAR2(20)  NOT NULL,
    MEM_PWD VARCHAR2(20)  NOT NULL,
    MEM_NAME VARCHAR2(20)  NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남', '여')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    UNIQUE(MEM_ID),
    PRIMARY KEY(MEM_NO, MEM_ID)
);
/* 
    1.4.1. 복합키
        : 두 개 이상의 컬럼을 동시에 하나의 기본키로 지정하는 것
*/
INSERT INTO MEM_PRI2 VALUES(1, 'USER1', 'PASS1', '홍길동', NULL, NULL, NULL);
INSERT INTO MEM_PRI2 VALUES(1, 'USER2', 'PASS2', '홍길순', NULL, NULL, NULL);
INSERT INTO MEM_PRI2 VALUES(2, 'USER3', 'PASS3', '홍길순', NULL, NULL, NULL);

-- 복합키 사용 예시(어떤 회원이 어떤 상품을 찜하는지에 대한 데이터를 보관하는 테이블)
CREATE TABLE TB_LIKE(
    MEM_NO NUMBER,
    PRODUCT_NAME VARCHAR2(10),
    LIKE_DATE DATE,
    PRIMARY KEY(MEM_NO, PRODUCT_NAME)
);
-- 회원 2명(1번, 2번) 존재
-- 가방A, 가방B 상품 존재

INSERT INTO TB_LIKE VALUES(1, '자전거A', SYSDATE);
SELECT * FROM TB_LIKE;
INSERT INTO TB_LIKE VALUES(1, '자전거B', SYSDATE);
INSERT INTO TB_LIKE VALUES(1, '자전거A', SYSDATE);
-- > UNIQUE 오류 발생 WHY? MEM_NO, PRODUCT_NAME 양자가 모두 같기 때문에

-------------------------------------------------------------------------------

-- 회원등급에 대한 데이터를 따로 보관하는 테이블
CREATE TABLE MEM_GRADE(
    GRADE_CODE NUMBER PRIMARY KEY,
    GRADE_NAME VARCHAR2(30) NOT NULL
);

DROP TABLE MEM_GRADE;

INSERT INTO MEM_GRADE VALUES (10, '일반회원');
INSERT INTO MEM_GRADE VALUES (20, '우수회원');
INSERT INTO MEM_GRADE VALUES (30, '특별회원');


CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20)  NOT NULL,
    MEM_NAME VARCHAR2(20)  NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남', '여')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', '홍길순', '여', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2, 'USER2', 'PASS02', '홍길동', '남', NULL, NULL, 10);
INSERT INTO MEM VALUES(3, 'USER3', 'PASS03', '강아지', NULL, NULL, NULL, 10);
INSERT INTO MEM VALUES(4, 'USER4', 'PASS04', '최지원', NULL, NULL, NULL, 40);
--- 유효한 회원등급번호가 아니어도 INSERT가 잘됨

--------------------------------------------------------------------------------
/*
        1.5. FOREIGN KEY(외래키) 제약 조건
            : 다른 테이블에 존재하는 값만 들어와야하는 특정 컬럼에 부여하는 제약 조건
             -> 다른 테이블을 참조한다고 표현
             -> 주로 FOREIGN KEY 제약 조건으로 인해 테이블 간 관계 형성
             
             > 컬럼레벨방식
             컬럼명 자료형 REFERENCES 참조할 테이블명[(참조할 컬럼명)]
           
             > 테이블레벨방식
             FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명[(참조할 컬럼명)]
             
             -> 참조할 컬럼명 생략 시 참조할 테이블에 PRIMARY KEY 로 지정된 컬럼이 매칭됨
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20)  NOT NULL,
    MEM_NAME VARCHAR2(20)  NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남', '여')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE)
    -- FOREIGN KEY(GRADE_ID) REFERENCES MEM_GRADE(GRADE_CODE)
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', '홍길동', '남', NULL, NULL, NULL);
-- 외래키인 GRADE_ID 에 NULL 값 기입해도 입력됨
INSERT INTO MEM VALUES(2,'USER2', 'PASS02', '홍길순', '여', NULL, NULL, 10);

INSERT INTO MEM VALUES(3,'USER3', 'PASS03', '최개똥', '여', NULL, NULL, 40);
--> PARENT KEY 찾을 수 없다는 오류 보고

SELECT * FROM MEM;
-- MEM_GRADE(부모테이블) -|-------<- MEM(자식테이블)
--      1:N 관계 1쪽이 부모테이블 N쪽이 자식테이블

INSERT INTO MEM VALUES(3,'USER3', 'PASS03', '김개똥', '여', NULL, NULL, 20);

INSERT INTO MEM VALUES(4,'USER4', 'PASS04', '최배달', '남', NULL, NULL, 10);

--> 이때 부모테이블에서 데이터값을 삭제하면 어떻게 될까?
-- 데이터 삭제 : DELECT FROM 테이블명 WHERE 조건;
DELETE FROM MEM_GRADE
WHERE GRADE_CODE = '10';
-- 오류 WHY? 자식테이블에서 10이라는 값을 사용하고 있기 때문에 삭제가 안됨

DELETE FROM MEM_GRADE
WHERE GRADE_CODE = '30';
--> 자식테이블에서 30이라는 값을 사용하고 있지 않기 때문에 삭제가 됨

--> 자식테이블에 이미 사용하고 있는 값이 있을 경우 
--> 부모테이블로부터 무조건 삭제가 안되는 "삭제제한" 옵션이 걸려있음

ROLLBACK;

/*
    자식테이블 생성시 외래키 제약조건 부여할 때 삭제옵션 지정 가능
    * 삭제 옵션
        : 부모테이블의 데이터 삭제시 그 데이터를 사용하고 있는 자식테이블의 값을 어떻게 할 것인가?
        
        - ON DELETE RESTRICTED(기본값)
            : 삭제 제한 옵션, 자식데이터로부터 쓰이는 부모데이터는 삭제가 안됨
        - ON DELETE SET NULL
            : 부모데이터 삭제시 해당 데이터를 사용하고 있는 자식데이터의 값을 NULL 로 변경
        - ON DELETE CASCADE
            : 부모데이터 삭제시 해당 데이터를 사용하고 있는 자식데이터도 같이 삭제시키는 옵션
*/

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20)  NOT NULL,
    MEM_NAME VARCHAR2(20)  NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남', '여')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE
);


INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', '홍길동', '남', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2,'USER2', 'PASS02', '홍길순', '여', NULL, NULL, 10);
INSERT INTO MEM VALUES(3,'USER3', 'PASS03', '김개똥', '여', NULL, NULL, 20);
INSERT INTO MEM VALUES(4,'USER4', 'PASS04', '최배달', '남', NULL, NULL, 10);

-- 10번 등급 삭제
DELETE FROM MEM_GRADE
WHERE GRADE_CODE = '10';
--> 잘 삭제가 완료됨, 10을 가져다 쓰고있던 자식데이터의 값은 NULL 로 변경됨

ROLLBACK;

DROP TABLE MEM;

CREATE TABLE MEM(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_ID VARCHAR2(20)  NOT NULL UNIQUE,
    MEM_PWD VARCHAR2(20)  NOT NULL,
    MEM_NAME VARCHAR2(20)  NOT NULL,
    GENDER CHAR(3) CHECK(GENDER IN ('남', '여')),
    PHONE VARCHAR2(13),
    EMAIL VARCHAR2(50),
    GRADE_ID NUMBER REFERENCES MEM_GRADE(GRADE_CODE) ON DELETE CASCADE
);

INSERT INTO MEM VALUES(1, 'USER1', 'PASS01', '홍길동', '남', NULL, NULL, NULL);
INSERT INTO MEM VALUES(2,'USER2', 'PASS02', '홍길순', '여', NULL, NULL, 10);
INSERT INTO MEM VALUES(3,'USER3', 'PASS03', '김개똥', '여', NULL, NULL, 20);
INSERT INTO MEM VALUES(4,'USER4', 'PASS04', '최배달', '남', NULL, NULL, 10);

-- 10번 등급
DELETE FROM MEM_GRADE WHERE GRADE_CODE = '10';
-- > 삭제가 잘됨
-- 해당 데이터를 사용하고 있던 자식데이터도 같이 삭제가 됨

---------------------------------------------------------------------------------
/*
    <DEFAULT 기본값> *제약조건은 아님
        : 컬럼을 선정하지않고 NULL 이 아닌 기본값을 INSERT 하고자 할 때 세팅해둘 수 있는 값이 기본값
        [표현법]
          컬럼명 자료형 DEFAULT 기본값
*/

CREATE TABLE MEMBER(
    MEM_NO NUMBER PRIMARY KEY,
    MEM_NAME VARCHAR2(20) NOT NULL,
    MEM_AGE NUMBER,
    HOBBY VARCHAR2(20) DEFAULT '없음',
    ENROLL_DATE DATE DEFAULT SYSDATE
);

-- INSERT INTO 테이블명 VALUES(값1, 값2, ...)
INSERT INTO MEMBER VALUES(1, '빵빵이', 20, '운동', '20/01/01');
INSERT INTO MEMBER VALUES(2, '옥지', 22, NULL, NULL);
-- > NULL 값으로 나옴
INSERT INTO MEMBER VALUES(3, '최지원', 17, DEFAULT, DEFAULT);

SELECT * FROM MEMBER;

-- INSERT INTO MEMBER(컬럼1, 컬럼2, ...) VALUES(컬럼1값, 컬럼2값, ...)
-- 내가 원하는 컬럼에만 데이터를 넣어줄 수 있음
INSERT INTO MEMBER(MEM_NO, MEM_NAME) VALUES(4, '이광인');
-- > 선택되지 않은 컬럼에는 기본적으로 NULL 이 들어감
-- > 단, 해당 컬럼에 DEFAULT 값이 부여되어 있을 시 NULL 값 대신 DEFAULT 값이 들어감

-------------------------------------------------------------------------------------
-- 테이블을 복제할 수 있다.
CREATE TABLE EMPLOYEE_COPY
AS (SELECT * FROM EMPLOYEE);

DROP TABLE EMPLOYEE_COPY;
-------------------------------------------------------------------------------
/*
    *테이블이 다 생성된 후에 뒤늦게 제약조건을 추가한느 방법
        ALTER TABLE 테이블명 변경할 내용
        
        - PRIMARY KEY : ALTER TABLE 테이블명 ADD PRIMARY KEY(컬럼명);
        - FOREIGN KEY : ALTER TABLE 테이블명 ADD FOREIGN KEY(컬럼명) REFERENCES 참조할 테이블명[(참조할 컬럼명)]
        - UNIQUE : ALTER TABLE 테이블명 ADD UNIQUE(컬럼명);
        - CHECK : ALTER TABLE 테이블명 ADD CHECK(컬럼명);
        - NOT NULL : ALTER TABLE 테이블명 MODIFY 컬럼명 NOT NULL;
*/

-- EMPLOYEE_COPY 테이블에 PRIMARY KEY 제약조건을 추가(EMP_ID)
ALTER TABLE EMPLOYEE_COPY ADD PRIMARY KEY(EMP_ID);
ALTER TABLE EMPLOYEE_COPY DROP PRIMARY KEY;
-- 삭제도 가능하나 삭제시킬일이 거의 없음

-- EMPLOYEE테이블에 DEPT_CODE에 외래키 제약조건 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(DEPT_CODE) REFERENCES DEPARTMENT(DEPT_ID);

-- EMPLOYEE테이블에 JOB_CODE에 외래키 제약조건 추가
ALTER TABLE EMPLOYEE ADD FOREIGN KEY(JOB_CODE) REFERENCES JOB(JOB_CODE);

-- DEPARTMENT 테이블에 LOCATION_ID 에 외래키 제약조건 추가
ALTER TABLE DEPARTMENT ADD FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION(LOCAL_CODE);
