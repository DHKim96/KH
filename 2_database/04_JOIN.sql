/*
    <JOIN>
        : 두 개 이상의 테이블에서 데이터를 조회하고자 할 때 사용하는 구문
          조회 결과는 하나의 결과물(RESULT SET)로 나옴
          
    관계형 데이터베이스에서는 최소한의 데이터를 각각의 테이블에 담고 있음
    (중복 저장을 최소화하기 위해서 최대한 쪼개서 관리함)
    
    => 관계형 데이터베이스에서 SQL문을 이용한 테이블간 "관계"를 맺는 방법
    (무작정 다 조회해 오는게 아니라 각 테이블 간 연결고리(외래키)를 통해 데이터를 매칭시켜 조회해야 함)
    
    JOIN은 크게 "오라클 전용 구문"과 "ANSI 구문"(ANSI: 미국국립표준협회)
    
    [용어정리]
    
                오라클 전용 구문               |           ANSI 구문
    ---------------------------------------------------------------------------
                등가 조인                      |             내부 조인
            (EQUAL JOIN)                     |  (INNER JOIN) => JOIN USING / ON
    ----------------------------------------------------------------------------
                포괄 조인                      |         왼쪽 외부 조인(LEFT OUTER JOIN)
            (LEFT OUTER)                     |         오른쪽 외부 조인(RIGHT OUTER JOIN)
            (RIGHT OUTER)                    |         전체 외부 조인(FULL OUTER JOIN)
    --------------------------------------------------------------------------------
                자체 조인(SELF JOIN)            |         JOIN ON
                비등가 조인(NON EQUAL JOIN)     |  
    --------------------------------------------------------------------------------            
*/

-- 전체 사원들의 사번, 사원명, 부서코드, 부서명을 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE;

-- 부서명 조회
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT;

-- 전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT EMP_ID, EMP_NAME, JOB_CODE
FROM EMPLOYEE;

-- 직급코드, 직급명
SELECT JOB_CODE, JOB_NAME
FROM JOB;

/*
    1. 등가 조인(EQUAL JOIN) / 내부 조인(INNER JOIN)
        : 연결시키는 컬럼의 값이 일치하는 행들만 조회(== 일치하는 값이 없는 행은 조회 제외)
        
        1.1. 오라클 전용 구문
            FROM 절에 조회하고자 하는 테이블 나열(','로 구분)
            WHERE 절에 매칭시킬 컬럼에 대한 조건을 제시
        
        1.2. ANIS 구문
            FROM 절에 기준이 되는 테이블 하나 기술
            JOIN 절에 같이 조인하고자 하는 테이블 기술 && 매칭시킬 컬럼에 대한 조건 기술
            JOIN USING / JOIN ON
            JOIN USING 은 연결하는 컬럼명이 같은 때만 사용 가능
*/
--1.1. 오라클 전용 구문
--1.1.1.연결할 두 컬럼명이 다른 경우(EMPLOYEE.DEPT_CODE / DEPARTMENT.DEPT_ID)
-- 전체 사원들의 사번, 사원명, 부서코드, 부서명을 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID;
-- NULL, D3, D4, D7 데이터는 한 테이블에서만 존재하기 때문에 제외됐음
-- 즉, 일치하는 값이 없는 행은 조회에서 제외됨

--1.1.2. 연결할 두 칼럼명이 같은 경우(EMPLOYEE.JOB_CODE / JOB.JOB_CODE)
-- 전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE;
-- 별칭 사용 가능


--1.2. ANSI 구문

--1.2.1. 연결할 두 컬럼명이 다른 경우(EMPLOYEE.DEPT_CODE / DEPARTMENT.DEPT_ID)

-- JOIN ON
-- 전체 사원들의 사번, 사원명, 부서코드, 부서명을 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- 괄호 필수
--1.2.2. 연결할 두 컬럼명이 같은 경우(EMPLOYEE.JOB_CODE / JOB.JOB_CODE)
-- 전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT EMP_ID, EMP_NAME, E.JOB_CODE, JOB_NAME
FROM EMPLOYEE E
JOIN JOB J ON(E.JOB_CODE = J.JOB_CODE);

-- JOIN USING
-- 전체 사원들의 사번, 사원명, 직급코드, 직급명
SELECT EMP_ID, EMP_NAME, JOB_CODE, JOB_NAME
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE);

-- 추가적인 조건도 제시
-- 직급이 대리인 사원의 사번, 사원명, 직급명, 급여 조회
-- 오라클 구문 사용
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE ( E.JOB_CODE = J.JOB_CODE ) 
    AND JOB_NAME = '대리';
-- ANSI
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리';

--=======================================문제===================================
-- 1. 부서가 인사관리부인 사원들의 사번, 이름, 보너스 조회
-- 오라클
SELECT EMP_ID, EMP_NAME, BONUS
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
    AND DEPT_TITLE = '인사관리부';
-- ANSI
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE = '인사관리부';

-- 2. DEPARTMENT 와 LOCATION 테이블 참고하여 전체 부서의 부서코드, 부서명, 지역코드, 지역명 조회
SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT, LOCATION
WHERE LOCATION_ID = LOCAL_CODE;

SELECT DEPT_ID, DEPT_TITLE, LOCAL_CODE, LOCAL_NAME
FROM DEPARTMENT
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

-- 3. 보너스를 받는 사원들의 사번, 사원명, 보너스, 부서명 조회
SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
    AND BONUS IS NOT NULL;

SELECT EMP_ID, EMP_NAME, BONUS, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE BONUS IS NOT NULL;

-- 4. 부서가 총무부가 아닌 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID 
    AND DEPT_TITLE != '총무부';

SELECT EMP_NAME, SALARY, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE DEPT_TITLE != '총무부';


-------------------------------------------------------------------------------
/*
    2. 포괄조인 / 외부조인(OUTER JOIN)
        : 두 테이블 간 JOIN 시 일치하지 않는 행도 포함시켜 조회 가능
          단, 반드시 LEFT / RIGHT 지정해야됨(기준테이블을 정해야함)
          
          2.1.LEFT [OUTER] JOIN
            : 두 테이블 중 왼편에 기술된 테이블을 기준으로 JOIN
          
          2.2.RIGHT [OUTER] JOIN
            : 두 테이블 중 오른편에 기술된 테이블을 기준으로 JOIN
            
          2.3.FULL [OUTER] JOIN
            : 두 테이블이 가진 모든 행을 조회할 수 있음
              오라클 구문은 존재하지 않음
*/

-- 사원명, 부서명, 급여, 연봉
-- 내부 조인 시 부서배치를 받지 않은 2명의 사원 정보가 누락됨
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12 AS "연봉"
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- DEPT_CODE NULL 인 하동운, 이오리 없음

-- 2.1.
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12 AS "연봉"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE = DEPT_ID(+);
-- DEPT_CODE 를 기준으로 DEPT_ID 를 넣겠다
-- 기준테이블은 무조건 나오기 때문에 NULL 이 나오는 것
-- 기준에 왼쪽에 있기에 LEFT JOIN(오른쪽에 있으면 RIGHT JOIN' WHERE DEPT_CODE(+) = DEPT_ID)

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12 AS "연봉"
FROM EMPLOYEE
LEFT JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID);
-- 원래는 LEFT [OUTER] JOIN

-- 2.2.
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12 AS "연봉"
FROM EMPLOYEE, DEPARTMENT
WHERE DEPT_CODE(+) = DEPT_ID;

SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12 AS "연봉"
FROM EMPLOYEE
RIGHT JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID );

-- 2.3
SELECT EMP_NAME, DEPT_TITLE, SALARY, SALARY * 12 AS "연봉"
FROM EMPLOYEE
FULL JOIN DEPARTMENT ON ( DEPT_CODE = DEPT_ID );

---------------------------------------------------------------------------------
/*
    3. 비등가 조인(NON EQUAL JOIN)
        : 매칭시킬 컬럼에 대한 조건 작성시 '='을 사용하지 않는 조인문
          ANSI 구문으로는 JOIN ON
          강제로 매칭시킴
*/
-- 사원명, 급여, 급여레벨
SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE, SAL_GRADE
WHERE SALARY BETWEEN MIN_SAL AND MAX_SAL
ORDER BY SAL_LEVEL;

SELECT EMP_NAME, SALARY, SAL_LEVEL
FROM EMPLOYEE
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL )
ORDER BY SAL_LEVEL, SALARY DESC;

--------------------------------------------------------------------------------
/*
    4. 자체 조인(SELF JOIN)
        : 같은 테이블을 다시 한 번 조인하는 경우
*/
-- 전체 사원들의 사번, 사원명, 부서코드
--              사수사번, 사수명, 사수부서코드
SELECT E.EMP_ID AS "사원사번", E.EMP_NAME AS "사원명", E.DEPT_CODE,
       M.EMP_ID AS "사수사번", M.EMP_NAME AS "사수명", M.DEPT_CODE
FROM EMPLOYEE E, EMPLOYEE M
WHERE E.MANAGER_ID = M.EMP_ID;

SELECT E.EMP_ID AS "사원사번", E.EMP_NAME AS "사원명", E.DEPT_CODE,
       M.EMP_ID AS "사수사번", M.EMP_NAME AS "사수명", M.DEPT_CODE
FROM EMPLOYEE E
LEFT JOIN EMPLOYEE M ON ( E.MANAGER_ID = M.EMP_ID );

------------------------------------------------------------------------------------
/*
    <다중조인>
        : 2개 이상의 테이블을 가지고 join 할 때
*/

-- 사번, 사원명, 부서명, 직급명
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE E, DEPARTMENT D, JOB J
WHERE E.DEPT_CODE = D.DEPT_ID 
    AND E.JOB_CODE = J.JOB_CODE;

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE);

-- 사번, 사원명, 부서명, 지역명
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION
WHERE DEPT_CODE = DEPT_ID
    AND LOCATION_ID = LOCAL_CODE
ORDER BY LOCAL_NAME;    

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE);

----------------------문제-----------------------------------------

-- 1. 사번, 사원명, 부서명, 지역명, 국가명 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE, DEPARTMENT, LOCATION L, NATIONAL N
WHERE DEPT_CODE = DEPT_ID
    AND LOCATION_ID = LOCAL_CODE
    AND L.NATIONAL_CODE = N.NATIONAL_CODE;

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, NATIONAL_NAME
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE);

-- 2. 사번, 사원명, 부서명, 직급명, 지역명, 국가명, 급여등급 조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE E, DEPARTMENT, JOB J, LOCATION L, NATIONAL N, SAL_GRADE
WHERE (DEPT_CODE = DEPT_ID)
    AND (E.JOB_CODE = J.JOB_CODE)
    AND (LOCATION_ID = LOCAL_CODE)
    AND (L.NATIONAL_CODE = N.NATIONAL_CODE)
    AND (SALARY BETWEEN MIN_SAL AND MAX_SAL);

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, LOCAL_NAME, NATIONAL_NAME, SAL_LEVEL
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
JOIN NATIONAL USING (NATIONAL_CODE)
JOIN SAL_GRADE ON (SALARY BETWEEN MIN_SAL AND MAX_SAL);













