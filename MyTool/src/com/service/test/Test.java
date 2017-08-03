package com.service.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.dao.mapping.EsbCollectMsgExample;
import com.dao.mapping.EsbCollectMsgExample.Criteria;
import com.dao.mapping.ipmsds.EsbCollectMsgMapper;



	@Service
	public class Test {
		@Autowired
		EsbCollectMsgMapper esbCollectMsgdao;
		public String GetMsg(String pro){
			EsbCollectMsgExample abc=new EsbCollectMsgExample();
			 Criteria  criteria = abc.createCriteria();
			 criteria.andIDIsNotNull();
			esbCollectMsgdao.selectByExampleWithBLOBs(abc);
//			return esbCollectMsgdao.selectMsg(pro);
			return null;
		}
		public static void main(String[] args){
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");  
//		  WebApplicationContext contextLoader = ContextLoader.getCurrentWebApplicationContext();
//	      context.start();  
			Test test = new Test();
			System.out.println(test.GetMsg("DATA.PM.NHM_CPU_MEM_KPI.GCP_APP"));

		}
}
