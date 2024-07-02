-- 1.
SELECT STUDENT_NO AS "학번", 
        STUDENT_NAME AS "이름",
        ENTRANCE_DATE AS "입학 년도"
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
WHERE DEPARTMENT_NAME = '영어영문학과'
ORDER BY ENTRANCE_DATE;

-- 2.
SELECT DISTINCT PROFESSOR_NAME, PROFESSOR_SSN
FROM TB_STUDENT
JOIN TB_PROFESSOR USING (DEPARTMENT_NO)
WHERE NOT PROFESSOR_NAME LIKE '___'
ORDER BY PROFESSOR_NAME;

-- 3.
SELECT DISTINCT PROFESSOR_NAME AS "교수이름", 
         FLOOR( MONTHS_BETWEEN(SYSDATE, TO_DATE('19' || SUBSTR( PROFESSOR_SSN, 1, 6) ) ) / 12)  AS "나이"
FROM TB_PROFESSOR
WHERE SUBSTR(PROFESSOR_SSN, 8, 1) = 1
ORDER BY 나이, 교수이름;

-- 4.
SELECT SUBSTR(PROFESSOR_NAME, 2) "이름"
FROM TB_PROFESSOR
WHERE NOT PROFESSOR_NAME LIKE '__';

SELECT TO_CHAR(TO_DATE(SUBSTR(STUDENT_SSN, 1, 6)), 'RRRR') FROM TB_STUDENT;

-- 5.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE TO_CHAR(ENTRANCE_DATE, 'RRRR') - TO_CHAR(TO_DATE(SUBSTR(STUDENT_SSN, 1, 6)), 'RRRR') > 19;

--6.
SELECT TO_CHAR(TO_DATE('20/12/25'), 'DAY') 
FROM DUAL;

--7.

--8.
SELECT STUDENT_NO, STUDENT_NAME
FROM TB_STUDENT
WHERE SUBSTR(STUDENT_NO, 1, 1) != 'A';

-- 9.
SELECT ROUND(SUM(POINT) / COUNT(POINT), 1) AS "평점"
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
WHERE STUDENT_NO = 'A517178';

-- 10.
SELECT DEPARTMENT_NO AS "학과번호" , COUNT(STUDENT_NO) "학생수(명)"
FROM TB_STUDENT
JOIN TB_DEPARTMENT USING (DEPARTMENT_NO)
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

-- 11.
SELECT COUNT(STUDENT_NO)
FROM TB_STUDENT
WHERE COACH_PROFESSOR_NO IS NULL;

-- 12.
SELECT SUBSTR(TERM_NO, 1, 4) AS "년도",
        ROUND(SUM(POINT) / COUNT(POINT), 1) AS "년도 별 평점"
FROM TB_GRADE
JOIN TB_STUDENT USING (STUDENT_NO)
GROUP BY STUDENT_NO, SUBSTR(TERM_NO, 1, 4)
HAVING STUDENT_NO = 'A112113'
ORDER BY 년도;

-- 13.
SELECT DEPARTMENT_NO AS "학과코드명", 
    COUNT(DECODE(ABSENCE_YN, 'Y', 1 ) ) AS "휴학생 수"
FROM TB_DEPARTMENT
JOIN TB_STUDENT USING (DEPARTMENT_NO)
GROUP BY DEPARTMENT_NO
ORDER BY DEPARTMENT_NO;

-- 14.

SELECT STUDENT_NAME , COUNT(*)
FROM TB_STUDENT
GROUP BY STUDENT_NAME
HAVING COUNT(*) > 1
ORDER BY 1;

SELECT A.STUDENT_NAME, COUNT(B.STUDENT_NAME) AS "동일인 수"
FROM TB_STUDENT A, TB_STUDENT B
WHERE A.STUDENT_NAME = B.STUDENT_NAME
AND A.STUDENT_NO != B.STUDENT_NO
GROUP BY A.STUDENT_NAME
ORDER BY 1;

-- 15.
SELECT SUBSTR(TERM_NO, 1, 4) 년도,
        SUBSTR(TERM_NO, 5, 2) 학기, 
        ROUND(AVG(POINT), 1) 평균
FROM TB_GRADE
WHERE STUDENT_NO = 'A112113'
GROUP BY ROLLUP(SUBSTR(TERM_NO, 1, 4), SUBSTR(TERM_NO, 5, 2))
ORDER BY 1; 








