package com.service.fastCollect;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.dao.mapping.FastCollectRecord;

public interface MyRecord {
	List<FastCollectRecord> GetRecord();
	public Map<String,Integer> CountActual(List<FastCollectRecord> records);
	public void setBegin(Date begin);
	public void setEnd(Date end);
	byte[] ExcelCreator(String taskType) throws Exception;
	public void CteatLocalFile() throws Exception;
}
