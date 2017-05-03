package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EncodeTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		  File file = new File("F:/HB_NRTM_KFmonth_SH_201701.csv");
          InputStream in= new java.io.FileInputStream(file);
          byte[] b = new byte[3];
          in.read(b);
          in.close();
          System.out.println(b[0]);
          System.out.println(b[1]);
          System.out.println(b[2]);
          if (b[0] == -17 && b[1] == -69 && b[2] == -65)
              System.out.println(file.getName() + "：编码为UTF-8");
          else
              System.out.println(file.getName() + "：可能是GBK，也可能是其他编码");
	}

}
