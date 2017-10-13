package com.dao.esbCollect;
/*
 * esb消息接收记录表
 */

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.GetJdbcTemplate;

import util.common.DateTools;

public class MetaDtMsgRecord {
	JdbcTemplate jdbcTemplate;
	String getMsgsql;
/**
 * select esbmsg by protocol or file name
 */
	public String GetMsg(String protocol,String day){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		getMsgsql = getJdbcTemplate.getPrepareSql("MetaDtMsgRecord.getMsgsql");
		return jdbcTemplate.queryForObject(getMsgsql,String.class,"%"+protocol+"%","%"+protocol+"%",day);
	}
	
	public List<Map<String,Object>> GetMsgList(String protocol,String startTime,String endTime){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		if(startTime==null||startTime.equals("")){
			startTime = DateTools.getDayString(-1);
		}
		if(endTime==null||endTime.equals("")){
			endTime = DateTools.getDayString(0);
		}
		getMsgsql = getJdbcTemplate.getPrepareSql("EsbCollectList");
		return jdbcTemplate.queryForList(getMsgsql,"%"+protocol+"%",endTime,startTime);
	}
	
	public List<Map<String,Object>> Temp(String startTime,String endTime){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		if(startTime==null||startTime.equals("")){
			startTime = DateTools.getDayString(-1);
		}
		if(endTime==null||endTime.equals("")){
			endTime = DateTools.getDayString(0);
		}
		getMsgsql = getJdbcTemplate.getPrepareSql("temp");
		return jdbcTemplate.queryForList(getMsgsql,endTime,startTime);
	}
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	public String getGetMsgsql() {
		return getMsgsql;
	}
	public void setGetMsgsql(String getMsgsql) {
		this.getMsgsql = getMsgsql;
	}
	
	public static void main(String[] args){
		MetaDtMsgRecord dealMetaDtMsgRecord = new MetaDtMsgRecord();
		String msg = dealMetaDtMsgRecord.GetMsg("DATA.PM.CMNETWANGLUOZHILIANG.NETVISTA_APP","1");
		System.out.println("msg--->>>"+msg);
	}
}
