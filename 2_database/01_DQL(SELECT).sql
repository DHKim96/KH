/*
    <SELECT>
    SELECT 가져오고 싶은 정보 FROM 테이블;
    SELECT 컬럼1, 컬럼2, 컬럼3 ... FROM 테이블;
    
    만약 모든 사원의 정보를 보고 싶다면
    SELECT * FROM EMPLOYEE;
*/
-- 모든 사원의 정보를 보고싶다면
SELECT * FROM EMPLOYEE;

-- 모든 사원의 이름, 주민등록번호, 폰 번호를 알고 싶다면
SELECT EMP_NAME, EMP_NO, PHONE
FROM EMPLOYEE;

------------------------실습-----------------------------------
--JOB테이블의 직급명 컬럼만 조회
SELECT JOB_NAME FROM JOB;

--DEPARTMENT 테이블의 모든 컬럼 조회
SELECT * FROM DEPARTMENT;

--DEPARTMENT 테이블의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT;

--EMPLOYEE 테이블의 사원명, 이메일, 전화번호, 입사일, 급여 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY
FROM EMPLOYEE;

-- <컬럼값을 통한 산술 연산>
-- SELECT절 컬럼명 작성 부분에 산술 연산 가능
-- EX) EMPLOYEE 테이블의 사원명, 사원의 연봉(SALALY * 12)을 조회
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEE 테이블의 사원명, 급여, 보너스, 연봉, 보너스 포함 연봉 조회(급여 + (급여 * 보너스)) * 12
SELECT EMP_NAME, SALARY, BONUS, SALARY * 12, ( SALARY + ( SALARY * BONUS ) ) * 12
FROM EMPLOYEE;
-- 산술 연산 과정 중에 NULL 데이터가 포함되어 있다면 무조건 결과값은 NULL

-- 사원명, 입사일, 근무일수를 조회
-- 현 시간 - 입사일 = 근무한 시간
-- DATE - DATE => 무조건 일자(DAY)로 표시가 됨
-- 코드실행시 날짜를 표시하는 상수 : SYSDATE [년/월/일/시/분/초] 
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

SELECT SYSDATE FROM DUAL;
-- DUAL : 오라클에서 제공해주는 가상 데이터 테이블(더미 데이터)

/*
    <컬럼명에 별칭 지정하기>
    산술 연산을 하게 되면 컬럼명이 지저분해짐.
    이때 컬럼명에 별칭을 부여해서 깔끔하게 가져올 수 있음.
    [표현법]
    컬럼명 별칭 | 컬럼명 AS 별칭 | 컬럼명 "별칭" | 컬럼명 AS "별칭"
*/

SELECT EMP_NAME 사원명, SALARY AS 급여, BONUS "보너스", ( SALARY * 12 ) AS "연봉(원)",
        ( SALARY + ( SALARY * BONUS ) ) * 12 AS "총 소득"
FROM EMPLOYEE;

/*
    <리터럴>
    임의로 지정한 문자열('')
    조회된 결과(RESULT SET)의 모든 행에 반복적으로 출력
*/

-- EMPLOYEE 테이블의 사번, 사원명, 급여
SELECT EMP_ID, EMP_NAME, SALARY, '원' AS "단위"
FROM EMPLOYEE;

/*
    <연결연산자 : ||>
    여러 컬럼값들을 마치 하나의 컬럼처럼 연결할 수 있다.
*/

-- 사번, 이름, 급여를 하나의 컬럼으로 조회
SELECT EMP_ID || EMP_NAME || SALARY || '원'
FROM EMPLOYEE;

-- EMPLOYEE 테이블에서 모든 사원의 월급을 조회한다.
-- 다음과 같이 결과가 나오도록 출력하라
-- XX의 월급은 XX원입니다.
SELECT EMP_NAME || '의 월급은 ' || SALARY || '원입니다.' AS "급여"
FROM EMPLOYEE;

/*
    <DISTINCT>
    중복 제거 - 컬럼에 표시된 값들을 한 번 씩만 조회하고자 할 때 사용
*/

-- EMPLOYEE 직급 코드 조회(중복 제거)
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE 부서 코드 조회(중복 제거)
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
-- FROM EMPLOYEE;
-- 위처럼 작성하면 에러 발생. DISTINCT는 한 번만 사용 가능

SELECT DISTINCT JOB_CODE, DEPT_CODE
-- 위처럼 사용시 (JOB_CODE, DEPT_CODE) 쌍으로 묶어서 중복을 제거한 값을 보여줌
FROM EMPLOYEE;

================================================================================

/*
    <WHERE절>
    조회하고자 하는 테이블로부터 특정 조건에 만족하는 데이터만을 조회할 때 사용
    조건식에서도 다양한 연산자 사용 가능
    [표현법]
    SELECT 컬럼, 컬럼, 컬럼 연산
    FROM 테이블
    WHERE 조건;
    
    >> 비교 연산자 <<
    대소 비교 : >, <, >= , <=
    동등 비교 : (양쪽 같음)=, (양쪽 다름)!=, ^=, <>
*/

-- EMPLOYEE 에서 부서 코드가 'D9'인 사원들만 조회(모든 컬럼)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE 에서 부서 코드가 'D1'인 사원들의 사원명, 급여, 부서코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- EMPLOYEE 에서 부서 코드가 'D1'이 아닌 사람들의 사원명, 급여, 부서 코드 조회
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D1';

-- 월급이 400만원 이상인 사원들의 사원명, 부서 코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-----------------------------------실습-----------------------------------------

-- 1. 급여가 300만원 이상인 사원들의 사원명, 급여, 입사일, 연봉(별칭 : 연봉), 조회
SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 AS "연봉"
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. 연봉이 5천만원 이상인 사원들의 사원명, 급여, 연봉(별칭 : 연봉), 부서코드 조회 
SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 AS "연봉", DEPT_CODE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000;
-- WHERE 연봉 >= 5000000; : 에러 발생
-- 원인 : 실행 순서 FROM절 -> WHERE절 -> SELECT절 이기 때문
-- 별칭은 SELECT절에서 지정되기에 그 이전에 실행되는 WHERE절에서는 별칭 사용 불가함.

-- 3. 직급코드가 'J3'가 아닌 사원들의 사번, 사원명, 직급코드, 퇴사여부 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_YN
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

-- 4. 급여가 350만원 이상 600만원 이하의 모든 사원의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

/*
    <AND, OR 연산자>
    조건을 여러 개 연결할 때 사용
    [표현법]
    조건A AND 조건B -> 조건A 와 조건B 모두 만족하는 값만 가져옴
    조건A OR 조건B -> 조건A 와 조건B 중 하나라도 만족하는 값은 가져옴
    
    <BETWEEN AND>
    조건식에 사용하는 구문
    <= >= 범위에 대한 조건을 제시할 때 사용하는 연산자(이상, 이하만 가능)
    [표현법]
    비교대상 컬럼 BETWEEN 하한값 AND 상한값
*/

-- 급여가 350만원 이상 600만원 이하인 모든 사원의 사원명, 사번, 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY >= 3500000 AND SALARY <= 6000000;
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- 급여가 350만원 미만 600만원 초과인 모든 사원의 사원명 사번 급여 조회
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY < 3500000 OR SALARY > 6000000;
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;

-- 논리부정연산자 NO
--      컬럼명 앞 또는 BETWEEN 앞에 선언 가능

-- 입사일이 '90/01/01' ~ '01/01/01' 사원 전체 조회
SELECT *
FROM EMPLOYEE
-- WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';
-- DATE 타입도 비교 연산 가능

--================================================================================

/*
    <LIKE>
    비교하고자 하는 컬럼값이 사용자가 제시한 특정 패턴에 만족할 경우 조회 CF)JAVA의 SWITCH문
    
    [표현법]
    비교할 대상 컬럼 LIKE '특정 패턴';
    
    특정 패턴을 제시할 때 와일드카드라는 특정패턴이 정의되어있음
       1. '%' : 포함문자 검색(0글자 이상 전부 조회)
            
            EX) 비교대상컬럼 LIKE '문자%'
                    : 비교 대상 컬럼값 중 해당 문자로 시작하는 값들만 조회
                비교대상컬럼 LIKE '%문자'
                    : 비교 대상 컬럼값 중 해당 문자로 끝나는 값들만 조회
                비교대상컬럼 LIKE '%문자%' 
                    : 비교 대상 컬럼값 중 해당 문자가 포함된 값 조회(키워드 검색)
            
            => '%' 활용 문제
            -- 사원들 중에 성이 전씨인 사원들의 사원명, 급여, 입사일 조회
            SELECT EMP_NAME, SALARY, HIRE_DATE
            FROM EMPLOYEE
            WHERE EMP_NAME LIKE '전%';
            
            -- 사원들 중에 이름에 '하' 가 포함된 사원의 사원명, 전화번호 목록을 조회
            SELECT EMP_NAME, PHONE
            FROM EMPLOYEE
            WHERE EMP_NAME LIKE '%하%';

       2. '_' : 1글자를 대체하는 검색(_개수에 따라서 글자 수 대체 가능)
           
            EX) 비교대상컬럼 LIKE '_문자'
                    : 비교 대상 컬럼값 문자 앞에 아무 글자나 N 글자가 있는 값을 조회
                비교대상컬럼 LIKE '문자_'
                    : 비교 대상 컬럼값 문자 뒤에 ~
                비교대상컬럼 LIKE '_문자_'
                    : 비교 대상 컬럼값 문자 앞뒤에 ~
                    
            => '_' 활용 문제        
             -- 사원들 중에서 이름에 중간 글자가 '하'인 사원의 사원명, 전화번호 목록 조회
            SELECT EMP_NAME, PHONE
            FROM EMPLOYEE
            WHERE EMP_NAME LIKE '_하_';
            
        => '%' '_' 활용한 문제
        -- 전화번호의 3번째 자리가 1인 사원들의 사번, 사원명, 전화번호 조회
        SELECT EMP_ID, EMP_NAME, PHONE
        FROM EMPLOYEE
        WHERE PHONE LIKE '__1%';
*/
-- 이메일 주소 중 _앞글자가 3글자인 사원들의 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
-- WHERE EMAIL LIKE '____%';
    -- 와일드카드 문자 '_' 때문에 정상출력이 되지 않음
    -- 와일드카드 문자와 일반 문자의 구분이 필요함
-- => 데이터 값으로 취급하고 싶은 와일드카드 문자 앞에 나만의 탈출문자를 제시해 탈출시켜줘야 함
-- ESCAPE OPTION
-- WHERE EMAIL LIKE '___\_%'; : \가 탈출 문자임을 알려줘야 함
WHERE EMAIL LIKE '___\_%' ESCAPE '\';
-- ESCAPE OPTION 을 설정하는 문자는 아무 문자나 상관없음 BUT 대체적으로 역슬래시 사용

-- 위 사원들이 아닌 그 외의 사원들을 조회하고 싶다 컬럼 동일
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE NOT EMAIL LIKE '___\_%' ESCAPE '\';

--=======================================실습===========================
-- 1. 이름이 '연'으로 끝나는 사원들의 사원명, 입사일 조회
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';

-- 2. 전화번호 처음 3자리가 010이 아닌 사원들의 사원명, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

-- 3. 이름에 '하'가 포함되어있고 급여가 240만원 이상인 사원들의 사원명, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%' AND SALARY >= 2400000;

-- 4. 부서테이블에서 해외영업부인 부서들의 부서코드, 부서명 조회
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '해외영업%';
-- WHERE DEPT_TITLE LIKE '해외영업_부'; 도 가능

/*
    <IN>
    WHERE절에서 비교 대상 컬럼값이 사용자가 제시한 목록 내 포함 여부 검사
    
    [표현법]
    비교대상컬럼 IN ('값1', '값2', ...)
*/

-- 부서코드가 D6 이거나 D8 이거나 D5 인 부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

--=================================================================

/*
    <IS NULL & IS NOT NULL>
    컬럼값에 NULL이 있을 경우 NULL값을 비교하기 위해서 사용하는 연산자
*/

-- 보너스를 받지 않은 사원들의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;
-- 보너스를 받는 경우 WHERE BONUS IS NOT NULL;

-- 사수가 없는 사원들의 사원명, 사수 사번, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- 부서배치를 아직 받지 않았고 보너스를 받은 사원들의 이름, 보너스, 부서코드를 조회
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-- =========================================================================
/*
    <연산자 우선순위>
    1. 산술 연산자
    2. 연결 연산자
    3. 비교 연산자
    4. IS(NOT)NULL / LIKE / IN
    5. BETWEEN A AND B
    6. NOT
    7. AND
    8. OR
*/

-- 직급코드가 J7 이거나 J2 인 사원들 중에 급여가 200만원 이상인 사원들의 모든 컬럼 조회
SELECT *
FROM EMPLOYEE
-- WHERE  ( JOB_CODE = 'J7' OR JOB_CODE = 'J2' ) AND SALARY >= 2000000;
WHERE (JOB_CODE IN ('J7', 'J2') ) AND SALARY >= 2000000;

--================================실습=============================================
-- 1. 사수가 없고 부서배치도 받지 않은 사원들의 사원명, 사번, 부서코드 조회
SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 2. 연봉(보너스 미포함)이 3천만원 이상이고 보너스를 받지 않은 사원들의 사번, 사원명, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE ( SALARY * 12 ) >= 30000000 AND BONUS IS NULL;

-- 3. 입사일이 '95/01/01' 이상이고 부서 배치를 받지 않은 사원들의 사번, 사원명, 입사일, 부서코드 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE  HIRE_DATE >= '95/01/01'  AND DEPT_CODE IS NULL ;

-- 4. 급여가 200만원 이상이고 500만원 이하인 사원 중 입사일이 '01/01/01' 이상이고 보너스를 받지 않은 사원들의
사번, 사원명, 급여, 입사일, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE ( SALARY BETWEEN 2000000 AND 5000000 ) AND ( HIRE_DATE >= '01/01/01') AND BONUS IS NULL;

-- 5. 보너스를 포함 연봉이 NULL 이 아니고 이름에 '하'가 포함된 사원들의 사번, 사원명, 급여, 보너스 포함 연봉 조회
SELECT EMP_ID, EMP_NAME, SALARY, ( SALARY + ( SALARY * BONUS ) ) * 12
FROM EMPLOYEE
WHERE   ( ( SALARY + ( SALARY * BONUS ) ) * 12 ) IS NOT NULL  AND EMP_NAME LIKE '%하%';



