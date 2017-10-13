package com.dao.inasCollect;
/*性能采集共享记录表
 * 
 */

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dao.GetJdbcTemplate;

import util.common.DateTools;

public class DmCoBaTaskRecord {
	GetJdbcTemplate getJdbcTemplate;
	JdbcTemplate jdbcTemplate;
	String getCountDaysql;
	String getRecordsql;
	
	String db = "Ipmsp";
	
	public DmCoBaTaskRecord(){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		if(db.equals("Ipmsp")){
			jdbcTemplate = getJdbcTemplate.getIpmsp();
		}else{
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		}
	}
	
	public DmCoBaTaskRecord(String dbid){
		GetJdbcTemplate getJdbcTemplate = new GetJdbcTemplate();
		if(dbid.equals("Ipmsp")){
			jdbcTemplate = getJdbcTemplate.getIpmsp();
		}else{
		jdbcTemplate = getJdbcTemplate.getIpmsdm();
		}
	}
	
	public List<Map<String,Object>> GetCountDay(){
		getCountDaysql = getJdbcTemplate.getPrepareSql("DmCoBaTaskRecord.getCountDaysql");
		return jdbcTemplate.queryForList(getCountDaysql);
	}
	
	public List<Map<String,Object>> GetRecord(String protocol,String StartTime,String EndTime){
		getRecordsql = getJdbcTemplate.getPrepareSql("InasRecord");
		if(StartTime==null||StartTime.equals("")){
			StartTime = DateTools.getDayString(-1);
		}
		if(EndTime==null||EndTime.equals("")){
			EndTime = DateTools.getDayString(0);
		}
		return jdbcTemplate.queryForList(getRecordsql,"%"+protocol+"%",StartTime,EndTime);
	}
	
	public void insertInto(String id,String timetype,String timeinvokepoint,String timepoint,String enabled,String subid,String server_ip,String config,String type){
		jdbcTemplate.update("insert into dm_co_ba_cfg_task_mng (id,timetype,timeinvokepoint,timepoint,enabled,subid,server_ip) values (?,?,?,?,?,?,?)",id,timetype,timeinvokepoint,timepoint,enabled,subid,server_ip);
		jdbcTemplate.update("insert into dm_co_ba_cfg_clt (id,config,type) values (?,?,?)",id,config,type);		
	}
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
