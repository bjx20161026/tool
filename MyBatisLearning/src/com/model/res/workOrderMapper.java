package com.model.res;

import com.model.workOrder;
import com.model.workOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface workOrderMapper {
    long countByExample(workOrderExample example);

    int deleteByExample(workOrderExample example);

    int deleteByPrimaryKey(String WORKJOB_ID);

    int insert(workOrder record);

    int insertSelective(workOrder record);

    List<workOrder> selectByExampleWithBLOBs(workOrderExample example);

    List<workOrder> selectByExample(workOrderExample example);

    workOrder selectByPrimaryKey(String WORKJOB_ID);

    int updateByExampleSelective(@Param("record") workOrder record, @Param("example") workOrderExample example);

    int updateByExampleWithBLOBs(@Param("record") workOrder record, @Param("example") workOrderExample example);

    int updateByExample(@Param("record") workOrder record, @Param("example") workOrderExample example);

    int updateByPrimaryKeySelective(workOrder record);

    int updateByPrimaryKeyWithBLOBs(workOrder record);

    int updateByPrimaryKey(workOrder record);
}