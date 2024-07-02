package com.kh.spring.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


/*
 * Lombok
 * - 자동 코드 생성라이브러리
 * - 반복되는 getter, setter, toString등의 메소드를 자동으로 생성해줄 수 있는 라이브러리
 * 
 * lombok설치방법
 * 1. 라이브러리 다운로드 후 적용(pom.xml)
 * 2. 다운로드된 jar파일을 찾아서 설치(사용하는 ide에 설치)
 * 3. ide재실행
 * 
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Member {
	private String userId;
	private String userPwd;
	private String userName;
	private String email;
	private String gender;
	private String age;
	private String phone;
	private String address;
	private Date enrollDate;
	private Date modifyDate;
	private String status;
}
