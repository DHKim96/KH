/*
    <SELECT>
    SELECT �������� ���� ���� FROM ���̺�;
    SELECT �÷�1, �÷�2, �÷�3 ... FROM ���̺�;
    
    ���� ��� ����� ������ ���� �ʹٸ�
    SELECT * FROM EMPLOYEE;
*/
-- ��� ����� ������ �����ʹٸ�
SELECT * FROM EMPLOYEE;

-- ��� ����� �̸�, �ֹε�Ϲ�ȣ, �� ��ȣ�� �˰� �ʹٸ�
SELECT EMP_NAME, EMP_NO, PHONE
FROM EMPLOYEE;

------------------------�ǽ�-----------------------------------
--JOB���̺��� ���޸� �÷��� ��ȸ
SELECT JOB_NAME FROM JOB;

--DEPARTMENT ���̺��� ��� �÷� ��ȸ
SELECT * FROM DEPARTMENT;

--DEPARTMENT ���̺��� �μ��ڵ�, �μ��� ��ȸ
SELECT DEPT_ID, DEPT_TITLE FROM DEPARTMENT;

--EMPLOYEE ���̺��� �����, �̸���, ��ȭ��ȣ, �Ի���, �޿� ��ȸ
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE, SALARY
FROM EMPLOYEE;

-- <�÷����� ���� ��� ����>
-- SELECT�� �÷��� �ۼ� �κп� ��� ���� ����
-- EX) EMPLOYEE ���̺��� �����, ����� ����(SALALY * 12)�� ��ȸ
SELECT EMP_NAME, SALARY * 12
FROM EMPLOYEE;

-- EMPLOYEE ���̺��� �����, �޿�, ���ʽ�, ����, ���ʽ� ���� ���� ��ȸ(�޿� + (�޿� * ���ʽ�)) * 12
SELECT EMP_NAME, SALARY, BONUS, SALARY * 12, ( SALARY + ( SALARY * BONUS ) ) * 12
FROM EMPLOYEE;
-- ��� ���� ���� �߿� NULL �����Ͱ� ���ԵǾ� �ִٸ� ������ ������� NULL

-- �����, �Ի���, �ٹ��ϼ��� ��ȸ
-- �� �ð� - �Ի��� = �ٹ��� �ð�
-- DATE - DATE => ������ ����(DAY)�� ǥ�ð� ��
-- �ڵ����� ��¥�� ǥ���ϴ� ��� : SYSDATE [��/��/��/��/��/��] 
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

SELECT SYSDATE FROM DUAL;
-- DUAL : ����Ŭ���� �������ִ� ���� ������ ���̺�(���� ������)

/*
    <�÷����� ��Ī �����ϱ�>
    ��� ������ �ϰ� �Ǹ� �÷����� ����������.
    �̶� �÷����� ��Ī�� �ο��ؼ� ����ϰ� ������ �� ����.
    [ǥ����]
    �÷��� ��Ī | �÷��� AS ��Ī | �÷��� "��Ī" | �÷��� AS "��Ī"
*/

SELECT EMP_NAME �����, SALARY AS �޿�, BONUS "���ʽ�", ( SALARY * 12 ) AS "����(��)",
        ( SALARY + ( SALARY * BONUS ) ) * 12 AS "�� �ҵ�"
FROM EMPLOYEE;

/*
    <���ͷ�>
    ���Ƿ� ������ ���ڿ�('')
    ��ȸ�� ���(RESULT SET)�� ��� �࿡ �ݺ������� ���
*/

-- EMPLOYEE ���̺��� ���, �����, �޿�
SELECT EMP_ID, EMP_NAME, SALARY, '��' AS "����"
FROM EMPLOYEE;

/*
    <���Ῥ���� : ||>
    ���� �÷������� ��ġ �ϳ��� �÷�ó�� ������ �� �ִ�.
*/

-- ���, �̸�, �޿��� �ϳ��� �÷����� ��ȸ
SELECT EMP_ID || EMP_NAME || SALARY || '��'
FROM EMPLOYEE;

-- EMPLOYEE ���̺����� ��� ����� ������ ��ȸ�Ѵ�.
-- ������ ���� ����� �������� ����϶�
-- XX�� ������ XX���Դϴ�.
SELECT EMP_NAME || '�� ������ ' || SALARY || '���Դϴ�.' AS "�޿�"
FROM EMPLOYEE;

/*
    <DISTINCT>
    �ߺ� ���� - �÷��� ǥ�õ� ������ �� �� ���� ��ȸ�ϰ��� �� �� ���
*/

-- EMPLOYEE ���� �ڵ� ��ȸ(�ߺ� ����)
SELECT DISTINCT JOB_CODE
FROM EMPLOYEE;

-- EMPLOYEE �μ� �ڵ� ��ȸ(�ߺ� ����)
SELECT DISTINCT DEPT_CODE
FROM EMPLOYEE;

-- SELECT DISTINCT JOB_CODE, DISTINCT DEPT_CODE
-- FROM EMPLOYEE;
-- ��ó�� �ۼ��ϸ� ���� �߻�. DISTINCT�� �� ���� ��� ����

SELECT DISTINCT JOB_CODE, DEPT_CODE
-- ��ó�� ���� (JOB_CODE, DEPT_CODE) ������ ��� �ߺ��� ������ ���� ������
FROM EMPLOYEE;

================================================================================

/*
    <WHERE��>
    ��ȸ�ϰ��� �ϴ� ���̺��κ��� Ư�� ���ǿ� �����ϴ� �����͸��� ��ȸ�� �� ���
    ���ǽĿ����� �پ��� ������ ��� ����
    [ǥ����]
    SELECT �÷�, �÷�, �÷� ����
    FROM ���̺�
    WHERE ����;
    
    >> �� ������ <<
    ��� �� : >, <, >= , <=
    ���� �� : (���� ����)=, (���� �ٸ�)!=, ^=, <>
*/

-- EMPLOYEE ���� �μ� �ڵ尡 'D9'�� ����鸸 ��ȸ(��� �÷�)
SELECT *
FROM EMPLOYEE
WHERE DEPT_CODE = 'D9';

-- EMPLOYEE ���� �μ� �ڵ尡 'D1'�� ������� �����, �޿�, �μ��ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE = 'D1';

-- EMPLOYEE ���� �μ� �ڵ尡 'D1'�� �ƴ� ������� �����, �޿�, �μ� �ڵ� ��ȸ
SELECT EMP_NAME, SALARY, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D1';

-- ������ 400���� �̻��� ������� �����, �μ� �ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;

-----------------------------------�ǽ�-----------------------------------------

-- 1. �޿��� 300���� �̻��� ������� �����, �޿�, �Ի���, ����(��Ī : ����), ��ȸ
SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 AS "����"
FROM EMPLOYEE
WHERE SALARY >= 3000000;

-- 2. ������ 5õ���� �̻��� ������� �����, �޿�, ����(��Ī : ����), �μ��ڵ� ��ȸ 
SELECT EMP_NAME, SALARY, HIRE_DATE, SALARY * 12 AS "����", DEPT_CODE
FROM EMPLOYEE
WHERE SALARY * 12 >= 50000000;
-- WHERE ���� >= 5000000; : ���� �߻�
-- ���� : ���� ���� FROM�� -> WHERE�� -> SELECT�� �̱� ����
-- ��Ī�� SELECT������ �����Ǳ⿡ �� ������ ����Ǵ� WHERE�������� ��Ī ��� �Ұ���.

-- 3. �����ڵ尡 'J3'�� �ƴ� ������� ���, �����, �����ڵ�, ��翩�� ��ȸ
SELECT EMP_ID, EMP_NAME, JOB_CODE, ENT_YN
FROM EMPLOYEE
WHERE JOB_CODE != 'J3';

-- 4. �޿��� 350���� �̻� 600���� ������ ��� ����� �����, ���, �޿� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
WHERE SALARY BETWEEN 3500000 AND 6000000;

/*
    <AND, OR ������>
    ������ ���� �� ������ �� ���
    [ǥ����]
    ����A AND ����B -> ����A �� ����B ��� �����ϴ� ���� ������
    ����A OR ����B -> ����A �� ����B �� �ϳ��� �����ϴ� ���� ������
    
    <BETWEEN AND>
    ���ǽĿ� ����ϴ� ����
    <= >= ������ ���� ������ ������ �� ����ϴ� ������(�̻�, ���ϸ� ����)
    [ǥ����]
    �񱳴�� �÷� BETWEEN ���Ѱ� AND ���Ѱ�
*/

-- �޿��� 350���� �̻� 600���� ������ ��� ����� �����, ���, �޿� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY >= 3500000 AND SALARY <= 6000000;
WHERE SALARY BETWEEN 3500000 AND 6000000;

-- �޿��� 350���� �̸� 600���� �ʰ��� ��� ����� ����� ��� �޿� ��ȸ
SELECT EMP_NAME, EMP_ID, SALARY
FROM EMPLOYEE
--WHERE SALARY < 3500000 OR SALARY > 6000000;
--WHERE NOT SALARY BETWEEN 3500000 AND 6000000;
WHERE SALARY NOT BETWEEN 3500000 AND 6000000;

-- �������������� NO
--      �÷��� �� �Ǵ� BETWEEN �տ� ���� ����

-- �Ի����� '90/01/01' ~ '01/01/01' ��� ��ü ��ȸ
SELECT *
FROM EMPLOYEE
-- WHERE HIRE_DATE >= '90/01/01' AND HIRE_DATE <= '01/01/01';
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';
-- DATE Ÿ�Ե� �� ���� ����

--================================================================================

/*
    <LIKE>
    ���ϰ��� �ϴ� �÷����� ����ڰ� ������ Ư�� ���Ͽ� ������ ��� ��ȸ CF)JAVA�� SWITCH��
    
    [ǥ����]
    ���� ��� �÷� LIKE 'Ư�� ����';
    
    Ư�� ������ ������ �� ���ϵ�ī���� Ư�������� ���ǵǾ�����
       1. '%' : ���Թ��� �˻�(0���� �̻� ���� ��ȸ)
            
            EX) �񱳴���÷� LIKE '����%'
                    : �� ��� �÷��� �� �ش� ���ڷ� �����ϴ� ���鸸 ��ȸ
                �񱳴���÷� LIKE '%����'
                    : �� ��� �÷��� �� �ش� ���ڷ� ������ ���鸸 ��ȸ
                �񱳴���÷� LIKE '%����%' 
                    : �� ��� �÷��� �� �ش� ���ڰ� ���Ե� �� ��ȸ(Ű���� �˻�)
            
            => '%' Ȱ�� ����
            -- ����� �߿� ���� ������ ������� �����, �޿�, �Ի��� ��ȸ
            SELECT EMP_NAME, SALARY, HIRE_DATE
            FROM EMPLOYEE
            WHERE EMP_NAME LIKE '��%';
            
            -- ����� �߿� �̸��� '��' �� ���Ե� ����� �����, ��ȭ��ȣ ����� ��ȸ
            SELECT EMP_NAME, PHONE
            FROM EMPLOYEE
            WHERE EMP_NAME LIKE '%��%';

       2. '_' : 1���ڸ� ��ü�ϴ� �˻�(_������ ���� ���� �� ��ü ����)
           
            EX) �񱳴���÷� LIKE '_����'
                    : �� ��� �÷��� ���� �տ� �ƹ� ���ڳ� N ���ڰ� �ִ� ���� ��ȸ
                �񱳴���÷� LIKE '����_'
                    : �� ��� �÷��� ���� �ڿ� ~
                �񱳴���÷� LIKE '_����_'
                    : �� ��� �÷��� ���� �յڿ� ~
                    
            => '_' Ȱ�� ����        
             -- ����� �߿��� �̸��� �߰� ���ڰ� '��'�� ����� �����, ��ȭ��ȣ ��� ��ȸ
            SELECT EMP_NAME, PHONE
            FROM EMPLOYEE
            WHERE EMP_NAME LIKE '_��_';
            
        => '%' '_' Ȱ���� ����
        -- ��ȭ��ȣ�� 3��° �ڸ��� 1�� ������� ���, �����, ��ȭ��ȣ ��ȸ
        SELECT EMP_ID, EMP_NAME, PHONE
        FROM EMPLOYEE
        WHERE PHONE LIKE '__1%';
*/
-- �̸��� �ּ� �� _�ձ��ڰ� 3������ ������� ���, �̸�, �̸��� ��ȸ
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
-- WHERE EMAIL LIKE '____%';
    -- ���ϵ�ī�� ���� '_' ������ ��������� ���� ����
    -- ���ϵ�ī�� ���ڿ� �Ϲ� ������ ������ �ʿ���
-- => ������ ������ ����ϰ� ���� ���ϵ�ī�� ���� �տ� ������ Ż�⹮�ڸ� ������ Ż�������� ��
-- ESCAPE OPTION
-- WHERE EMAIL LIKE '___\_%'; : \�� Ż�� �������� �˷���� ��
WHERE EMAIL LIKE '___\_%' ESCAPE '\';
-- ESCAPE OPTION �� �����ϴ� ���ڴ� �ƹ� ���ڳ� ������� BUT ��ü������ �������� ���

-- �� ������� �ƴ� �� ���� ������� ��ȸ�ϰ� �ʹ� �÷� ����
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE NOT EMAIL LIKE '___\_%' ESCAPE '\';

--=======================================�ǽ�===========================
-- 1. �̸��� '��'���� ������ ������� �����, �Ի��� ��ȸ
SELECT EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��';

-- 2. ��ȭ��ȣ ó�� 3�ڸ��� 010�� �ƴ� ������� �����, ��ȭ��ȣ ��ȸ
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE NOT PHONE LIKE '010%';

-- 3. �̸��� '��'�� ���ԵǾ��ְ� �޿��� 240���� �̻��� ������� �����, �޿� ��ȸ
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%��%' AND SALARY >= 2400000;

-- 4. �μ����̺����� �ؿܿ������� �μ����� �μ��ڵ�, �μ��� ��ȸ
SELECT DEPT_ID, DEPT_TITLE
FROM DEPARTMENT
WHERE DEPT_TITLE LIKE '�ؿܿ���%';
-- WHERE DEPT_TITLE LIKE '�ؿܿ���_��'; �� ����

/*
    <IN>
    WHERE������ �� ��� �÷����� ����ڰ� ������ ��� �� ���� ���� �˻�
    
    [ǥ����]
    �񱳴���÷� IN ('��1', '��2', ...)
*/

-- �μ��ڵ尡 D6 �̰ų� D8 �̰ų� D5 �� �μ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
-- WHERE DEPT_CODE = 'D6' OR DEPT_CODE = 'D8' OR DEPT_CODE = 'D5';
WHERE DEPT_CODE IN ('D6', 'D8', 'D5');

--=================================================================

/*
    <IS NULL & IS NOT NULL>
    �÷����� NULL�� ���� ��� NULL���� ���ϱ� ���ؼ� ����ϴ� ������
*/

-- ���ʽ��� ���� ���� ������� ���, �̸�, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE BONUS IS NULL;
-- ���ʽ��� �޴� ��� WHERE BONUS IS NOT NULL;

-- ����� ���� ������� �����, ��� ���, �μ��ڵ� ��ȸ
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL;

-- �μ���ġ�� ���� ���� �ʾҰ� ���ʽ��� ���� ������� �̸�, ���ʽ�, �μ��ڵ带 ��ȸ
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-- =========================================================================
/*
    <������ �켱����>
    1. ��� ������
    2. ���� ������
    3. �� ������
    4. IS(NOT)NULL / LIKE / IN
    5. BETWEEN A AND B
    6. NOT
    7. AND
    8. OR
*/

-- �����ڵ尡 J7 �̰ų� J2 �� ����� �߿� �޿��� 200���� �̻��� ������� ��� �÷� ��ȸ
SELECT *
FROM EMPLOYEE
-- WHERE  ( JOB_CODE = 'J7' OR JOB_CODE = 'J2' ) AND SALARY >= 2000000;
WHERE (JOB_CODE IN ('J7', 'J2') ) AND SALARY >= 2000000;

--================================�ǽ�=============================================
-- 1. ����� ���� �μ���ġ�� ���� ���� ������� �����, ���, �μ��ڵ� ��ȸ
SELECT EMP_NAME, EMP_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL AND DEPT_CODE IS NULL;

-- 2. ����(���ʽ� ������)�� 3õ���� �̻��̰� ���ʽ��� ���� ���� ������� ���, �����, �޿�, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
WHERE ( SALARY * 12 ) >= 30000000 AND BONUS IS NULL;

-- 3. �Ի����� '95/01/01' �̻��̰� �μ� ��ġ�� ���� ���� ������� ���, �����, �Ի���, �μ��ڵ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, DEPT_CODE
FROM EMPLOYEE
WHERE  HIRE_DATE >= '95/01/01'  AND DEPT_CODE IS NULL ;

-- 4. �޿��� 200���� �̻��̰� 500���� ������ ��� �� �Ի����� '01/01/01' �̻��̰� ���ʽ��� ���� ���� �������
���, �����, �޿�, �Ի���, ���ʽ� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, HIRE_DATE, BONUS
FROM EMPLOYEE
WHERE ( SALARY BETWEEN 2000000 AND 5000000 ) AND ( HIRE_DATE >= '01/01/01') AND BONUS IS NULL;

-- 5. ���ʽ��� ���� ������ NULL �� �ƴϰ� �̸��� '��'�� ���Ե� ������� ���, �����, �޿�, ���ʽ� ���� ���� ��ȸ
SELECT EMP_ID, EMP_NAME, SALARY, ( SALARY + ( SALARY * BONUS ) ) * 12
FROM EMPLOYEE
WHERE   ( ( SALARY + ( SALARY * BONUS ) ) * 12 ) IS NOT NULL  AND EMP_NAME LIKE '%��%';


