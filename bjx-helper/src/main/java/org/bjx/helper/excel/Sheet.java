package org.bjx.helper.excel;

import java.util.List;

import java.util.Map;

public class Sheet {
	
	private String sheetName;
	private String headName;
	private List<Map<String,Object>> datas;
	private Map<Integer,Map<String,Object>> columnStyle;
	private List<Map<String,Integer>> mergeCell;
	
	public List<Map<String, Integer>> getMergeCell() {
		return mergeCell;
	}
	public void setMergeCell(List<Map<String, Integer>> mergeCell) {
		this.mergeCell = mergeCell;
	}
	public Map<Integer, Map<String, Object>> getColumnStyle() {
		return columnStyle;
	}
	public void setColumnStyle(Map<Integer, Map<String, Object>> columnStyle) {
		this.columnStyle = columnStyle;
	}
	public String getSheetName() {
		return sheetName;
	}
	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}
	public String getHeadName() {
		return headName;
	}
	public void setHeadName(String headName) {
		this.headName = headName;
	}
	public List<Map<String, Object>> getDatas() {
		return datas;
	}
	public void setDatas(List<Map<String, Object>> datas) {
		this.datas = datas;
	}
	

}
