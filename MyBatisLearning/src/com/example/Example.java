package com.example;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Example {
	public static void main(String[] args){
		/*
		 * 获取sessionFactory
		 */
		String resource = "mybatis-config.xml";
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		/*
		 * 从SessionFactory获取session
		 */
		SqlSession session = sqlSessionFactory.openSession();
		try {
//		  Blog blog = (Blog) session.selectOne("org.mybatis.example.BlogMapper.selectBlog", 101);
		  int i = session.selectOne("com.myMap.exampleMap.ExampleMap.selectExample");
		  System.out.println(i);
		} finally {
		  session.close();
		}
	}
}
