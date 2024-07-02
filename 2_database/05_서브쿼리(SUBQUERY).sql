/*
    * 서브쿼리(SUBQUERY)
        : 하나의 SQL 문 안에 포함된 또 다른 SELECT 문
          메인 SQL 문을 위해 보조 역할을 하는 쿼리
*/

-- 간단한 서브쿼리 예시 1
-- 노옹철 사원과 같은 부서에 속한 사원들 조회

-- 1) 노옹철 사원의 부서코드
SELECT DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME = '노옹철';

-- 2) 부서코드가 D9 인 사원들 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- 3) 서브쿼리 통해 위의 두 단계를 하나의 쿼리문으로 처리
SELECT EMP_NAME
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '노옹철');

-- 간단한 서브쿼리 예시2
-- 전 직원의 평균급여보다 더 많은 급여를 받는 사원들의 사번, 이름, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT ROUND(AVG(SALARY))
                FROM EMPLOYEE);
                
/*
    * 서브쿼리 구분
        : 서브쿼리를 수행한 결과값이 몇행 몇열로 나오는 지에 따라 분류
        
        - 단일행 서브쿼리
            : 서브쿼리의 조회 결과값이 오로지 1개일 때
        - 다중행 서브쿼리
            : 서브쿼리의 조회 결과값이 여러 행일 때(단, 컬럼은 1열)
        - 다중열 서브쿼리
            : 서브쿼리의 조회 결과값이 단일행이지만 컬럼이 여러 개일때
              (단행 다중열)
        - 다중행 다중열 서브쿼리
            : 서브쿼리의 조회 결과값이 여러 행이면서 여러 열일 때
            
        >> 서브쿼리의 종류에 따라 서브쿼리 앞에 붙는 연산자가 달라짐
*/

/*
    1. 단일행 서브쿼리
        : 일반 비교 연산자 사용 가능(=, !=, >, < ...)
*/
-- 1) 전 직원의 평균 급여보다 급여를 더 적게 받는 사원들의 사원명, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < ( SELECT ROUND(AVG(SALARY))
                 FROM EMPLOYEE)
ORDER BY JOB_CODE;

-- 2) 최저급여를 받는 사원의 사번, 이름, 급여, 입사일 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = ( SELECT MIN(SALARY)
                 FROM EMPLOYEE);

-- 3) 노옹철 사원의 급여보다 많이 받는 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY
                FROM EMPLOYEE
                WHERE EMP_NAME = '노옹철');

-- 4) 노옹철 사원의 급여보다 많이 받는 사원들의 사번, 이름, 부서명, 급여조회
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, SALARY
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY > (SELECT SALARY
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '노옹철');

-- 5) 부서별 급여합이 가장 큰 부서의 부서코드 급여합
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                        FROM EMPLOYEE
                        GROUP BY DEPT_CODE);


-- 6) 전지연 사원과 같은 부서의 사람들의 사번, 사원명, 전화번호, 입사일, 부서명 조회 단, 전지연 사원 제외
SELECT EMP_ID, EMP_NAME, PHONE, HIRE_DATE, DEPT_TITLE
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN JOB USING (JOB_CODE)
WHERE DEPT_CODE = (SELECT DEPT_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME = '전지연')
    AND EMP_NAME != '전지연';                    

--------------------------------------------------------------------------------
/*
    2. 다중행 서브쿼리
       'IN' (서브쿼리)
            : 여러 개의 결과값 중 한 개라도 일치하는 값이 있다면 조회(동등 연산)
            
       '> ANY' (서브쿼리)
            : 여러 개의 결과값 중 한 개라도 클 경우 조회
             비교대상 > ANY (서브쿼리의 결과값 => 값1, 값2, 값3, ...)
             비교대상 > 값1 OR 비교대상 >  값2 OR 비교대상 > 값3, ...
       '< ANY' (서브쿼리)
            : 여러 개의 결과값 중 한 개라도 작을 경우 조회
            
       '> ALL' (서브쿼리)
            : 여러 개의 모든 결과값 보다 클 경우 조회
             비교대상 > ALL (서브쿼리의 결과값  => 값1, 값2, 값3, ... )
             비교대상 > 값1 AND 비교대상 > 값2 AND 비교대상 > 값3, ...
       '< ALL' (서브쿼리)
            : 작을 경우 조회

*/

-- 1) 유재식 또는 윤은해 사원과 같은 직급인 사원들의 사번, 사원명, 직급코드, 급여 조회
-- 1.1) 유재식 또는 윤은해 사원의 직급코드 구하기
SELECT JOB_CODE
FROM EMPLOYEE
WHERE EMP_NAME IN ('윤은해', '유재식');
-- 1.2) J3, J7과 같은 직급인 사원들의 사번, 사원명, 직급코드, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN ('J3', 'J7');
-- 1.3) 두 쿼리를 서브쿼리로 합함
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE IN (SELECT JOB_CODE
                    FROM EMPLOYEE
                    WHERE EMP_NAME IN ('윤은해', '유재식'));
                    
-- 2. 대리 직급임에도 과장 직급 급여들 중 최소 급여보다 많이 받는 사원들의 사번, 이름, 직급, 급여

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND( JOB_NAME = '대리'
    AND SALARY > (SELECT MIN(SALARY)
                    FROM EMPLOYEE E, JOB J
                    WHERE E.JOB_CODE = J.JOB_CODE
                    AND JOB_NAME = '과장'));

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리'
    AND SALARY > (SELECT MIN(SALARY)
                    FROM EMPLOYEE
                    JOIN JOB USING (JOB_CODE)
                    WHERE JOB_NAME = '과장');

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE E, JOB J
WHERE E.JOB_CODE = J.JOB_CODE
AND( JOB_NAME = '대리'
    AND SALARY > ANY (SELECT SALARY
                        FROM EMPLOYEE E, JOB J
                        WHERE E.JOB_CODE = J.JOB_CODE
                        AND JOB_NAME = '과장'));

SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
JOIN JOB USING (JOB_CODE)
WHERE JOB_NAME = '대리'
    AND SALARY > ANY (SELECT SALARY
                        FROM EMPLOYEE
                        JOIN JOB USING (JOB_CODE)
                        WHERE JOB_NAME = '과장');
--------------------------------------------------------------------------------
/*
    3. 다중열 서브쿼리(단행)
*/

-- 1) 하이유 사원과 같은 부서코드, 같은 직급코드에 해당하는 사원들 조회
-- (사원명, 부서코드, 직급코드, 입사일)
--> 단일행 서브쿼리
    SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE DEPT_CODE = (SELECT DEPT_CODE
                       FROM EMPLOYEE
                       WHERE EMP_NAME = '하이유')
    AND JOB_CODE =  (SELECT JOB_CODE
                       FROM EMPLOYEE
                       WHERE EMP_NAME = '하이유');

--> 다중열 서브쿼리로 작성
    SELECT EMP_NAME, DEPT_CODE, JOB_CODE, HIRE_DATE
    FROM EMPLOYEE
    WHERE (DEPT_CODE, JOB_CODE) = (SELECT DEPT_CODE, JOB_CODE
                                   FROM EMPLOYEE
                                   WHERE EMP_NAME = '하이유');

-- 박나라 사원과 같은 직급코드, 같은 사수를 가지고 있는 사원들의 사번, 사원명, 직급코드, 사수번호 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, MANAGER_ID
FROM EMPLOYEE
WHERE ( JOB_CODE, MANAGER_ID ) = ( SELECT JOB_CODE, MANAGER_ID
                                    FROM EMPLOYEE
                                    WHERE EMP_NAME = '박나라')
AND EMP_NAME != '박나라';                  

----------------------------------------------------------------------------
/*
    4. 다중행 다중열 서브쿼리
*/
-- 1. 각 직급별 최소급여를 받는 사원 조회(사번, 사원명, 직급코드, 급여)
-- 1.1. 각 직급별 최소급여 조회
SELECT JOB_CODE, MIN(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE;
-- 1.2. 직급별 최소급여 받는 사원 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE JOB_CODE = 'J2' AND SALARY = 3700000
    OR JOB_CODE = 'J7' AND SALARY = 1380000
    ...;
    
--1.3. 서브쿼리 적용
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, MIN(SALARY)
                            FROM EMPLOYEE
                            GROUP BY JOB_CODE);
                            
-- 각 부서별 최고급여를 받는 사원들의 사번, 사원명, 부서코드, 급여
SELECT NVL(DEPT_CODE,'부서미정') AS "부서코드", MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE ;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE (DEPT_CODE, SALARY) IN (SELECT DEPT_CODE, MAX(SALARY)
                                FROM EMPLOYEE
                                GROUP BY DEPT_CODE);

--------------------------------------------------------------------------------

/*
    5. 인라인 뷰
        : FROM 절에 서브쿼리를 작성한 것
          서브쿼리를 수행한 결과를 마치 테이블처럼 사용
*/

-- 사원들의 사번, 이름, 보너스 포함 연봉, 부서코드 조회
-- 단, 보너스 포함 연봉은 NULL 이 되면 안됨
-- 단, 보너스 포함 연봉이 3천만원 이상인 사원들만 조회

 SELECT ROWNUM, EMP_ID, EMP_NAME, (SALARY + ( SALARY * NVL( BONUS, 0 )))*12 AS "연봉", DEPT_CODE
 FROM EMPLOYEE
 WHERE  ((SALARY + ( SALARY * NVL( BONUS, 0 )))*12) >= 30000000;
 -- ROWNUM 은 오라클에서 자동으로 부여해주는 순서값. 이는 FROM절을 기준으로 부여해줌
 
 --> 인라인 뷰를 주로 사용하는 예 >> TOP_N 분석 : 상위 몇 개만 조회
 -- 전 직원 중 급여가 가장 높은 다섯 명만 조회
 /* ROWNUM
        : 오라클에서 제공해주는 컬럼.
          조회된 순서대로 1부터 순번을 부여해주는 컬럼(자동생성됨)
*/        
 SELECT ROWNUM, EMP_NAME, SALARY
 FROM EMPLOYEE
 WHERE ROWNUM <= 5
 ORDER BY SALARY DESC;
  SELECT ROWNUM, EMP_NAME, SALARY
 FROM EMPLOYEE
  ORDER BY SALARY DESC;

 --> ORDER BY 절이 수행된 결과를 가지고 ROWNUM 부여 -> 상위 5명 조회
 SELECT EMP_NAME, SALARY
 FROM(SELECT EMP_NAME, SALARY
         FROM EMPLOYEE
         ORDER BY SALARY DESC)
 WHERE ROWNUM <= 5;
 
 -- 가장 최근에 입사한 사원 5명 조회(사원명, 급여, 입사일)
 SELECT EMP_NAME, SALARY, HIRE_DATE
 FROM (SELECT EMP_NAME, SALARY, HIRE_DATE
        FROM EMPLOYEE
        ORDER BY HIRE_DATE DESC)
 WHERE ROWNUM <= 5;

SELECT DEPT_CODE, ROUND(AVG(SALARY)) AS "평균급여"
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY 평균급여 DESC;

-- 각 부서별 평균급여가 높은 3개의 부서 조회
SELECT DEPT_CODE, 평균급여
FROM (SELECT DEPT_CODE, ROUND(AVG(SALARY)) AS "평균급여"
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        ORDER BY 평균급여 DESC)
WHERE ROWNUM <= 3;
-- > 그룹함수를 SELECT 문에서 가져오려면 별칭을 부여해줘야함

-- 각 부서별 평균급여가 270만원을 초과하는 부서들에 대해
-- 부서코드, 부서별 총 급여합, 부서별 평균급여, 부서별 사원수 조회

SELECT DEPT_CODE, SUM(SALARY) AS "총합", ROUND(AVG(SALARY)) AS "평균", COUNT(*) AS "인원수"
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING ROUND(AVG(SALARY)) > 2700000
ORDER BY DEPT_CODE ASC;
--> GROUP BY 만으로도 가능하긴 함

SELECT *
FROM (SELECT DEPT_CODE, SUM(SALARY) AS "총합", ROUND(AVG(SALARY)) AS "평균", COUNT(*) AS "인원수"
        FROM EMPLOYEE
        GROUP BY DEPT_CODE
        HAVING ROUND(AVG(SALARY)) > 2700000
        ORDER BY DEPT_CODE ASC)
WHERE 평균 >= 2700000;

--------------------------------------------------------------------------------
/*
    * 순위를 매기는 함수(WINDOW FUNCTION)
    RANK() OVER(정렬 기준) | DANSE_RANK() OVER(정렬 기준)
    RANK() OVER(정렬 기준)
        : 공동 순위 이후의 등수를 동일한 인원 수만큼 건너뛰고 순위 계산
    DENSE_RANK() OVER(정렬 기준)
        : 공동 순위가 있다고 해도 그 다음 등수를 무조건 1씩 증가시킴
    
    무조건  SELECT 절에서만 사용 가능    
*/

-- 급여가 높은 순서대로 순위를 매겨서 조회
SELECT EMP_NAME, SALARY, 
        RANK() OVER(ORDER BY SALARY DESC) AS "순위"
FROM EMPLOYEE;
--> 공동 19등 2명. 그 뒤 순위는 21등으로 20등에서 하나를 건너뛴 것을 알 수 있음

SELECT  EMP_NAME, SALARY, 
        DENSE_RANK() OVER(ORDER BY SALARY DESC) AS "순위"
FROM EMPLOYEE;
--> 공동 순위 뒤에 바로 그 다음 순위가 나오는 것을 알 수 있음.

SELECT *
FROM (SELECT  EMP_NAME, SALARY, 
        DENSE_RANK() OVER(ORDER BY SALARY DESC) AS "순위"
        FROM EMPLOYEE)
WHERE 순위 <= 5;



                       


















                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    