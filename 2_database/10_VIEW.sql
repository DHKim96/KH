/*
    <VIEW 뷰>
        : SELECT문(쿼리문)을 저장해둘 수 있는 객체
          (자주 사용하는 SELECT문을 저장해두면 긴 SELECT문을 매번 다시 기술할 필요가 없음)
          임시테이블 같은 존재(실제 데이터가 담겨 있는 것(물리적인 테이블)이 아님 = > 논리적인 테이블)
*/

-- 한국에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '한국'
ORDER BY EMP_ID;

-- 러시아에서 근무하는 사원들의 사번, 이름, 부서명, 급여, 근무국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
WHERE NATIONAL_NAME = '러시아'
ORDER BY EMP_ID;

-------------------------------------------------------------------------------
/*
    1. VIEW 생성 방법
        
        [표현식]
        CREATE VIEW 뷰명
        AS (서브쿼리)
        
        다만, 테이블인지 뷰인지 구별하기 위해 보통 명칭 앞에 VW_ 사용
*/
-- TB_ 
-- VW_

CREATE VIEW VW_EMPLOYEE
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE));
--> insufficient privileges 오류 보고
--> 권한 부여해줘야함(관리자 계정에서)
GRANT CREATE VIEW TO KH; 

SELECT * FROM VW_EMPLOYEE;

-- 실제 실행되는 것은 아래와 같이 서브쿼리로 실행된다고 볼 수 있음
SELECT * FROM (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
                FROM EMPLOYEE
                JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
                JOIN NATIONAL USING (NATIONAL_CODE)
);

SELECT * FROM VW_EMPLOYEE
WHERE NATIONAL_NAME = '한국'
ORDER BY EMP_ID;

CREATE VIEW VW_EMPLOYEE
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE));
-- 이미 같은 이름의 뷰를 만들었기 때문에 안됨
-- 덮어씌우면 됨
CREATE OR REPLACE VIEW VW_EMPLOYEE
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY, NATIONAL_NAME, BONUS
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    JOIN NATIONAL USING (NATIONAL_CODE));
------------------------------------------------------------------------------------
/*
    * 뷰 컬럼에 별칭 부여
        : 서브쿼리의 SELECT절에 함수식이나 산술연산식이 기술되어 있을 경우 반드시 별칭 지정해야함
*/
CREATE OR REPLACE VIEW VW_EMP_JOB
AS (SELECT EMP_ID, EMP_NAME, JOB_NAME, 
            DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') AS "성별",
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE) AS "근무연수"
    FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE));
-- 오류 보고 missing right parenthesis
-- 산술연산식이 있기에 별칭 부여해줘야 함

CREATE OR REPLACE VIEW VW_EMP_JOB(사번, 이름, 직급명, 성별, 근무년수)
AS (SELECT EMP_ID, EMP_NAME, JOB_NAME, 
            DECODE(SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여'),
            EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM HIRE_DATE)
    FROM EMPLOYEE
    JOIN JOB USING (JOB_CODE));

SELECT *
FROM VW_EMP_JOB
WHERE 근무년수 >= 20;

-- 뷰 삭제하고 싶을 때
DROP VIEW VW_EMP_JOB;
---------------------------------------------------------------------------------
/*
 생성된 뷰를 통해 DML(INSERT, UPDATE, DELETE) 사용 가능
 뷰를 통해 조작하면 실제 데이터가 담긴 테이블에 반영됨
*/

CREATE OR REPLACE VIEW VW_JOB
AS SELECT JOB_CODE, JOB_NAME
    FROM JOB;

SELECT * FROM VW_JOB;
-- 논리 테이블(실제 데이터가 담겨있지 않음)

-- VIEW 를 통해 INSERT
INSERT INTO VW_JOB VALUES ('J8', '인턴');

SELECT * FROM JOB;
-- 실제 테이블에도 반영됐음

-- VIEW 를 통해 UPDATE
UPDATE VW_JOB
SET JOB_NAME = '아르바이트'
WHERE JOB_CODE = 'J8';

-- 할 수 있을 뿐이지 실제로 잘 활용되지는 않음

--------------------------------------------------------------------------------
/*
    * DML 명령어로 조작 불가능한 경우가 많음
      조작 불가능한 경우는 아래와 같음
        1. VIEW 에 정의되지 않은 컬럼을 조작하려는 경우
        2. VIEW 에 정의되지 않은 컬럼 중 베이스 테이블 상에 NOT NULL 제약 조건이 지정되어있는 경우
        3. 산술연산식 또는 함수식으로 정의된 경우
        4. 그룹함수나 GROUP BY 절이 포함된 경우
        5. DISTINCT 구문이 포함된 경우
        6. JOIN 통해 여러 테이블 연결시켜놓은 경우
    
     따라서 대부분 VIEW 는 조회 목적으로 생성. 뷰를 통한 DML은 안쓰는 편이 좋음
*/

/*
    VIEW 옵션
    
    [상세표현식]
    CREATE [OR REPLACE] [FORCE | NOFORCE] VIEW 뷰명
    AS 서브쿼리
     [WITH CHECK OPTION]
     [WITH READ ONLY];
     
     1)CREATE OR REPLACE
        : 기존에 동일 뷰가 있을 경우 갱신, 존재하지 않을 경우 새로 생성
     2) FORCE | NOFORCE
        > FORCE
            : 서브쿼리에 기술된 테이블이 존재하지 않아도 뷰가 생성토록 함
        > NOFORCE(기본값)
            : 서브쿼리에 기술된 테이블이 존재하는 테이블이어야만 뷰가 생성    
     3) WITH CHECK OPTION
        : DML 시 서브쿼리에 기술된 조건에 부합한 값으로만 DML 가능토록 함
          서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 오류 발생
     4) WITH READ ONLY
        : VIEW 에 대해 조회만 가능토록 함
*/

-- 2) FORCE | NOFORCE
CREATE OR REPLACE NOFORCE VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;
-- 오류보고 ORA-00942: table or view does not exist

-- 서브쿼리에 기술된 테이블이 존재하지 않아도 우선적으로 뷰가 생김(사용 불가)
CREATE OR REPLACE FORCE VIEW VW_EMP
AS SELECT TCODE, TNAME, TCONTENT
    FROM TT;
-- 경고 : 컴파일 오류와 함께 뷰가 생성되었습니다.
-- 일단 SELECT 문 저장 후 나중에 테이블 생성될 시 사용

SELECT * FROM VW_EMP;
-- 조회 시 오류 발생

CREATE TABLE TT(
    TCODE NUMBER,
    TNAME VARCHAR2(20),
    TCONTENT VARCHAR2(30)
);
-- 테이블 생성 후 사용 가능해짐
SELECT * FROM VW_EMP;

-- 3) WITH CHECK OPTION
--      : 서브쿼리에 기술된 조건에 부합하지 않는 값으로 수정시 오류 발생
CREATE OR REPLACE VIEW VW_EMP
AS SELECT * 
    FROM EMPLOYEE
    WHERE SALARY >= 3000000;

SELECT * FROM VW_EMP;    

-- 200번 사원의 급여를 200만원으로 변경(SALARY >= 3000000 에 맞지 않는 변경)
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;

ROLLBACK;

CREATE OR REPLACE VIEW VW_EMP
AS SELECT * 
    FROM EMPLOYEE
    WHERE SALARY >= 3000000
WITH CHECK OPTION;

-- 200번 사원의 급여를 200만원으로 변경(SALARY >= 3000000 에 맞지 않는 변경)
UPDATE VW_EMP
SET SALARY = 2000000
WHERE EMP_ID = 200;
-- 오류 보고 ORA-01402: view WITH CHECK OPTION where-clause violation

-- 4) WITH READ ONLY
CREATE OR REPLACE VIEW VW_EMP
AS SELECT EMP_ID, EMP_NAME, BONUS
    FROM EMPLOYEE
    WHERE BONUS IS NOT NULL
WITH READ ONLY;

SELECT * FROM VW_EMP;

DELETE
FROM VW_EMP
WHERE EMP_ID = 200;
-- SQL 오류: ORA-42399: cannot perform a DML operation on a read-only view








