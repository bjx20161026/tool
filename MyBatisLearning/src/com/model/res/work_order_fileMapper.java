package com.model.res;

import com.model.work_order_file;
import com.model.work_order_fileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface work_order_fileMapper {
    long countByExample(work_order_fileExample example);

    int deleteByExample(work_order_fileExample example);

    int insert(work_order_file record);

    int insertSelective(work_order_file record);

    List<work_order_file> selectByExampleWithBLOBs(work_order_fileExample example);

    List<work_order_file> selectByExample(work_order_fileExample example);

    int updateByExampleSelective(@Param("record") work_order_file record, @Param("example") work_order_fileExample example);

    int updateByExampleWithBLOBs(@Param("record") work_order_file record, @Param("example") work_order_fileExample example);

    int updateByExample(@Param("record") work_order_file record, @Param("example") work_order_fileExample example);
}