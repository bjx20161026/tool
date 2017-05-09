package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.model.MyResultMap;
import com.model.workOrder;

public class Example {
	public static void main(String[] args){
		long start=System.currentTimeMillis();
		Logger logger = Logger.getLogger(Example.class);
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
			/*
			 * 暂时使用出错，待研究		
			  BlogMapper mapper = session.getMapper(BlogMapper.class);
			  Blog blog = mapper.selectBlog(101);
			   */
		
		  int i = session.selectOne("com.myMap.exampleMap.ExampleMap.selectExample");
		  System.out.println(i);
		  workOrder workOrder = (workOrder)session.selectOne("com.myMap.exampleMap.ExampleMap.selectWorkOrder", "112");
//		  System.out.println(workOrder.toString());
//		  logger.info(workOrder.toString());
		  List list = session.selectList("com.myMap.exampleMap.ExampleMap.selectMap");
		  List<Map<String,Object>> map = (List<Map<String,Object>>)list;
//		  Map map = (HashMap)list.get(1);
		  long Jstart=System.currentTimeMillis();
		  System.out.println(JSON.toJSON(map));
		  long Jend=System.currentTimeMillis();
		  System.out.println("json转换共用时："+(Jend-Jstart)+"ms");
		  long end=System.currentTimeMillis();
		  logger.info("本次操作耗时:"+(end-start)+"ms");
		} finally {
		  session.close();
		}
	}
}
