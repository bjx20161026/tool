package com.dao.mapping.ipmsdm;

import com.dao.mapping.dm_co_ba_cfg_clt;
import com.dao.mapping.dm_co_ba_cfg_cltExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface dm_co_ba_cfg_cltMapper {
    long countByExample(dm_co_ba_cfg_cltExample example);

    int deleteByExample(dm_co_ba_cfg_cltExample example);

    int insert(dm_co_ba_cfg_clt record);

    int insertSelective(dm_co_ba_cfg_clt record);

    List<dm_co_ba_cfg_clt> selectByExampleWithBLOBs(dm_co_ba_cfg_cltExample example);

    List<dm_co_ba_cfg_clt> selectByExample(dm_co_ba_cfg_cltExample example);

    int updateByExampleSelective(@Param("record") dm_co_ba_cfg_clt record, @Param("example") dm_co_ba_cfg_cltExample example);

    int updateByExampleWithBLOBs(@Param("record") dm_co_ba_cfg_clt record, @Param("example") dm_co_ba_cfg_cltExample example);

    int updateByExample(@Param("record") dm_co_ba_cfg_clt record, @Param("example") dm_co_ba_cfg_cltExample example);
}