package com.dao.mapping.ipmsds;

import com.dao.mapping.META_PI_CFG_ESB_SHARE;
import com.dao.mapping.META_PI_CFG_ESB_SHAREExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface META_PI_CFG_ESB_SHAREMapper {
    long countByExample(META_PI_CFG_ESB_SHAREExample example);

    int deleteByExample(META_PI_CFG_ESB_SHAREExample example);

    int insert(META_PI_CFG_ESB_SHARE record);

    int insertSelective(META_PI_CFG_ESB_SHARE record);

    List<META_PI_CFG_ESB_SHARE> selectByExample(META_PI_CFG_ESB_SHAREExample example);

    int updateByExampleSelective(@Param("record") META_PI_CFG_ESB_SHARE record, @Param("example") META_PI_CFG_ESB_SHAREExample example);

    int updateByExample(@Param("record") META_PI_CFG_ESB_SHARE record, @Param("example") META_PI_CFG_ESB_SHAREExample example);
}