package com.service.sys.impl;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.service.sys.CreatTableSql;
import com.service.util.excle.ReadExcle;
@Service
public class CreatTableSqlImpl implements CreatTableSql {

	@Override
	public String GetSql(String filePath, String tableName) {
		String mainsql = "";
		String comments = "";
		String format = "create table %s\n(\n%s\n);\n%s";
		// TODO Auto-generated method stub
		try {
			List<Map<String,String>> list = (new ReadExcle()).readExcel(filePath);
			Map<String,String> map;
			for(int i = 1;i<list.size();i++){
				map = list.get(i);
				mainsql+=map.get("列名")+" "+map.get("类型")+(map.get("默认值")==null?"":(" default "+map.get("默认值")))+",\n";
				comments+=String.format("comment on column %s.%s is '%s';\n", tableName,map.get("列名"),map.get("描述"));
			}
			mainsql = mainsql.substring(0,mainsql.length()-2);
			comments = comments.substring(0,comments.length()-1);
			return String.format(format, tableName,mainsql,comments);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args){
		CreatTableSql creatTableSql = new CreatTableSqlImpl();
		String sql = creatTableSql.GetSql("F:/common/建表语句.xlsx", "IPMSDW.DW_FT_SE_AR_HBB_COUNT_M");
		System.out.println(sql);
	}

}
