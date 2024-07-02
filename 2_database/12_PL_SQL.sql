/*
    <PL / SQL>
        : PROCEDURE LANGUAGE EXTENSION TO SQL
          
           오라클 자체에 내장된 절차적 언어.
           SQL 문장 내에서 변수의 정의, 조건(IF), 반복(FOR, WHILE) 등을 지원하며
          SQL의 단점을 보완.
           다수의 SQL 문을 한 번에 실행 가능.
           
        * PL /SQL 구조
            - [선언부]
                : DECLARE 로 시작. 변수나 상수를 선언 및 초기화하는 부분
            - 실행부
                : BEGIN 으로 시작. SQL문 또는 제어문(조건문, 반복문) 등의 로직 기술하는 부분
            - [예외처리부]
                : EXCEPTION 으로 시작. 예외발생 시 해결 위한 구문
                
*/
SET SERVEROUTPUT ON;
-- HELLO ORACLE 출력
BEGIN
    -- JAVA : SYSTEM.OUT.PRINTLN("HELLO ORACLE");
    DBMS_OUTPUT.PUT_LINE('HELLO ORACLE');
END;
/
--------------------------------------------------------------------------------

/*
    1. DECLARE 선언부
        : 변수 및 상수 선언하는 공간(선언과 동시에 초기화 가능)
           일반타입 변수, 레퍼런스타입 변수, ROW타입 변수
        1) 일반 타입 변수 선언 및 초기화
            [표현식]
            변수명 [CONSTANT] 자료형 [:= 값]; -- ':=' PLSQL의 대입 연산자
        2) 레퍼런스 타입 변수 선언 및 초기화
            : 어떤 테이블의 어떤 컬럼의 데이터타입을 참조해서 그 타입으로 지정
        3) ROW 타입 변수 선언
            : 테이블의 한 행에 대한 모든 컬럼값을 한 번에 담을 수 있는 변수
            [표현식]
            변수명 테이블명%ROWTYPE;
    
*/      
--1.1)
DECLARE
    EID NUMBER;
    ENAME VARCHAR2(20);
    PI CONSTANT NUMBER := 3.14;
BEGIN
    EID := &번호;
    ENAME := '&이름';
    
    DBMS_OUTPUT.PUT_LINE('EID :' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME :' || ENAME);
    DBMS_OUTPUT.PUT_LINE('PI :' || PI);
END;
/

--------------------------------------------------------------------------------
-- 1.2) 레퍼런스 타입 변수 선언 및 초기화
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
BEGIN
    -- 사번이 200번인 사원의 사번, 사원명, 급여 조회해서
    -- 각 변수에 대입
    --> INTO 명령어 사용
    
    SELECT EMP_ID, EMP_NAME, SALARY
    INTO EID, ENAME, SAL
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;

    DBMS_OUTPUT.PUT_LINE('EID :' || EID);
    DBMS_OUTPUT.PUT_LINE('ENAME :' || ENAME);
    DBMS_OUTPUT.PUT_LINE('SAL :' || SAL);
END;
/

-------------------------------------------실습-------------------------------------
/*
    레퍼런스 타입 변수로 EID, ENAME, JCODE, SAL, DTITLE 을 선언하고
    각 자료형 EMPLOYEE(EMP_ID, EMP_NAME, JOB_CODE, SALARY),
    DEPARTMENT(DEPT_TITLE) 등을 참조하도록
    사용자가 입력한 사번의 사원의 사번, 사원명, 직급코드, 급여, 부서명 조회 후 각 변수에 담아서 출력
*/
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    JCODE EMPLOYEE.JOB_CODE%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY, DEPT_TITLE
    INTO EID, ENAME, JCODE, SAL, DTITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    WHERE EMP_ID = &사번;    
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('직급코드 : ' || JCODE);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || DTITLE);
    
END;
/

--------------------------------------------------------------------------------

DECLARE
    E EMPLOYEE%ROWTYPE;
BEGIN
    SELECT *
    INTO E
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || E.EMP_NAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || E.SALARY);
    DBMS_OUTPUT.PUT_LINE('보너스 : ' || NVL(E.BONUS, 0));
END;
/

--------------------------------------------------------------------------------
/* 
    2. BEGIN 실행부
        <조건문>
        1) IF문 단독 사용 시
            [표현식]
            IF 조건식 THEN 실행내용; END IF;
        2) IF ELSE
            [표현식]
            IF 조건식 THEN 실행내용; ELSE 실행내용; END IF;
        3) ELSE IF
            [표현식]
            IF 조건식1 THEN 실행내용1; 
            ELSEF 조건식2 THEN 실행내용2; ... [ELSE 실행내용] 
            END IF;
        4) CASE WHEN THEN
            [표현식]
            CASE 비교대상자 
                WHEN 동등비교값1 THEN 결과값
                WHEN 비교값2 THEN 결과값
                ...
                ELSE 결과값
                END;
*/
-- 입력받은 사번에 해당하는 사원의 사번, 이름, 급여, 보너스 출력
-- 단, 보너스를 받지 않은 사원은 보너스율 출력 전 '보너스를 지급받지 않은 사원입니다' 출력
-- 2.1)
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;

    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않은 사원입니다');
    END IF;    
    
    DBMS_OUTPUT.PUT_LINE('보너스율 : ' || BONUS);
END;
/

--2.2.
DECLARE
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    BONUS EMPLOYEE.BONUS%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, SALARY, NVL(BONUS, 0)
    INTO EID, ENAME, SAL, BONUS
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;

    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || SAL);
    
    IF BONUS = 0
        THEN DBMS_OUTPUT.PUT_LINE('보너스를 지급받지 않은 사원입니다');
    ELSE
        DBMS_OUTPUT.PUT_LINE('보너스율 : ' || (BONUS * 100) || '%');
    END IF;    
END;
/

------------------------------------실습----------------------------------------
-- DECLARE
-- 레퍼런스타입변수(EID, ENAME, DTITLE, NCODE)
--          참조컬럼(EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE)
--          일반타입변수(TEAM 문자열) < == 국내팀 , 해외팀
-- BEGIN
--  사용자가 입력한 사번의 사원의 사번, 이름, 부서명, 근무국가코드 조회 후 각 변수에 대입
--      NCODE 값이 KO 일 경우 TEAM '국내팀' 대입
                -- 아닐경우         해외팀 대입
--  사번, 이름, 부서, 소속 출력
-- END;
--/
DECLARE
    TEAM VARCHAR2(20);
    EID EMPLOYEE.EMP_ID%TYPE;
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    DTITLE DEPARTMENT.DEPT_TITLE%TYPE;
    NCODE LOCATION.NATIONAL_CODE%TYPE;
BEGIN
    SELECT EMP_ID, EMP_NAME, DEPT_TITLE, NATIONAL_CODE
    INTO EID, ENAME, DTITLE, NCODE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
    JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
    WHERE EMP_ID = &사번;
    
    IF NCODE = 'KO'
        THEN TEAM := '국내팀';
    ELSE
        TEAM := '해외팀';
    END IF;
    
    DBMS_OUTPUT.PUT_LINE('사번 : ' || EID);
    DBMS_OUTPUT.PUT_LINE('사원명 : ' || ENAME);
    DBMS_OUTPUT.PUT_LINE('부서 : ' || DTITLE);
    DBMS_OUTPUT.PUT_LINE('소속 : ' || TEAM);
    
END;
/
--------------------------
--2.3)
DECLARE
    SCORE NUMBER;
    GRADE VARCHAR2(1);
BEGIN
    SCORE := &점수;
    
    IF SCORE >= 90 THEN GRADE := 'A';
    ELSIF SCORE >= 80 THEN GRADE := 'B';
    ELSIF SCORE >= 70 THEN GRADE := 'C';
    ELSIF SCORE >= 60 THEN GRADE := 'D';
    ELSE GRADE := 'F';
    END IF;

    DBMS_OUTPUT.PUT_LINE('당신의 점수는 ' || SCORE || '점이고, 학점은 ' || GRADE || '학점입니다.');
    
END;
/

---------------------------------실습---------------------------------------------------------
-- 사용자에게 입력받은 사번의 사원의 급여를 조회해서 SAL 변수 대입
-- 500만원 이상이면 고급
-- 4백만원 이상이면 중급
-- 3백만원 이상이면 초급
-- '해당 사원의 급여등급은 XX입니다' 출력

DECLARE
    ENAME EMPLOYEE.EMP_NAME%TYPE;
    SAL EMPLOYEE.SALARY%TYPE;
    GRADE VARCHAR2(6);
BEGIN
    SELECT EMP_NAME, SALARY
    INTO ENAME, SAL
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    IF SAL >= 5000000
        THEN GRADE := '고급';
    ELSIF SAL >= 4000000
        THEN GRADE := '중급';
    ELSE
        GRADE := '초급';
    END IF;    
    
    DBMS_OUTPUT.PUT_LINE(ENAME || ' 사원의 급여등급은 ' || GRADE || '입니다.');

END;
/
-----------------------------------------------------------------

-- 2.4)
DECLARE
    EMP EMPLOYEE%ROWTYPE;
    DNAME VARCHAR2(30);
BEGIN
    SELECT *
    INTO EMP
    FROM EMPLOYEE
    WHERE EMP_ID = &사번;
    
    DNAME := CASE EMP.DEPT_CODE
                WHEN 'D1' THEN '인사팀'
                WHEN 'D2' THEN '회계팀'
                WHEN 'D3' THEN '마케팅팀'
                WHEN 'D4' THEN '국내영업팀'
                WHEN 'D9' THEN '총무팀'
                ELSE '해외영업팀'
            END;
            
    DBMS_OUTPUT.PUT_LINE(EMP.EMP_NAME || '은(는) ' || DNAME || '입니다.');        
                
END;
/

------------------------------------------------------------------------
/*
    <반복문>
        1) BASIC LOOP문
            [표현식]
            LOOP
                반복적으로 실행할 구문;
                *반복문을 빠져나갈 수 있는 구문
            END LOOP;
            
            * 반복문을 빠져나갈 수 있는 구문(분기문?)
            1) IF 조건식 THEN EXIT; END IF;
            2) EXIT WHEN 조건식;
*/

DECLARE
    I NUMBER := 1;
BEGIN
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
        
       -- IF I = 6 THEN EXIT; END IF;
        EXIT WHEN I = 6;
        
    END LOOP;
END;
/
--------------------------------------------------------------------------------
/*
    2) FOR LOOP문
        [표현식]
        FOR 변수 IN [REVERSE] 초기값 .. 최종값
        LOOP
            반복적으로 실행할 문장;
        END LOOP;    
*/
BEGIN
    FOR I IN 1 .. 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/
BEGIN
    FOR I IN REVERSE 1 .. 5
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
    END LOOP;
END;
/

DROP TABLE TEST;

CREATE TABLE TEST(
    TNO NUMBER PRIMARY KEY,
    TDATE DATE
);

CREATE SEQUENCE SEQ_TNO
START WITH 1
INCREMENT BY 2
MAXVALUE 1000
NOCYCLE
NOCACHE;

BEGIN
    FOR I IN 1..100
    LOOP
        INSERT INTO TEST VALUES(SEQ_TNO.NEXTVAL, SYSDATE);
    END LOOP;
END;
/

SELECT * FROM TEST;

/*
    3) WHILE LOOP문
    [표현식]
    WHILE 반복문이 수행될 조건
    LOOP
        반복수행하는 문장;
    END LOOP;
*/

DECLARE
    I NUMBER := 1;
BEGIN
    WHILE I < 6
    LOOP
        DBMS_OUTPUT.PUT_LINE(I);
        I := I + 1;
    END LOOP;
END;
/

-------------------------------------------------------------------------------
/*
    3. 예외처리
    예외(EXCEPTION)
        : 실행 중 발생하는 오류
    EXCEPTION
        WHEN 예외명1 THEN 예외처리구문1;
        WHEN 예외명2 THEN 예외처리구문2;
        ...
        
    * 시스템 예외
        : 오라클에서 미리 정의해둔 예외
        - NO_DATA_FOUND
            : SELECT 한 결과가 한 행도 없을 경우
        - TOO_MANY_ROWS
            : SELECT 한 결과가 너무 많을 경우
        - ZERO_DIVIDE
            : 0으로 나눌때
        - DUP_VAR_ON_INDEX
            : UNIQUE 제약조건에 위배됐을 경우
        ...    
*/

-- 사용자가 입력한 수로 나눗셈 연산한 결과 출력
DECLARE
    RESULT NUMBER;
BEGIN
    RESULT := 10 / &숫자;
    DBMS_OUTPUT.PUT_LINE('결과 : ' || RESULT);
    
EXCEPTION
   -- WHEN ZERO_DIVIDE THEN DBMS_OUTPUT.PUT_LINE('나누기 연산 시 0으로 나눌 수 없습니다');
    WHEN OTHERS THEN DBMS_OUTPUT.PUT_LINE('나누기 연산 시 0으로 나눌 수 없습니다');
END;
/
/*
    UNIQUE 제약조건 위배
    DUP_VAL_ON_INDEX
*/
ALTER TABLE EMPLOYEE MODIFY EMP_ID VARCHAR2(10);

BEGIN
    UPDATE EMPLOYEE
    SET EMP_ID = '&변경할사번'
    WHERE EMP_NAME = '노옹철';
EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN DBMS_OUTPUT.PUT_LINE('이미 존재하는 사번입니다.');
END;
/














