package com.dao.mapping.ipmsdm;

import com.dao.mapping.dm_co_ba_cfg_task_mng;
import com.dao.mapping.dm_co_ba_cfg_task_mngExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface dm_co_ba_cfg_task_mngMapper {
    long countByExample(dm_co_ba_cfg_task_mngExample example);

    int deleteByExample(dm_co_ba_cfg_task_mngExample example);

    int insert(dm_co_ba_cfg_task_mng record);

    int insertSelective(dm_co_ba_cfg_task_mng record);

    List<dm_co_ba_cfg_task_mng> selectByExample(dm_co_ba_cfg_task_mngExample example);

    int updateByExampleSelective(@Param("record") dm_co_ba_cfg_task_mng record, @Param("example") dm_co_ba_cfg_task_mngExample example);

    int updateByExample(@Param("record") dm_co_ba_cfg_task_mng record, @Param("example") dm_co_ba_cfg_task_mngExample example);
}