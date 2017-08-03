package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method; 
public class DongTai { 
    public static void main(String[] args) throws Exception { 
//        try { 
//            System.out.println("调用Math类的静态方法sin()"); 
//            Method sin = Math.class.getDeclaredMethod("sin", Double.TYPE); 
//            Double sin1 = (Double) sin.invoke(null, new Integer(1)); 
//            System.out.println("1的正弦值是：" + sin1); 
//            Method equals = test.class.getDeclaredMethod("test"); 
//            equals.invoke(new test()); 
//        } catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
    	;
    	Class.forName("test.test").newInstance();
        Class stu = Class.forName("test.test");  
        Constructor constructor = stu.getConstructor(String.class);  
        test test2 = (test) constructor.newInstance("lily");  
        Method equals = test.class.getDeclaredMethod("SayHello",String.class); 
        equals.invoke(test2,"world"); 
    } 
} 
