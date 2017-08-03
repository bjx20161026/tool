package com.dao.mapping.ipmsds;

import com.dao.mapping.EsbCollectMsg;
import com.dao.mapping.EsbCollectMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EsbCollectMsgMapper {
    long countByExample(EsbCollectMsgExample example);

    int deleteByExample(EsbCollectMsgExample example);

    int insert(EsbCollectMsg record);

    int insertSelective(EsbCollectMsg record);

    List<EsbCollectMsg> selectByExampleWithBLOBs(EsbCollectMsgExample example);

    List<EsbCollectMsg> selectByExample(EsbCollectMsgExample example);
    

    int updateByExampleSelective(@Param("record") EsbCollectMsg record, @Param("example") EsbCollectMsgExample example);

    int updateByExampleWithBLOBs(@Param("record") EsbCollectMsg record, @Param("example") EsbCollectMsgExample example);

    int updateByExample(@Param("record") EsbCollectMsg record, @Param("example") EsbCollectMsgExample example);
}