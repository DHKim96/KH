/*
    DQL(QUERY 데이터 정의어)
        : SELECT
    DML(DATA MANIPULATION LANGUAGE)
        : INSERT, UPDATE, DELETE
    DDL(DATA DEFINITION LANGUAGE)
        : CREATE, ALTER, DROP, TRUNCATE
    DCL(DATA CONTROL LANGUAGE)
        : GRANT, REVOKE
    TCL(TRANSACTION CONTROL LANGUAGE)
        : COMMIT, ROLLBACK
        
    <DML>
        : 데이터 조작 언어
          테이블 값을 삽입(INSERT)하거나, 수정(UPDATE)하거나, 삭제(DELETE)하는 구문ㅌ

*/
/*
    1. INSERT
        : 테이블에 새로운 행을 추가하는 구문
         
          [표현식]
          1)INSERT INTO 테이블명 VALUES(값, 값, 값,...)
              테이블의 모든 컬럼에 대한 값을 직접 제시해 한 행을 INSERT 하고자 할 때
              컬럼의 순번을 지켜서 VALUES에 값을 나열해야함
          
          2)INSERT INTO 테이블명(컬럼, 컬럼, 컬럼) VALUES(값, 값, 값)
            테이블에 내가 선턱한 컬럼에 대한 값만 INSERT할 때 사용
            그래도 한 행 단위로 추가되기 때문에 선택안된 컬럼은 기본적으로 NULL 이 들어감
            => NOT NULL 제약 조건이 걸려있는 컬럼은 반드시 직접 값을 넣어줘야함
                단, 기본값이 지정돼있을 시 NULL 이 아닌 기본값이 들어감
            가장 많이 사용됨    
                
          3)INSERT INTO 테이블명 (서브쿼리)
             VALUES가 직접 명시하는 것 대신 서브쿼리로 조회된 결과값을 통째로 INSERT 가능 
*/
-- 1.1
INSERT INTO EMPLOYEE 
VALUES(900, '이소근', '880914-1456789', 'SG8809@naver.com', '01075966900',
        'D7', 'J5', 4000000, 0.2, 200, SYSDATE, NULL);
 --       부족하게 값을 제시할 경우 -> not enough values 오류 보고
INSERT INTO EMPLOYEE 
VALUES(900, '이소근', '880914-1456789', 'SG8809@naver.com', '01075966900',
        'D7', 'J5', 4000000, 0.2, 200, SYSDATE, NULL, 'N', NULL);
-- 값을 초과하게 넣어도 ->  too many values 오류
INSERT INTO EMPLOYEE 
VALUES(900, '이소근', '880914-1456789', 'SG8809@naver.com', '01075966900',
        'D7', 'J5', 4000000, 0.2, 200, SYSDATE, NULL, 'N');

--1.2
INSERT INTO EMPLOYEE
    (
     EMP_ID
    ,EMP_NAME
    ,EMP_NO
    ,JOB_CODE
    ,HIRE_DATE
    ) 
VALUES
    (
    901
    ,'최지원'
    ,'440701-1234567'
    ,'J7'
    ,SYSDATE
    );

SELECT * FROM EMPLOYEE;

--1.3.
CREATE TABLE EMP_01(
    EMP_ID NUMBER
    ,EMP_NAME VARCHAR(20)
    ,DEPT_TITLE VARCHAR2(20)
);

SELECT * FROM EMP_01;

INSERT INTO EMP_01(SELECT EMP_ID, EMP_NAME, DEPT_TITLE 
                   FROM EMPLOYEE
                   LEFT JOIN DEPARTMENT ON (DEPT_CODE =DEPT_ID));
---------------------------------------------------------------------
/*
    2. INSERT ALL
        : 두 개 이상의 테이블에 각각 INSERT할 때
          이때 사용되는 서브쿼리가 동일한 경우
          
          [표현식]
          INSERT ALL
          INTO 테이블명1 VALUES(컬럼, 컬럼, 컬럼 ...)
          INTO 테이블명2 VALUES(컬럼, 컬럼, ...)
          서브쿼리;
          => 서브쿼리의 실행결과가 여러 테이블에 다 입력됨
*/
--> 테스트 테이블
CREATE TABLE EMP_DEPT
AS (SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE 1 = 0);
    -- 조건 충족할 수 없기 때문에 컬럼만 가져와짐
    
CREATE TABLE EMP_MANAGER
AS(SELECT EMP_ID, EMP_NAME, MANAGER_ID
    FROM EMPLOYEE
    WHERE 1 = 0);

-- 부서코드가 D1인 사원들의 사번, 이름, 부서코드, 입사일, 사수사번 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

INSERT ALL
    INTO EMP_DEPT VALUES(EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE)
    INTO EMP_MANAGER VALUES(EMP_ID, EMP_NAME, MANAGER_ID)
        (SELECT EMP_ID, EMP_NAME, DEPT_CODE, HIRE_DATE, MANAGER_ID
            FROM EMPLOYEE
            WHERE DEPT_CODE = 'D1');
            
SELECT * FROM EMP_DEPT;            
SELECT * FROM EMP_MANAGER;
-------------------------------------------------------------------------------
/*
    3. UPDATE
        : 테이블에 기록되어있는 기존의 데이터를 수정하는 구문
        
        [표현식]
        1)
        UPDATE 테이블명
        SET 컬럼 = 값,
            컬럼 = 값,
            ... -- AND로 연결하는 것이 아니라 그냥 콤마(,)로 연결
        [WHERE 조건] --> 생략시 모든 행의 데이터가 변경
        
        * UPDATE 시에도 제약 조건 잘 확인해야함
        
        2)
        UPDATE 시 서브쿼리 사용 가능
        
        UPDATE 테이블명
        SET 컬럼명 = (서브쿼리)
        WHERE 조건
*/
CREATE TABLE DEPT_TABLE
AS (SELECT * FROM DEPARTMENT);

SELECT * FROM DEPT_TABLE;
-- D9 부서의 부서명을 '전략기획팀으로 변경'

UPDATE DEPT_TABLE
SET DEPT_TITLE = '전략기획팀';
--  모든 부서명이 전략기획팀으로 수정됨

UPDATE DEPT_TABLE
SET DEPT_TITLE = '전략기획팀'
WHERE DEPT_ID = 'D9';
-- D9 부서의 부서명만 수정됨

CREATE TABLE EMP_SALARY
AS (SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY, BONUS 
    FROM EMPLOYEE);

-- 노옹철 사원의 급여를 백만원으로 변경
UPDATE EMP_SALARY
SET SALARY = 1000000
WHERE EMP_NAME = '노옹철';

-- 선동일 사원의 급여를 7백만원, 보너스를 .2 로 변경
UPDATE EMP_SALARY
SET SALARY = 7000000,
    BONUS = 0.2
WHERE EMP_NAME = '선동일';

-- 전체 사원의 급여를 기존 급여에 10% 인상된 금액으로 변경
UPDATE EMP_SALARY
SET SALARY = SALARY * 1.1;

SELECT * FROM EMP_SALARY;

--3.2.
--방명수 사원의 급여와 보너스값을 유재식 사원의 급여와 보너스값으로 변경
UPDATE EMP_SALARY
    SET SALARY = (SELECT SALARY 
                    FROM EMP_SALARY
                    WHERE EMP_NAME = '유재식'),
        BONUS = (SELECT BONUS 
                    FROM EMP_SALARY
                    WHERE EMP_NAME = '유재식')
    WHERE EMP_NAME = '방명수';
--> 다중열로 변경
UPDATE EMP_SALARY
    SET (SALARY, BONUS) = (SELECT SALARY, BONUS
                            FROM EMP_SALARY
                            WHERE EMP_NAME = '유재식')
    WHERE EMP_NAME = '방명수';                    

-- ASIA 지역에 근무하는 사원들의 보너스값을 0.3으로 변경
SELECT EMP_ID
FROM EMP_SALARY
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE 'ASIA%';

UPDATE EMP_SALARY
SET BONUS = 0.3
WHERE EMP_ID IN (SELECT EMP_ID
                FROM EMP_SALARY
                JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
                WHERE LOCAL_NAME LIKE 'ASIA%');

COMMIT;

-------------------------------------------------------------------------------
/*
    4. DELETE
        : 테이블에 기록된 데이터를 삭제하는 구문(한 행 단위로 삭제)
        
        [표현식]
        DELETE FROM 테이블명
        [WHERE 조건] --> WHERE 절 제시하지 않으면 전체 행 삭제
        
    
*/
DELETE FROM EMPLOYEE;

SELECT * FROM EMPLOYEE;

ROLLBACK;

DELETE FROM EMPLOYEE
WHERE EMP_NAME = '이소근';

DELETE FROM EMPLOYEE
WHERE EMP_NAME = '901';

COMMIT;

DELETE FROM DEPARTMENT
WHERE DEPT_ID = 'D1';
-- D1의 값을 가져다 쓰는 자식데이터가 있기 때문에 삭제되지 않음(외래키 설정 시 ON DELETE 디폴트)











