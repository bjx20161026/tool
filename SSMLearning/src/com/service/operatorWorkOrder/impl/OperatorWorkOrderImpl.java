package com.service.operatorWorkOrder.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.mapping.workOrder;
import com.dao.mapping.workOrderExample;
import com.dao.mapping.workOrderExample.Criteria;
import com.dao.mapping.res.workOrderMapper;
import com.service.operatorWorkOrder.OperatorWorkOrder;

@Service
public class OperatorWorkOrderImpl implements OperatorWorkOrder{

	@Autowired
	workOrderMapper WorkOrderMapper;
	@Override
	public List<workOrder> selectByExample() {
		// TODO Auto-generated method stub
		workOrderExample WorkOrderExample = new workOrderExample();
		Criteria criteria = WorkOrderExample.createCriteria();
		criteria.andNASIDNotLike("0156.0400.210.00.460");
		WorkOrderExample.or(criteria);
		WorkOrderMapper.selectByPrimaryKey("112");
		return WorkOrderMapper.selectByExample(WorkOrderExample);
	}
}
