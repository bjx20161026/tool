package com.service.loadDataCheck;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.dao.esbCollect.MetaDtTaskRecord;
import com.dao.esbCollect.MetaPiTableDetail;

import util.common.RegularTool;

public class LoadDataCheck {
	public boolean isNumber = false;
	public boolean isDate = false;
	public boolean charLength = false;

	public List<String> dateType = new ArrayList<String>();
	public List<String> formate = new ArrayList<String>();
	public List<String> colunmName = new ArrayList<String>();
	public String mytemp = "";

	public String Check(String protocol) throws Exception {
		Map<String, Object> map;
		MetaDtTaskRecord metaDtTaskRecord = new MetaDtTaskRecord();
		map = metaDtTaskRecord.GetDateFileName(protocol);
		String tableName = (String) map.get("TABLE_NAME");
		List<Map<String, Object>> list;

		MetaPiTableDetail metaPiTableDetail = new MetaPiTableDetail();
		list = metaPiTableDetail.getDetail(tableName);
		Collections.sort(list, new Comparator<Map<String, Object>>() {
			@Override
			public int compare(Map<String, Object> o1, Map<String, Object> o2) {
				// TODO Auto-generated method stub
				if (Integer.parseInt(o1.get("COLUMN_ORDER").toString()) > Integer
						.parseInt(o2.get("COLUMN_ORDER").toString())) {
					return 1;
				}
				if (Integer.parseInt(o1.get("COLUMN_ORDER").toString()) == Integer
						.parseInt(o2.get("COLUMN_ORDER").toString())) {
					return 0;
				}
				return -1;
			}
		});
		initColumn(list);
		LoadFile loadFile = new LoadFile();
		BufferedReader br = new BufferedReader(
				new InputStreamReader(loadFile.getDatStream((String) map.get("FILE_NAME")), "gbk"));
		String temp = "";
		String[] temps;
		int i = 0;
		while ((temp = br.readLine()) != null) {
			i++;
			temps = temp.split("\\|\\|");
			if (isNumber) {
				if ((mytemp = checkIsNumber(temps)) != null) {
					return "第" + i + "行 " + mytemp;
				}
			}
		}
		return "未发现错误！";
	}

	public String checkIsNumber(String[] temps) {
		for (int i = 0; i < temps.length; i++) {
			if (typeIsNumber(dateType.get(i))) {
				mytemp = temps[i];
				if (formate.get(i) != null) {
					mytemp = Formate.RegexFormate(temps[i], formate.get(i));
				}
				if (!RegularTool.IsNumber(temps[i])) {
					return String.format("列名：%s，列数：%d 内容--->>>处理后：%s，处理前：%s 为非数字！", colunmName.get(i), i, mytemp,
							temps[i]);
				}
			}
		}
		return null;
	}

	public boolean typeIsNumber(String str) {
		if (RegularTool.isMatcher(str, "NUM.*")) {
			return true;
		}
		if (str.equals("FLOAT") || str.equals("INT") || str.equals("INTEGER") || str.equals("BIGINT")
				|| str.equals("DOUBLE")) {
			return true;
		}
		return false;
	}

	public void initColumn(List<Map<String, Object>> list) {
		Map<String, Object> map;
		for (int i = 0; i < list.size(); i++) {
			map = list.get(i);
			dateType.add(((String) map.get("COLUMN_DATATYPE")).toUpperCase());
			formate.add((String) map.get("FORMAT"));
			colunmName.add((String) map.get("COLUMN_NAME"));
			System.out.println((String) map.get("COLUMN_NAME"));
		}
	}

	public boolean isNumber() {
		return isNumber;
	}

	public void setNumber(boolean isNumber) {
		this.isNumber = isNumber;
	}

	public boolean isDate() {
		return isDate;
	}

	public void setDate(boolean isDate) {
		this.isDate = isDate;
	}

	public boolean isCharLength() {
		return charLength;
	}

	public void setCharLength(boolean charLength) {
		this.charLength = charLength;
	}

	public static void main(String[] args) throws Exception {
		LoadDataCheck loadDataCheck = new LoadDataCheck();
		loadDataCheck.setNumber(true);
		String str = loadDataCheck
				.Check("DATA.PM.Video_Result.ACT_APP");
		System.out.println("处理结果是--->>>" + str);
	}
}
