package com.service.operatorWorkOrder;

import java.util.List;

import com.dao.mapping.workOrder;

public interface OperatorWorkOrder {
    List<workOrder> selectByExample();

}
