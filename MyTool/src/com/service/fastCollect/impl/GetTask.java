package com.service.fastCollect.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapping.dm_co_ba_cfg_task_mng;
import com.dao.mapping.dm_co_ba_cfg_task_mngExample;
import com.dao.mapping.dm_co_ba_cfg_task_mngExample.Criteria;
import com.dao.mapping.ipmsdm.dm_co_ba_cfg_task_mngMapper;
@Service
public class GetTask {
	@Autowired
	dm_co_ba_cfg_task_mngMapper taskTableDao;
	public List<dm_co_ba_cfg_task_mng> GetTasks(String type){
		dm_co_ba_cfg_task_mngExample task_mngExample = new dm_co_ba_cfg_task_mngExample();
		Criteria Criteria=task_mngExample.createCriteria();
		short s = 1;
		Criteria.andENABLEDEqualTo(s);
		Criteria.andSUBIDLike(type);
		return taskTableDao.selectByExample(task_mngExample);		
	}
}
