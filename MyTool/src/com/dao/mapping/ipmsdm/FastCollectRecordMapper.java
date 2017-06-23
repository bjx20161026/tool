package com.dao.mapping.ipmsdm;

import com.dao.mapping.FastCollectRecord;
import com.dao.mapping.FastCollectRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FastCollectRecordMapper {
    long countByExample(FastCollectRecordExample example);

    int deleteByExample(FastCollectRecordExample example);

    int insert(FastCollectRecord record);

    int insertSelective(FastCollectRecord record);

    List<FastCollectRecord> selectByExampleWithBLOBs(FastCollectRecordExample example);

    List<FastCollectRecord> selectByExample(FastCollectRecordExample example);

    int updateByExampleSelective(@Param("record") FastCollectRecord record, @Param("example") FastCollectRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") FastCollectRecord record, @Param("example") FastCollectRecordExample example);

    int updateByExample(@Param("record") FastCollectRecord record, @Param("example") FastCollectRecordExample example);
}