package com.service.fastCollect.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapping.FastCollectRecord;
import com.dao.mapping.FastCollectRecordExample;
import com.dao.mapping.FastCollectRecordExample.Criteria;
import com.dao.mapping.dm_co_ba_cfg_task_mng;
import com.dao.mapping.ipmsdm.FastCollectRecordMapper;
import com.service.fastCollect.MyRecord;
import com.service.util.common.FileTools;
import com.service.util.common.MyDate;
import com.service.util.excle.CreatorFile;
@Service
public class MyRecordImpl implements MyRecord {
	@Autowired
	FastCollectRecordMapper fastCollectRecordMapper;
	@Autowired
	GetTask getTask;
	Date begin;
	Date end;
	String protocol;
	@Override
	public List<FastCollectRecord> GetRecord() {
		// TODO Auto-generated method stub
		FastCollectRecordExample fastCollectRecordExample = new FastCollectRecordExample();
		Criteria criteria = fastCollectRecordExample.createCriteria();
		criteria.andINSERT_TIMEBetween(begin, end);
		return fastCollectRecordMapper.selectByExample(fastCollectRecordExample);
	}
	@Override
	public Map<String,Integer> CountActual(List<FastCollectRecord> records){
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(FastCollectRecord record:records){
			 protocol=record.getPROTOCOL();
			 if(map.get(protocol)==null){
				 map.put(protocol, 1);
			 }else{
				 map.put(protocol, map.get(protocol)+1);
			 }
		}
		return map;
	}
	
	@Override
	public byte[] ExcelCreator(String taskType) throws Exception {
		// TODO Auto-generated method stub
		List<dm_co_ba_cfg_task_mng> tasks = getTask.GetTasks(taskType+"://%");
		Properties pro = FileTools.getProperties("MyRecord.properties");
		Map<String, String> CountTheory = new HashMap<String, String>();
		for(Object key:pro.keySet()){
			CountTheory.put(key.toString(), pro.get(key).toString());
		}
		MyDate myDate = new MyDate();
		setBegin(myDate.getDay(-1));
		setEnd(myDate.getDay(0));
		Map<String,Integer> countActual = CountActual(GetRecord());
		List<Map<String,String>> list =new ArrayList<Map<String,String>>();
		Map<String,String> esbMap;
		for(dm_co_ba_cfg_task_mng task:tasks){
			esbMap =new HashMap<String,String>();
			String proto = task.getSUBID().replace(taskType+"://", "");
			esbMap.put("name", task.getID());
			esbMap.put("protocol", proto);
			esbMap.put("CountTheory", CountTheory.get(proto));
			esbMap.put("CountActual",countActual.get(proto)==null?"":countActual.get(proto).toString());
			list.add(esbMap);
		}
		CreatorFile creatorFile = new CreatorFile();
		String[] heads = {"name","protocol","CountTheory","CountActual"};
		String[] head={"描述","规约","理论值","实际值"};
		byte[] bytes = creatorFile.createExcelFile(heads, head, list, "xlsx");
//		File file = new File("F:/test.csv");
//		FileOutputStream fo = new FileOutputStream(file);
//		fo.write(bytes);
//		fo.flush();
//		fo.close();
		return bytes;
	}
	@Override
	public void CteatLocalFile() throws Exception {
		// TODO Auto-generated method stub
		MyDate myDate = new MyDate();
		String dateString = myDate.getDayString(0);
		File esbFile = FileTools.CtreatFile("F:/FastCollectRecord/"+dateString+"/EsbuploadRecord.xlsx");
		FileOutputStream efo = new FileOutputStream(esbFile);
		efo.write(ExcelCreator("esb"));
		efo.flush();
		efo.close();
		File collectFile = FileTools.CtreatFile("F:/FastCollectRecord/"+dateString+"/collectRecord.xlsx");
		FileOutputStream cfo = new FileOutputStream(collectFile);
		cfo.write(ExcelCreator("collect"));
		cfo.flush();
		cfo.close();
	}
	
	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

}
