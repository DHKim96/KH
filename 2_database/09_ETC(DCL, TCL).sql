/*
    <DCL>
        : 데이터 제어문(DATA CONTROL LANGUAGE)
          계정에게 시스템 권한 또는 객체 접근 권한을 부여하거나 회수하는 구문
          
          > 시스템 권한
            : DB 접근 권한, 객체 생성 권한
          > 객체 접근 권한
            : 특정 객체들을 조작할 수 있는 권한
        
        <계정 생성> ★
        CREATE USER 계정명 IDENTIFIED BY 비밀번호;
        GRANT 권한(RESOURCE, CONNECT) TO 계정;
*/
SELECT *
FROM ROLE_SYS_PRIVS;

/*
    <TCL>
        : 트랜잭션 제어문
        
        * 트랜잭션(TRANSACTION)
            : DB 의 논리적 연산 단위
              데이터의 변경사항(DML)등을 하나의 트랜잭션에 묶어서 처리
              DML문 한 개를 수행할 때 트랜잭션이 존재하지 않는다면 트랜잭션을 만들어서 묶음
                                    트랜잭션이 존재한다면 해당 트랜잭션에 묶어서 처리
              COMMIT 하기 전까지의 변경사항들을 하나의 트랜잭션에 담음
                - 트랜잭션 대상이 되는 SQL DML 명령문 : INSERT / UPDATE / DELETE
              트랜잭션 관련 명령어 : COMMIT / ROLLBACK / SAVEPOINT
                  COMMIT
                    : 트랜잭션 종료 처리 후 확정(DB 에 반영)
                      한 트랜잭션에 담겨있는 변경사항들을 실제 DB에 반영
                  ROLLBACK
                    : 트랜잭션 취소
                      한 트랜잭션에 담긴 변경사항들을 삭제(취소)한 후 마지막 COMMIT 시점으로 돌아감
                  SAVEPOINT 포인트명
                    : 임시 저장
                      현재 시점에 해당 포인트명으로 임시 저장
            
*/
DROP TABLE EMP_01;

CREATE TABLE EMP_01
AS (SELECT EMP_ID, EMP_NAME, DEPT_TITLE
    FROM EMPLOYEE
    JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID));

SELECT * FROM EMP_01;

-- 사번이 200번인 사람 삭제
DELETE FROM EMP_01
WHERE EMP_ID = 200;

DELETE FROM EMP_01
WHERE EMP_ID = 201;

ROLLBACK;

SELECT * FROM EMP_01;
-- 200, 201번 다시 복구됨

-------------------------------------------------------------------------------
-- 사번이 200, 201번인 사람 삭제
DELETE FROM EMP_01 WHERE EMP_ID = 200;
DELETE FROM EMP_01 WHERE EMP_ID = 201;

SELECT * FROM EMP_01;

COMMIT;

ROLLBACK;

SELECT * FROM EMP_01;
-- COMMIT으로 트랜잭션이 DB에 삭제가 반영됐기 때문에
-- ROLLBACK 으로도 200, 201번이 복구되지 않음

--------------------------------------------------------------------------------
-- 214, 216, 217 사번 사원 삭제
DELETE FROM EMP_01
WHERE EMP_ID IN (214, 216, 217);

SELECT * FROM EMP_01 ORDER BY EMP_ID;

SAVEPOINT SP;

INSERT INTO EMP_01
VALUES(801, '김말똥', '기술지원부');

DELETE FROM EMP_01 WHERE EMP_ID = 210;

SELECT * FROM EMP_01 ORDER BY EMP_ID;

ROLLBACK TO SP;
-- 세이브포인트로 롤백

COMMIT;

-------------------------------------------------------------------------------
DELETE FROM EMP_01
WHERE EMP_ID = 210;

-- DDL문 실행
CREATE TABLE TEST(
    TID NUMBER
);

ROLLBACK;

SELECT * FROM EMP_01;
-- DDL문이 실행되면 데이터베이스의 구조가 변경되기 때문에 변경 전에 자동적으로 COMMIT 해버림

/*
   ※ TCL 사용 시 유의할 점
    DDL문(CREATE, ALTER, DROP)을 수행하는 순간 기존 트랜잭션에 있던 변경사항들은
    무조건 COMMIT 됨(실제 DB 에 반영됨)
    즉, DDL문 수행 전 변경사항들이 있을 시 정확하게 픽스하고 DDL문 수행할 것
*/












