package test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 
public class RegxTest
{
    public static void main(String args[] ){
 
      // 按指定模式在字符串查找
      String line = "DATA.PM.LTE_DATASIMPLE_DAY.LWT_APP 1 0";
      String pattern = "(.*?) (\\d+) (\\d+)(.*)";
 
      // 创建 Pattern 对象
      Pattern r = Pattern.compile(pattern);
 
      // 现在创建 matcher 对象
      Matcher m = r.matcher(line);
      if (m.find( )) {
    	 System.out.println("Found count: " + m.groupCount() );
         System.out.println("Found value: " + m.group(0) );
         System.out.println("Found value: " + m.group(1) );
         System.out.println("Found value: " + m.group(2) );
         System.out.println("Found value: " + m.group(3) ); 
         System.out.println("Found value: " + m.group(4) ); 
      } else {
         System.out.println("NO MATCH");
      }
   }
}
