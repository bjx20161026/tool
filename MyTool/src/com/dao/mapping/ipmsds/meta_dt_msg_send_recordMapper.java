package com.dao.mapping.ipmsds;

import com.dao.mapping.meta_dt_msg_send_record;
import com.dao.mapping.meta_dt_msg_send_recordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface meta_dt_msg_send_recordMapper {
    long countByExample(meta_dt_msg_send_recordExample example);

    int deleteByExample(meta_dt_msg_send_recordExample example);

    int insert(meta_dt_msg_send_record record);

    int insertSelective(meta_dt_msg_send_record record);

    List<meta_dt_msg_send_record> selectByExample(meta_dt_msg_send_recordExample example);

    int updateByExampleSelective(@Param("record") meta_dt_msg_send_record record, @Param("example") meta_dt_msg_send_recordExample example);

    int updateByExample(@Param("record") meta_dt_msg_send_record record, @Param("example") meta_dt_msg_send_recordExample example);
}