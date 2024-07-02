/*
    <시퀀스SEQUENCE>
        : 자동으로 번호 발생시켜주는 역할을 하는 객체
          정수값을 순차적으로 일정값씩 증가시키면서 생성해줌
          
          EX) 회원번호, 사원번호, 게시글번호, ...
          
          [표현식]
          CREATE SEQUENCE 시퀀스명
          [START WITH 시작숫자] -- > 처음 발생할 시작값 지정(기본값 : 1)
          [INCREMENT BY 숫자] --> 몇씩 증가할지 지정(기본값 : 1)
          [MAXVALUE 숫자] --> 최대값 지정(기본값 : 매우 큰 수)
          [MINVALUE 숫자] --> 최소값 지정(기본값 : 1)
          (최소값은 순환을 위해 지정)
          [CYCLE | NOCYCLE] --> 값의 순환 여부 지정(기본값 : NOCYCLE)
          [NOCACHE | CACHE 바이트크기] --> 캐시메모리 할당(기본값 : CACHE 20)
          
            * 캐시메모리
                : 미리 발생할 값들을 생성해서 저장해두는 공간
                  매번 호출될 때마다 새로 번호 생성하는 것이 아니라
                  캐시메모리 공간에 미리 생성된 값들을 가져다 쓸 수 있음
                  (속도 향상)
                  
            테이블명 : TB_
            뷰명 : VW_
            시퀀스명 : SEQ_
            트리거 : TRG_
*/
CREATE SEQUENCE SEQ_TEST;

-- [참고] 현재 계정이 소유하고 있는 시퀀스들의 구조 보고자 할 때 USER_SEQUENCES
SELECT * FROM USER_SEQUENCES;
-- 즉, 시스템 테이블

CREATE SEQUENCE SEQ_EMPNO
START WITH 300
INCREMENT BY 5
MAXVALUE 310
NOCYCLE
NOCACHE;

/*
    2. 시퀀스 사용
        
        시퀀스명.CURRVAL
            : (CURRENT VALUE 약어)
               현재 시퀀스값(마지막으로 성공한 NEXTVALUE의 값)
        시퀀스명.NEXTVAL
            : 시퀀스값에 일정값을 증가시켜 발생한 값
              현재 시퀀스 값에서 INCREMENT BY 값만큼 증가된 값
*/

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.CURRVAL FROM DUAL;
-- 에러 발생
-- WHY? NEXTVAL 한 번도 수행하지 않았기에 CURRVAL 실행 불가
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;
SELECT SEQ_EMPNO.CURRVAL FROM DUAL;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;
SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;

SELECT * FROM USER_SEQUENCES;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;
-- 315가 나올 차례이지만 MAXVALUE 310 이기에 에러 발생

/*
    3. 시퀀스의 구조 변경
        
        [표현식]
        ALTER SEQUENCE 시퀀스명
         [INCREMENT BY 숫자] --> 몇씩 증가할지 지정(기본값 : 1)
         [MAXVALUE 숫자] --> 최대값 지정(기본값 : 매우 큰 수)
         [MINVALUE 숫자] --> 최소값 지정(기본값 : 1)
         [CYCLE | NOCYCLE] --> 값의 순환 여부 지정(기본값 : NOCYCLE)
         [NOCACHE | CACHE 바이트크기] --> 캐시메모리 할당(기본값 : CACHE 20)
        (START WITH : 이미 생성된 시퀀스이기에 시작 숫자 변경 불가)
*/

ALTER SEQUENCE SEQ_EMPNO
INCREMENT BY 10
MAXVALUE 400;

SELECT SEQ_EMPNO.NEXTVAL FROM DUAL;
-- 310 이후 400까지 10씩 증가하도록 수정했기에 320 반환

/*
    4. 시퀀스 삭제
        : DROP SEQUENCE 시퀀스명
*/
DROP SEQUENCE SEQ_EMPNO;

--------------------------------------------------------------------------------

CREATE SEQUENCE SEQ_EID
START WITH 400;

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
        VALUES (SEQ_EID.NEXTVAL, '김말똥', '111111-2222222', 'J6', SYSDATE);

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, EMP_NO, JOB_CODE, HIRE_DATE)
        VALUES (SEQ_EID.NEXTVAL, '김새똥', '111111-2222222', 'J6', SYSDATE);


SELECT * FROM EMPLOYEE;














