SELECT EMP_ID, EMP_NAME, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL;

/*
    <ORDER BY 절>
    SELECT절 가장 마지막 줄에 작성
    실행 순서 또한 가장 마지막에 실행함
    
    [표현법]
    SELECt 조회할 컬럼...
    FROM 조회할 테이블
    WHERE 조건식
    ORDER BY 정렬 기준이 될 컬럼명 | 별칭 | 컬럼 순번 [ASC | DESC] [NULLS FIRST | NULLS LAST]
    - ASC : 오름차순 (기본값)
    - DESC : 내림차순
    - NULLS FIRST : 정렬 기준 컬럼값에 NULL 있을 경우 해당 데이터 맨 앞에 배치(DESC일 때 기본값)
    - NULLS LAST : ~ 데이터 맨 뒤에 배치(ASC일때 기본값) 즉, NULL 을 가장 큰 값으로 인식하며 기본값임
*/

SELECT *
FROM EMPLOYEE
-- ORDER BY BONUS; 기본값이 오름차순 -- 기준 컬럼의 데이터값이 같을 경우 생성 순서에 따라 나오는 듯
-- ORDER BY BONUS ASC;
-- ORDER BY BONUS ASC NULLS FIRST; 
-- ORDER BY BONUS DESC;
ORDER BY BONUS DESC, SALARY ASC;
-- 정렬 기준 컬럼값이 동일할 경우 그 다음 차순을 위해서 여러 개의 기준 컬럼을 제시할 수 있음

-- 전 사원의 사원명, 연봉(보너스 제외) 조회(이 때 연봉별 내림차순 정렬)
SELECT EMP_NAME, ( SALARY * 12 ) AS "연봉"
FROM EMPLOYEE
-- ORDER BY ( SALARY * 12 ) DESC;
-- ORDER BY 연봉 DESC;
ORDER BY 2 DESC; -- 셀렉트절의 두 번째 컬럼을 정렬 기준으로 한다는 의미 BUT 선호하는 스타일은 아님

--========================================================
/*
    <함수 FUNCTION>
    전달된 컬럼값을 읽어들여서 함수를 실행한 결과를 반환
    
    - 단일행 함수
        : N개의 값을 읽어들여서 N개의 결과값을 리턴(매행마다 함수 실행 결과를 반환)
    - 그룹 함수
        : N개의 값을 읽어들여서 1개의 결과값을 리턴(그룹을 지어 그룹별로 함수 실행 결과 반환)
    >> SELECT 절에서 단일행 함수랑 그룹함수를 함께 사용하지 못함
    왜? 결과행의 갯수가 다르기 때문에
    
    >> 함수식을 기술할 수 있는 위치 : SELECT절, WHERE절, ORDER BY절, GROUP BY절, HAVING절
*/

--============================<단일행 함수>====================================
/*
    <문자 처리 함수>
    
    * LENGTH(컬럼 | '문자열')
        : 해당 문자열의 글자 수 반환
    * LENGTHB(컬럼 | '문자열')
        : 해당 문자열의 바이트 수를 반환
        CF) 한글은 글자당 3BYTE
            영문자, 숫자, 특수문자 글자당 1BYTE
*/

SELECT LENGTH('오라클'), LENGTHB('오라클')
FROM DUAL;

SELECT LENGTH('ORACLE'), LENGTHB('ORACLE')
FROM DUAL;

SELECT EMP_NAME, LENGTH(EMP_NAME), LENGTHB(EMP_NAME),
        EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL)
FROM EMPLOYEE;
    

--================================================================

/*
    *INSTR
    문자열로부터 특정 문자의 시작 위치를 찾아서 반환
    
    INSTR(컬럼 | '문자열', '찾고자 하는 문자', ['찾을 위치의 시작값(디폴트: 1)', 순번(디폴트: 1)])
*/
SELECT INSTR('AABAACAABBAA', 'B') FROM DUAL;  -- 첫 B는 세 번째 위치에 있다고 나옴 => NUMBER로 반환

SELECT INSTR('AABAACAABBAA', 'B', -1) FROM DUAL;
-- '-숫자'는 뒤에서부터 찾는 숫자값, 허나 읽을 때는 앞으로 읽어서 알려줌

SELECT INSTR('AABAACAABBAA', 'B', 1, 2) FROM DUAL;
-- 순번 제시하려면 찾을 위치의 시작값을 표시해야함

SELECT EMAIL, INSTR(EMAIL, '_') AS "LOCATION",
                INSTR(EMAIL, '@') AS "@위치"
FROM EMPLOYEE;

--=========================================================================

/*
    *SUBSTR / 자주 쓰임
        : 문자열에서 특정 문자열을 추출해서 반환
    
    [표현법]
    SUBSTR(STRING, POSITION, [LENGTH])
    - STRING : 문자 타입의 컬럼 | '문자열'
    - POSITION : 문자열 추출할 시작 위치의 값
    - LENGTH : 추출할 문자의 갯수(생략하면 끝까지)
*/

SELECT SUBSTR('SHOWMETHEMONEY', 7) FROM DUAL; -- 7번째 위치부터 끝까지 추출

--SHOWME만 출력
SELECT SUBSTR('SHOWMETHEMONEY', 1, 6) FROM DUAL;

SELECT SUBSTR('SHOWMETHEMONEY', -8, 3) FROM DUAL;

SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "성별"
FROM EMPLOYEE;

-- 사원들 중 여사원들만 조회
SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "성별"
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '2';

-- 사원들 중 남사원들만 조회
SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, 8, 1) AS "성별"
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1'
ORDER BY EMP_NAME;

-- 함수 중첩 사용 가능
-- 이메일 아이디 부분만 추출
-- 사원 목록에서 사원명, 이메일, 아이디 조회
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, ( INSTR(EMAIL, '@') - 1 )) AS "아이디"
FROM EMPLOYEE
ORDER BY EMP_NAME;
--==================================================================

/*
    *LPAD / RPAD
        : 문자열을 조회할 때 통일감 있게 조회하고자 사용
        
        [표현법]
        LPAD / RPAD(STRING, 최종적으로 반환할 문자의 길이, [덧붙이고자 하는 문자])
        
        문자열에 덧붙이고자 하는 문자를 왼쪽 또는 오른쪽에 붙여서 최종 N 길이만큼의 문자열 반환    
*/

-- 20만큼의 길이 중 EMAIL 컬럼값은 오른쪽으로 정렬하고 나머지 부분은 공백으로 채운다
SELECT EMP_NAME, LPAD(EMAIL, 20) FROM EMPLOYEE; -- 공백이 디폴트임

SELECT EMP_NAME, RPAD(EMAIL, 20) FROM EMPLOYEE;

SELECT RPAD('910524-1', 14, '*')
FROM DUAL;

-- 사원들의 사원명, 주민등록번호 조회(단 조회 형식은 "910524-1******" 형식)
SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, 8), 14, '*')
FROM EMPLOYEE
ORDER BY EMP_NO;

--=======================================================================
/*
    *LTRIM / RTRIM
        : 문자열에서 특정 문자를 제거한 나머지를 반환
        
        [표현법]
        LTRIM/RTRIM(STRING, [제거하고자 하는 문자들])
        
        문자열의 왼쪽 혹은 오른쪽에서 제거하고자 하는 문자들을 찾아서 제거한 나머지 문자열을 반환
*/

SELECT LTRIM('    K  H') -- 왼쪽에서 다른 문자가 나올때까지만 공백 제거
FROM DUAL;

SELECT LTRIM('123123KH123', '123') FROM DUAL;
-- '123'을 통으로 보는게 아니라 한 문자씩 인식해서 제거

SELECT LTRIM('ACABACCKH', 'ABC') FROM DUAL;
-- 제거하고자 하는 문자들! NOT 문자열

SELECT RTRIM('574185KH123', '0123456789')
FROM DUAL;

/*
    *TRIM
        : 문자열의 앞/뒤/양쪽에 있는 지정한 문자들을 제거한 나머지 문자열 반환
        [표현법]
        TRIM([LEADING | TRAILING | BOTH] 제거하고자하는 문자열 FROM 문자열)
*/

SELECT TRIM('       K   H      ')
FROM DUAL; 
-- (기본값)양쪽에 있는 공백 제거

SELECT TRIM('Z' FROM 'ZZZZKHZZZZ')
FROM DUAL;
SELECT TRIM(BOTH 'Z' FROM 'ZZZZKHZZZZ')
FROM DUAL;
-- 양쪽에 있는 특정 문자(들) 제거

SELECT TRIM(LEADING 'Z' FROM 'ZZZZKHZZZZ')
FROM DUAL;
-- LTRIM 과 유사한 기능

SELECT TRIM(TRAILING 'Z' FROM 'ZZZZKHZZZZ')
FROM DUAL;
-- RTRIM과 유사한 기능

--===================================================================
/*
    *LOWER / UPPER / INITCAP
    
    * LOWER
        : 문자열을 소문자로 변경한 문자열 반환
    * UPPER
        : 문자열을 대문자로 변경한 문자열 반환
    * INITCAP
        : 띄어쓰기 기준 첫 글자마다 대문자로 변경한 문자열 반환
*/

SELECT LOWER('Welcome To My World')
FROM DUAL;

SELECT UPPER('Welcome To My World')
FROM DUAL;

SELECT INITCAP( LOWER('Welcome To My World') ) FROM DUAL;

--=====================================================================

/*
    *CONCAT
       : 문자열 두 개 전달 받아 하나로 합친 후 반환(세 개 이상은 안됨)
            따라서 ||(연결연산자) 많이 사용
       [표현법]
       CONCAT(STRING1, STRING2)
*/

SELECT CONCAT('가나다', 'ABC') FROM DUAL;

SELECT '가나다' || 'ABC'
FROM DUAL;

--========================================================================

/*
    *REPLACE
        : 특정 문자열의 특정 부분을 다른 부분으로 교체
        [표현법]
        REPLACE(문자열, 찾을 문자열, 변경할 문자열)
*/

SELECT EMAIL, REPLACE(EMAIL, 'KH.or.kr', 'gmail.com')
FROM EMPLOYEE;

--======================================================================
/*
    <숫자 처리 함수>
    * ABS
        : 숫자의 절대값을 구해주는 함수
        [표현법]
        ABS(NUMBER)
*/

SELECT ABS(-10), ABS(-6.3) FROM DUAL;


/*
    *MOD
        : 두 수를 나눈 나머지 값을 반환해주는 함수
        [표현법]
        MOD(NUMBER, NUMBER)
*/

SELECT MOD(10, 3) FROM DUAL;
SELECT MOD(10.9, 3) FROM DUAL;

/*
    *ROUND
        : 반올림한 결과를 반환
        
        [표현법]
        ROUND(NUMBER, [위치]) 
        
        위치의 기본값은 0(소수점 첫번째 자리에서 반올림)
        양수로 증가할수록 소수점 뒤로 한 자리씩 이동해서 반올림
        음수로 감소할수록 소수점 앞으로 한 자리씩 이동해서 반올림
*/
SELECT ROUND(123.456) FROM DUAL;
SELECT ROUND(123.456, 1) FROM DUAL; 
SELECT ROUND(123.456, -1) FROM DUAL;

/*
    *CEIL
        : 올림 처리를 위한 함수
        
        [표현법]
        CEIL(NUMBER)
*/
SELECT CEIL(123.456) FROM DUAL;

/*
    *FLOOR
        : 버림 처리 위한 함수
        
        [표현법]
        FLOOR(NUMBER)
*/
SELECT FLOOR(123.955) FROM DUAL;

/*
    *TRUNC
        : 버림 처리 함수 2
        
        [표현법]
        TRUNC(NUMBER, [위치])
        
        FLOOR 함수와 다르게 버림 위치 설정 가능
*/
SELECT TRUNC(123.952) FROM DUAL;
SELECT TRUNC(123.952, 1) FROM DUAL;
SELECT TRUNC(123.952, -1) FROM DUAL;

--=============================================QUIZ=================================
-- 검색하고자 하는 내용
-- JOB_CODE가 J7 이거나 J6이면서 SALARY값이 200만원 이상이고
-- BONUS가 있고 여자이며 이메일 주소는 _앞에 세 글자만 있는 사원의
-- 이름, 주민등록번호, 직급코드, 부서코드, 급여, 보너스를 조회하고 싶다.
-- 정상적으로 조회되면 결과가 2개
SELECT EMP_NAME, EMP_NO, JOB_CODE, DEPT_CODE, SALARY, BONUS
FROM EMPLOYEE
WHERE ( JOB_CODE IN ('J7', 'J6')) AND 
(SALARY >= 2000000) AND 
( BONUS IS NOT NULL ) AND
( SUBSTR(EMP_NO, 8, 1) IN ( '2', '4') ) AND 
( EMAIL LIKE '___\_%' ESCAPE '\' );


--=======================================================================
--    <날짜 처리 함수>

/*
    *SYSDATE
        : 시스템의 현재 날짜 및 시간 반환
*/
SELECT SYSDATE FROM DUAL;

/*
    *MONTHS_BETWEEN
        : 두 날자 사이의 개월 수 반환
        
        [표현법]
        MONTHS_BETWEEN(A, B)
*/
-- 사원들의 사원명, 입사일, 근무일수, 근무개월수를 조회
SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE - HIRE_DATE),
        FLOOR( MONTHS_BETWEEN(SYSDATE, HIRE_DATE) )
FROM EMPLOYEE;

SELECT EMP_NAME, HIRE_DATE, FLOOR(SYSDATE - HIRE_DATE),
        CEIL( MONTHS_BETWEEN(SYSDATE, HIRE_DATE) ) || '개월차' AS "근속개월수"
FROM EMPLOYEE;

/*
    *ADD_MONTHS
        : 특정 날짜에 NUMBER개월수를 더해서 반환
        
        [표현법]
        ADD_MONTHS(특정 날짜, NUMBER)
*/
SELECT ADD_MONTHS(SYSDATE, 4) FROM DUAL;

-- 근로자 테이블에서 사원명, 입사일, 입사 후 3개월의 날짜 조회(정규직 전환일)
SELECT EMP_NAME, HIRE_DATE, ADD_MONTHS(HIRE_DATE, 3) AS "정규직 전환일"
FROM EMPLOYEE;

/*
    *NEXT_DAY
        : 특정 날짜 이후 가장 가까운 요일의 날짜 반환
        
        [표현법]
        NEXT_DAY(DATE, 요일(문자 | 숫자) )
        숫자를 리터럴('')로 표현하면 안됨
*/
SELECT NEXT_DAY(SYSDATE, '토요일') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;
SELECT NEXT_DAY(SYSDATE, 7) FROM DUAL;
-- SELECT NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL; -- 사용 언어팩이 한국어라 안됨
--CF) 언어 변경
ALTER SESSION SET NLS_LANGUAGE = AMERICAN;
SELECT NEXT_DAY(SYSDATE, 'FRIDAY') FROM DUAL;
ALTER SESSION SET NLS_LANGUAGE = KOREAN;
SELECT NEXT_DAY(SYSDATE, '토') FROM DUAL;

/*
    *LAST_DAY
        : 해당 월의 마지막 날짜 구해서 반환
        [표현법]
        LAST_DAT(DATE)
*/
SELECT LAST_DAY(SYSDATE) FROM DUAL;

-- 사원테이블에서 사원명, 입사일, 입사달의 마지막 날짜, 입사달의 근무일수 조회
SELECT EMP_NAME, HIRE_DATE, 
        LAST_DAY(HIRE_DATE) AS "입사달 마지막 날짜",
        ( LAST_DAY(HIRE_DATE) - HIRE_DATE ) AS "입사달 근무일수"
FROM EMPLOYEE;

/*
    *EXTRACT
        : 특정 날짜로부터 연도 | 월 | 일 값(NUMBER)을 추출해서 반환하는 함수
        
        [표현법]
        EXTRACT(YEAR | MONTH | DAY FROM 특정 날짜)   
*/
-- 해당 사원의 사원명, 입사년도, 입사월, 입사일 조회
SELECT EMP_NAME, 
    EXTRACT(YEAR FROM HIRE_DATE) AS "입사년도",  
    EXTRACT(MONTH FROM HIRE_DATE) AS "입사월", 
    EXTRACT(DAY FROM HIRE_DATE) AS "입사일"
FROM EMPLOYEE
ORDER BY 입사년도, 입사월, 입사일;

--==============================================================================

-- <형변환 함수>
/*
    *TO_CHAR
        : 숫자 타입 또는 날짜 타입의 값을 문자 타입으로 변환시켜주는 함수
        
        [표현법]
        TO_CHAR(숫자 | 날짜, [포맷])
*/
-- 숫자 타입 => 문자 타입
SELECT TO_CHAR(1234) FROM DUAL;

SELECT TO_CHAR(1234, '99999') AS "NUMBER" FROM DUAL; 
-- 공간확보하겠다는 의미('999...' 9의 자릿 수 만큼 빈칸공백 생성), 오른쪽 정렬
SELECT TO_CHAR(1234, '00000') AS "NUMBER" FROM DUAL;
-- 0의 자릿수만큼 공간 확보, 오른쪽 정렬, 빈칸을 0으로 채움
SELECT TO_CHAR(1234, 'L99999') FROM DUAL;
-- 원화 표시가 붙어서 인출됨(현재 설정된 나라의 로컬 화폐단위 포함)
-- 달러는 그냥 '$99999' 표시하면 됨(달러는 기축통화이기 때문에)
SELECT TO_CHAR(1234, 'L99,999') FROM DUAL;
SELECT TO_CHAR(3500000, 'L9,999,999') FROM DUAL;

-- 사원들의 사원명, 월급, 연봉을 조회
SELECT EMP_NAME, 
    TRIM ( TO_CHAR(SALARY,'L9,999,999') )AS "월급", 
    TRIM ( TO_CHAR( ( SALARY * 12 ), 'L99,999,999') ) AS "연봉"
FROM EMPLOYEE;

-- 날짜타입 => 문자타입
SELECT SYSDATE FROM DUAL; -- 날짜타입 데이터
SELECT TO_CHAR(SYSDATE) FROM DUAL; -- 연월일만 나옴
SELECT TO_CHAR(SYSDATE, 'HH:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'AM HH:MI:SS') FROM DUAL;
-- AM, PM 중 어떤 것을 쓰던 현시점에 맞는 형식에 맞춰서 나옴
SELECT TO_CHAR(SYSDATE, 'HH24:MI:SS') FROM DUAL;
-- 24시간 기준으로 인출
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD DAY') FROM DUAL;
-- "DAY" : 요일까지 붙어서 인출
-- "DY" : 요일 이름만 인출
SELECT TO_CHAR(SYSDATE, 'MON, YYYY') FROM DUAL;

-- 사원명, 입사날짜(YYYY년 MM월 DD일) 조회
SELECT EMP_NAME,
        TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일"') 
FROM EMPLOYEE;
-- 큰따옴표로 스트링 표시를 해줘야 정해진 형식 내에서 추가적으로 문자를 인식할 수 있음


-- 년도와 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'YYYY'), 
        TO_CHAR(SYSDATE, 'YY'),
        TO_CHAR(SYSDATE, 'RRRR'),
        TO_CHAR(SYSDATE, 'RR')
FROM DUAL;
-- RR룰이 따로 존재함 -> 50년 이상 값이 + 100 -> EX) 1954
SELECT HIRE_DATE, TO_CHAR(HIRE_DATE, 'YYYY'), TO_CHAR(HIRE_DATE, 'RRRR') FROM EMPLOYEE;

-- 월과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'MM'), -- 이번달이 몇번째 월인지
        TO_CHAR(SYSDATE, 'MON'), -- 이번달이 몇월인지
        TO_CHAR(SYSDATE, 'MONTH') 
FROM DUAL;


-- 일과 관련된 포맷
SELECT TO_CHAR(SYSDATE, 'DDD'), -- 오늘이 이번년도에서 몇번째 일수
        TO_CHAR(SYSDATE, 'DD'), -- 오늘이 며칠인지
        TO_CHAR(SYSDATE, 'D') -- 몇번째 요일인지
FROM DUAL;

--=========================================================================

/*
    TO_DATE
        : 숫자타입 또는 문자타입을 날짜타입으로 변경하는 함수
    [표현법]
        TO_DATE(숫자 | 문자, [포맷])
*/

SELECT TO_DATE(20100101) FROM DUAL;
SELECT TO_DATE(650219) FROM DUAL;
-- 50년 이후로는 1900년대로 돌아감
-- 따라서 2000년대의 50년 이후를 보고 싶다면 년도의 천, 백의자리도 명시해야 함
SELECT TO_DATE(20650219) FROM DUAL;
SELECT TO_DATE(020505) FROM DUAL;
-- 숫자는 0으로 시작하면 안됨
SELECT TO_DATE('020505') FROM DUAL;
-- 시분초는 전부 000000
-- 시분초를 인출하기 위해서는 포맷을 정해줘야 함
SELECT TO_DATE('20240219 120800', 'YYYYMMDD HH24MISS') FROM DUAL;

--============================================================================

/*
    TO_NUMBER
        : 문자 타입의 데이터를 숫자 타입으로 변환시켜주는 함수
        
        [표현법]
        TO_NUMBER(문자, [포맷])
*/

SELECT TO_NUMBER('05123456789') FROM DUAL;

SELECT '100000' + '55000' FROM DUAL; -- 더하기일때는 자동으로 형변환해줌

SELECT '100000' + '55,000' FROM DUAL;  -- 콤마때문에 문자로 인식해서 안됨

SELECT  TO_NUMBER('100,000', '999,999') + TO_NUMBER('55,000', '99,999')
-- 형식을 명기해줘야 함
FROM DUAL;

--===============================================================================

-- <NULL 처리 함수>

/*
    *NVL
        :
        [표현법]
        NVL(컬럼, 해당 컬럼값이 NULL일 경우 보여줄 반환값)
        
    *NVL2
        [표현법]
        NVL2(컬럼, 반환값1, 반환값2)
        반환값 1: 해당 컬럼이 존재할 경우 보여줄 값
        반환값 2: 해당 컬럼이 NULL일 경우 보여줄 값
*/
-- 전사원의 이름, 보너스 포함 연봉(NULL 처리 후)
SELECT EMP_NAME,
       ( SALARY + (SALARY * NVL( BONUS, 0 )) ) * 12 AS "연봉"
FROM EMPLOYEE;  

SELECT EMP_NAME,
        BONUS,
        NVL2(BONUS, 'O', 'X')
FROM EMPLOYEE;

-- 사원들의 사원명과 부서배치여부(배정완료 또는 미배정 표시) 조회
SELECT EMP_NAME,
        NVL2(DEPT_CODE, '배정완료', '미배정')
FROM EMPLOYEE;

/*
    *NULLIF
        [표현법]
        NULLOF(비교대상1, 비교대상2)
        : 비교대상 일치시 NULL, 불일치시 비교대상 1반환

*/
SELECT NULLIF('123', '123') FROM DUAL;
SELECT NULLIF('123', '456') FROM DUAL;

--=============================================================================

-- <선택함수>

/*
    *DECODE
        [표현법]
        DECODE(비교대상(컬럼, 연산식, 함수식), 
                비교값1, 결과값1, 
                비교값2, 결과값2, ...)
                -- 비교값이 없는 결과값의 경우 디폴트값이 됨
        
        CF) 자바에서의 SWITCH문과 유사
*/
-- 사번, 사원명, 주민번호, 성별 조회
SELECT EMP_ID, EMP_NAME, EMP_NO,
        DECODE( SUBSTR(EMP_NO, 8, 1), '1', '남', '2', '여') AS "성별"
FROM EMPLOYEE;        

-- 직원명, 급여 조회. 다만, 각 직급 별로 인상해서 조회
-- J7 : 10% 인상
-- J6 : 10% 인상
-- J5 : 20% 인상
-- 그외 사원들은 급여를 5% 인상
SELECT EMP_NAME,
        SALARY AS "인상전",
        DECODE(JOB_CODE, 
                'J7', SALARY * 1.1, 
                'J6', SALARY * 1.1, 
                'J5', SALARY * 1.2, 
                      SALARY * 1.05)  AS "인상후"
FROM EMPLOYEE;

/*
    *CASE WHEN THEN
    
    CASE
        WHEN 조건식1 THEN 결과값1
        WHEN 조건식2 THEN 결과값2
        ...
        ELSE 결과값
    END    
*/
SELECT EMP_NAME, SALARY,
        CASE 
            WHEN SALARY >= 5000000 THEN '고급'
            WHEN SALARY >= 3500000 THEN '중급'
            ELSE '초급'
        END AS "월급 수준"
FROM EMPLOYEE;        

-----------------------------그룹함수-------------------------------------------

/* 
    1. SUM(숫자타입컬럼)
        : 해당 컬럼값들의 총 합계를 구해서 반환해주는 함수
*/
-- 근로자테이블의 전사원의 총 급여를 구해라
SELECT SUM(SALARY) -- 단일행함수
FROM EMPLOYEE;

-- 남자사원들의 총 급여합
SELECT SUM(SALARY)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) = '1';

--부서코드가 D5인 사원들의 총 연봉(급여 * 12)
SELECT SUM(SALARY * 12)
FROM EMPLOYEE
WHERE SUBSTR(DEPT_CODE, 1) = 'D5';

/*
    2. AVG(NUMBER)
        : 해당 컬럼값들의 평균값을 구해서 반환
*/
SELECT ROUND( AVG(SALARY) )
FROM EMPLOYEE;

/*
    3.MIN(모든타입가능)
        : 해당 컬럼값 중 가장 작은 값 구해서 반환
          (문자에서는 사전순으로 가장 먼저 등장하는 것이 가장 작은 값임)
*/
SELECT MIN(EMP_NAME), MIN(SALARY), MIN(HIRE_DATE)
FROM EMPLOYEE;

/*
    4. MAX(모든타입가능)
        : 해당 컬럼값 중 가장 큰 값을 반환
*/
SELECT MAX(EMP_NAME), MAX(SALARY), MAX(HIRE_DATE)
FROM EMPLOYEE;

/*
    5.COUNT( * | 컬럼 | DISTINCT 컬럼)
        : 해당 조건을 충족하는 행의 갯수를 반환
        COUNT(*)
            : 조회 결과에 모든 행의 갯수를 반환
        COUNT(컬럼)
            : 해당 컬럼값이 NULL이 아닌 행의 갯수를 반환
        COUNT(DISTINCT 컬럼)
            : 해당 컬럼값 중복 제거 후 행의 갯수 반환
*/
-- 전체 사원 수
SELECT COUNT(*) FROM EMPLOYEE;

-- 여자사원 수
SELECT COUNT(*)
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, 8, 1) IN ('2', '4') ;

-- 보너스를 받는 사원 수
SELECT COUNT(BONUS)
FROM EMPLOYEE;
-- 부서배치 받은 사원 수
SELECT COUNT(DEPT_CODE)
FROM EMPLOYEE;
-- 현재 사원들이 총 몇 개의 부서에 분포되어 있는지 조회
SELECT COUNT(DISTINCT DEPT_CODE) AS "부서 갯수"
FROM EMPLOYEE;