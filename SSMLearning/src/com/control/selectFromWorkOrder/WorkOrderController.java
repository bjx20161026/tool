package com.control.selectFromWorkOrder;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dao.mapping.workOrder;
import com.dao.mapping.res.workOrderMapper;
import com.service.operatorWorkOrder.OperatorWorkOrder;
import com.service.operatorWorkOrder.impl.OperatorWorkOrderImpl;

@Controller
@RequestMapping("/workOrder")
public class WorkOrderController {
	Logger logger = Logger.getLogger(WorkOrderController.class);
	@Autowired
	workOrderMapper WorkOrderMapper;
	@Autowired
	OperatorWorkOrder operatorWorkOrder;
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public @ResponseBody String Test(){
		return "这是一个测试的首页，会不断地进行丰富";	
	}
	
	@RequestMapping(value="/selectByPrimaryKey",method=RequestMethod.GET)
	public @ResponseBody workOrder selectByPrimaryKey(){
		return WorkOrderMapper.selectByPrimaryKey("112");
	}
	
	@RequestMapping(value="/selectByExample",method=RequestMethod.GET)
	public @ResponseBody List<workOrder> selectByExample(){
//		operatorWorkOrder = new OperatorWorkOrderImpl();
		return operatorWorkOrder.selectByExample();
	}
}
