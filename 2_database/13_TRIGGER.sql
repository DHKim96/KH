/*
    <트리거>
        : 내가 지정한 테이블에 INSERT, UPDATE, DELETE 등 DML문에 의해 변경사항이 생길 떼
          (테이블에 이벤트가 발생했을 때)
          자동으로 매번 실행할 내용을 미리 정의해 둘 수 있다.
          
          EX)1. 회원 탈퇴 시 기존 회원 테이블에 데이터 DELETE 후 곧바로 탈퇴한
              회원들만 따로 보관하는 테이블에 자동으로 INSERT 시켜야함
             2. 신고횟수가 일정 수 넘었을 시 묵시적으로 해당 회원을 블랙리스트로 처리되게끔함
             3. 입출고에 대한 데이터가 기록(INSERT)될때마다 해당 상품에 대한 재고수량을 매번
                수정(UPDATE)해야함
          
          * 트리거 종류
            - SQL문 실행 시기에 따른 분류
                > BEFORE TRIGGER
                    : 내가 지정한 테이블에 이벤트가 발생되기 전에 트리거 실행
                > AFTER TRIGGER
                    : 내가 지정한 테이블에 이벤트가 발생된 후 트리거 실행
                
               이벤트 발생이란? 트랜잭션이 COMMIT 된 이후?
                
            - SQL문에 의해 영향을 받는 각 행에 따른 분류
                > 문장 트리거
                    : 이벤트가 발생한 SQL문에 대해 딱 한 번만 트리거 실행
                > 행트리거
                    : 해당 SQL문 실행시마다 매번 트리거 실행
                      (FOR EACH ROW옵션 기술해야함)
                      > :OLD - BEFORE UPDATE(수정전자료), BEFORE DELETE(삭제전 자료)
                      > :NEW - AFTER UPDATE(수정후자료), AFTER DELETE(삭제 후 자료)
            
            * 트리거 생성 구문
                [표현식]
                CREATE [OR REPLACE] TRIGGER 트리거명
                BEFORE | AFTER   INSERT | UPDATE | DELETE ON 테이블명
                [FOR EACH ROW]
                [DECLARE 변수 선언]
                BEGIN
                    실행내용(해당 위에 지정된 이벤트 발생시 묵시적으로 실행할 구문)
                [EXCEPTION 예외처리]
                END;
                /  
*/

-- EMPLOYEE 테이블에 새로운 행이 INSERT될 때마다 자동으로 출력되는 트리거 정의
CREATE OR REPLACE TRIGGER TRG_01
AFTER INSERT ON EMPLOYEE
BEGIN
    DBMS_OUTPUT.PUT_LINE('신입사원님 환영합니다.');
END;
/
-- EMPLOYEE 테이블에 INSERT 된 후에 신입~ 환영 문구 출력

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, DEPT_CODE, JOB_CODE, HIRE_DATE)
VALUES(500, '이순신', '111111-1111111', 'D7', 'J7', SYSDATE);

--------------------------------------------------------------------------------

-- 상품입고 및 출고 관련 예시
--> 필요한 테이블 및 시퀀스 생성
-- 1. 상품에 대한 데이터를 보관할 테이블(TB_PRODUCT)
DROP TABLE TB_PRODUCT;
CREATE TABLE TB_PRODUCT(
    PCODE NUMBER PRIMARY KEY, -- 상품번호
    PNAME VARCHAR2(30) NOT NULL, --상품명
    BRAND VARCHAR2(30) NOT NULL, -- 브랜드명
    PRICE NUMBER, -- 상품가격
    STOCK NUMBER DEFAULT 0 -- 재고
);

-- 상품번호 중복되지 않게 매번 새로운 상품번호 발생시키는 시퀀스 생성
CREATE SEQUENCE SEQ_PCODE
START WITH 200
INCREMENT BY 5
NOCACHE;

-- 샘플데이터 추가
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '갤럭시24', '샘송', 1400000, DEFAULT);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '아이폰15', '애뽈', 1300000, 10);
INSERT INTO TB_PRODUCT VALUES(SEQ_PCODE.NEXTVAL, '홍미2', '샤옴니', 700000, 20);

COMMIT;

-- 2. 상품 입출고 상세 이력 테이블 생성(TB_PRODETAIL)
-- 어떤 상품이 어떤 날짜에 몇개가 입고 또는 출고가 되는지 데이터 기록
CREATE TABLE TB_PRODETAIL(
    DECODE NUMBER PRIMARY KEY, -- 이력번호
    PCODE NUMBER REFERENCES TB_PRODUCT, -- 상품번호
    PDATE DATE NOT NULL, -- 입출고일
    AMOUNT NUMBER NOT NULL, --입출고수량
    STATUS CHAR(6) CHECK(STATUS IN ('입고', '출고')) --입출고 상태
);

-- 이력번호 자동 생성할 시퀀스
CREATE SEQUENCE SEQ_DECODE
NOCACHE;

DROP TABLE TB_PRODETAIL;

-- 200번 상품이 오늘일자로 10개 입고
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 200, SYSDATE, 10, '입고');
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 205, SYSDATE, 20, '입고');
INSERT INTO TB_PRODETAIL VALUES (SEQ_DECODE.NEXTVAL, 210, SYSDATE, 5, '입고');

-- 200번 상품의 재고수량 10 증가
UPDATE TB_PRODUCT
SET STOCK = STOCK + 10
WHERE PCODE = 200;

COMMIT;

UPDATE TB_PRODUCT
SET STOCK = STOCK + 20
WHERE PCODE = 205;

UPDATE TB_PRODUCT
SET STOCK = STOCK + 5
WHERE PCODE = 210;

COMMIT;

-- TB_PRODETAIL 테이블에 INSERT 이벤트 발생시
-- TB_PRODUCT 테이블에 매번 자동으로 재고수량 UPDATE 되게끔 트리거 작성
/*
    상품 입고시 해당 상품 찾아서 재고수량 증가 UPDATE
    UPDATE TB_PRODUCT
    SET STOCK = STOCK + 현재 입고된 수량(INSERT된 자료의 AMOUNT)
    WHERE PCODE = 입고된 상품번호(INSERT된 자료의 PCODE)
    
    상품 출고시 해당 상품 찾아서 재고수량 감소 UPDATE
    UPDATE TB_PRODUCT
    SET STOCK = STOCK - 현재 출고된 수량(INSERT된 자료의 AMOUNT)
    WHERE PCODE = 출고된 상품번호(INSERT된 자료의 PCODE)
*/

DROP TRIGGER TRG_PRODUCTDETAIL;

CREATE OR REPLACE TRIGGER TRG_PRODUCTDETAIL
AFTER INSERT ON TB_PRODETAIL
DECLARE
    AMOUNT TB_PRODETAIL.AMOUNT%TYPE;
    STATUS TB_PRODETAIL.STATUS%TYPE;
    STOCK TB_PRODUCT.STOCK%TYPE;
BEGIN
    SELECT AMOUNT, STATUS
    INTO AMOUNT, STATUS
    FROM TB_PRODETAIL;
     
    IF STATUS = '입고'
        THEN STOCK := STOCK + AMOUNT;
    ELSIF STATUS = '출고'    
        THEN STOCK := STOCK - AMOUNT;    
    END IF;

        UPDATE TB_PRODUCT
        SET STOCK
        WHERE PCODE := &상품번호;


END;
/

CREATE OR REPLACE TRIGGER TRG_02
AFTER INSERT ON TB_PRODETAIL
FOR EACH ROW
BEGIN
    IF(:NEW.STATUS = '입고')
        THEN UPDATE TB_PRODUCT
            SET STOCK = STOCK + :NEW.AMOUNT 
            WHERE PCODE = :NEW.PCODE;
    ELSIF(:NEW.STATUS = '출고')
        THEN UPDATE TB_PRODUCT
            SET STOCK = STOCK - :NEW.AMOUNT 
            WHERE PCODE = :NEW.PCODE;
    END IF;
END;
/

-- 210번 상품 오늘일자로 7개 출고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 210, SYSDATE, 7, '출고');

-- 200번 상품이 오늘일자로 100개 입고
INSERT INTO TB_PRODETAIL
VALUES(SEQ_DECODE.NEXTVAL, 200, SYSDATE, 100, '입고');














