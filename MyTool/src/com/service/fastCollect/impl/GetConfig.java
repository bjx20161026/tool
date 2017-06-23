package com.service.fastCollect.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.mapping.dm_co_ba_cfg_clt;
import com.dao.mapping.dm_co_ba_cfg_cltExample;
import com.dao.mapping.dm_co_ba_cfg_cltExample.Criteria;
import com.dao.mapping.ipmsdm.dm_co_ba_cfg_cltMapper;
import com.service.model.FastCollectConfig;
@Service
public class GetConfig {
	@Autowired
	dm_co_ba_cfg_cltMapper configTableDao;
	public List<dm_co_ba_cfg_clt> GetConfigs(){
		dm_co_ba_cfg_cltExample cfg_cltExample = new dm_co_ba_cfg_cltExample();
	    Criteria  criteria = cfg_cltExample.createCriteria();
	    criteria.andTYPEEqualTo("0");
		return configTableDao.selectByExampleWithBLOBs(cfg_cltExample);
	}
	public Map<String,String> CountTheory(List<dm_co_ba_cfg_clt> configs){
		Map<String,String> map = new HashMap<String,String>();
		for(dm_co_ba_cfg_clt config:configs){
			FastCollectConfig fastCollectConfig = JSON.parseObject(config.getCONFIG(),FastCollectConfig.class);
			String str = fastCollectConfig.getMaxTimeSql();
			map.put(config.getID(),str.substring(str.length()-3));
		}
		return map;
	}
}
