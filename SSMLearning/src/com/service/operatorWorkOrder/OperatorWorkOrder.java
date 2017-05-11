package com.service.operatorWorkOrder;

import java.util.List;

import com.dao.mapping.workOrder;
import com.dao.mapping.workOrderExample;

public interface OperatorWorkOrder {
    List<workOrder> selectByExample();

}
