package com.dao.mapping.res;

import com.dao.mapping.workOrderFile;
import com.dao.mapping.workOrderFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface workOrderFileMapper {
    long countByExample(workOrderFileExample example);

    int deleteByExample(workOrderFileExample example);

    int insert(workOrderFile record);

    int insertSelective(workOrderFile record);

    List<workOrderFile> selectByExampleWithBLOBs(workOrderFileExample example);

    List<workOrderFile> selectByExample(workOrderFileExample example);

    int updateByExampleSelective(@Param("record") workOrderFile record, @Param("example") workOrderFileExample example);

    int updateByExampleWithBLOBs(@Param("record") workOrderFile record, @Param("example") workOrderFileExample example);

    int updateByExample(@Param("record") workOrderFile record, @Param("example") workOrderFileExample example);
}