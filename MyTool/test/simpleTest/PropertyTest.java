package simpleTest;

import java.util.HashMap;
import java.util.Map;

import com.service.util.common.FileTools;

public class PropertyTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
//	  Properties pro = FileTools.getProperties("users.properties");
//	  pro.setProperty("cuishuq", "sdadf");
//		InputStream fis = new FileInputStream("config/EsbUpload.properties");
//	        OutputStream fos = new FileOutputStream("config/users.properties");
		Map<String,String> map = new HashMap<String,String>();
		map.put("1234bjx", "bjx1234");
		map.put("jack","235@a");
		FileTools.setProperties(map, "users.properties");
	}

}
