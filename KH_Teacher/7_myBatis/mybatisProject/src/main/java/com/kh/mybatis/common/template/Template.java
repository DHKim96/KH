package com.kh.mybatis.common.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	//마이바티스
	public static SqlSession getSqlSession() {
		//mybatis-config.xml => 읽어드리기
		//해당 db와 접속된 SqlSession객체 생성해서 반환하기
		
		SqlSession sqlSession = null;
		
		//SqlSession생성하기 위해서는  => SqlSessionFactory객체 필요
		//SqlSessionFactory생성하기 위해서는 => SqlSessionFactoryBuilder필요
		
		String resource = "/mybatis-config.xml";
		
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
//			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//			sqlSession = sqlSessionFactory.openSession(false); // boolean autoCommit => 자동커밋여부(true면 자동커밋 false면 수동커밋)
			
			sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}

}
