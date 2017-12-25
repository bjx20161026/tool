package simple;

import java.util.HashMap;
import java.util.Map;

import org.bjx.helper.excel.Sheet;


public class Simple {
	public static void main(String[] args) {
		Map<String, Object> cellMap = new HashMap<String, Object>();
		System.out.println(cellMap.get("value") == null ? "" : cellMap.get("value").toString());
	}

}
