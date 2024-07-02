/*
    <GROUP BY절>
        : 그룹기준을 제시할 수 있는 구문(해당 그룹기준별로 여러 그룹으로 묶을 수 있음)
          여러 개의 값들을 하나의 그룹으로 묶어서 처리하는 목적
*/
SELECT SUM(SALARY)
FROM EMPLOYEE;
-- 전체 사원을 하나의 그룹으로 묶어서 총 합을 구한 결과

-- 각 부서별 총 급여
-- 각 부서들이 전부 그룹임
SELECT DEPT_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ASC NULLS FIRST;

-- 각 부서별 사원 수
SELECT DEPT_CODE, COUNT(*) AS "사원수", SUM(SALARY) -- 3
FROM EMPLOYEE -- 1
GROUP BY DEPT_CODE  -- 2
ORDER BY DEPT_CODE ASC NULLS FIRST; -- 4

-- 각 직급별 총사원수, 보너스를 받는 사원 수, 급여합, 평균급여, 최저급여, 최고급여
-- 직급 오름차순 정렬
SELECT JOB_CODE AS "직급", 
        COUNT(*) AS "사원수",
        COUNT(BONUS) AS "보너스대상",
        TO_CHAR(SUM(SALARY) , 'L99,999,999'),
        LPAD((TO_CHAR( SUM(SALARY) , '99,999,999')), '11') AS "급여합계(원)",
        LPAD((TO_CHAR( ROUND(AVG(SALARY)), '9,999,999')), '10') AS "평균급여(원)",
        LPAD((TO_CHAR( MIN(SALARY), '9,999,999')), '10') AS "최저급여(원)",
        LPAD((TO_CHAR( MAX(SALARY), '9,999,999')), '10')AS "최고급여(원)"
FROM EMPLOYEE
GROUP BY JOB_CODE
ORDER BY JOB_CODE;

--GROUP BY 절에 함수식 사용 가능
SELECT  DECODE( SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') AS "성별",
        COUNT(*) AS "사원수",
        COUNT(BONUS) AS "보너스대상",
        LPAD((TO_CHAR( SUM(SALARY) , 'FML99,999,999')), '12') AS "급여합계(원)",
        LPAD((TO_CHAR( ROUND(AVG(SALARY)), 'FML9,999,999')), '11') AS "평균급여(원)",
        LPAD((TO_CHAR( MIN(SALARY), 'FML9,999,999')), '11') AS "최저급여(원)",
        LPAD((TO_CHAR( MAX(SALARY), 'FML9,999,999')), '11')AS "최고급여(원)"
FROM EMPLOYEE
GROUP BY SUBSTR(EMP_NO, 8, 1);
-- TO_CHAR를 사용해 원화 표시를 기입하면 공백이 생겨버리고 해당 공백은 LPAD를 사용해도 없어지지 않음
-- 따라서 TO_CHAR를 사용해 원화를 표시할 경우 FM을 추가적으로 명시하여 강제로 공백을 없애줄 수 밖에 없음
-- 원래 자릿수보다 4를 더해줘야 제대로 나옴

-- GROUP BY 절에 여러 컬럼 기술 가능
SELECT DEPT_CODE, JOB_CODE, COUNT(*), SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE, JOB_CODE
ORDER BY DEPT_CODE, JOB_CODE;

--------------------------------------------------------------------------------
/*
    <HAVING 절>
        : "그룹에 대한 조건" 제시할 때 사용되는 구문(주로 그룹함수식을 가지고 조건 만듦)
*/
-- 각 부서별 평균 급여 조회(부서코드, 평균급여)
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
ORDER BY DEPT_CODE ASC NULLS FIRST;

-- 각 부서별 평균급여가 300만원 이상인 부서들만 조회
SELECT DEPT_CODE, ROUND(AVG(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING AVG(SALARY) >= 3000000;

/*
    WHERE 과 HAVING 차이
    왜 GROUP BY 사용할 때 HAVING 대신 WHERE 은 사용하지 못할까?
        : 실행 순서에서 WHERE이 GROUP BY 이전에 실행되기 때문에 그룹별로 조건을 수행하지 못하고
          모든 행에서 적용되기 때문에 사용할 수 없음
*/

--=======================================================================
-- 직급별 직급코드, 총 급여합(단, 직급별 급여합이 1000만원 이상인 직급만 조회)
SELECT JOB_CODE, SUM(SALARY)
FROM EMPLOYEE
GROUP BY JOB_CODE
HAVING SUM(SALARY) >= 10000000
ORDER BY JOB_CODE;

-- 부서별 보너스를 받는 사원이 없는 부서의 부서코드
SELECT DEPT_CODE, COUNT(*)
FROM EMPLOYEE
GROUP BY DEPT_CODE
HAVING COUNT(BONUS) = 0
ORDER BY DEPT_CODE;

------------------------------------------------------------------------
/*
    SELECT * | 컬럼 | 컬럼 AS 별칭 | 함수식 | 산술연산식------5
    FROM 테이블 | DUAL -----------------------------------1
    WHERE 조건식(연산자들을 활용하여 기술) -------------------2
    GROUP BY 그룹 기준이 되는 컬럼 | 함수식 -----------------3
    HAVING 조건식(그룹함수를 토대로 기술) --------------------4
    ORDER BY 컬럼 | 별칭 | 컬럼순서(NUMBER) ----------------6
                [ASC | DESC] [NULLS FIRST | NULLS LAST]
*/

--========================================================================
/*
    <집합 연산자(SET OPERATION)>
        : 여러 개의 쿼리문을 하나의 쿼리문으로 만드는 연산자
        
    - UNION : OR | 합집합
                두 쿼리문 수행한 결과값을 더한다.
    - INTERSECT : AND | 교집합
                    두 쿼리문을 수행한 결과값에 중복된 결과값
    - UNION ALL : 합집합 + 교집합
                    중복되는게 두 번 표현될 수 있다.
    - MINUS : 차집합
                선행결과값에 후행결과값을 뺀 나머지
*/

-- 1. UNION
-- 부서코드가 D5인 사원 또는 급여가 300만원 초과인 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' OR SALARY > 3000000;

-- 부서코드가 D5인 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- 급여가 300만원 초과인 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- UNION으로 합하기
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

-- 2. INTERSECT(교집합)
-- 부서코드가 D5이면서 급여가 300만원 초과인 사원들의 사번, 이름, 부서코드, 급여 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5' AND SALARY > 3000000;

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
INTERSECT
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000;

--------------------------------------------------------------------------------
-- 집합연산자 사용시 주의사항
-- 1. 컬럼의 개수는 동일해야함
-- 2. 컬럼자리마다 동일한 타입으로 기술해야 함
-- 3. 정렬 희망 시 ORDER BY 는 마지막에 기술
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;

--------------------------------------------------------------------------------------
-- 3. UNION ALL
--      : 여러 개의 쿼리 결과를 무조건 다 더하는 연산자(중복 제거 안됨)

SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
UNION ALL
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;
-------------------------------------------------------------------------------
-- 4. MINUS
--      : 선행 SELECT 결과에서 후행 SELECT 결과를 뺀 나머지(차집합)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5'
MINUS
SELECT EMP_ID, EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3000000
ORDER BY EMP_ID;
-- 부서코드가 D5인 사원들 중 급여가 300만원 초과인 사원들을 제외하고 조회











