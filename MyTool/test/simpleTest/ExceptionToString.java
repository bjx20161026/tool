package simpleTest;

public class ExceptionToString {
	public static void main(String[] args){
		try{
		  Test tast = new Test();
		  tast.testa();
		}catch(Exception e){
//			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.toString()+"\n at:"+getStackMsg(e));
		}
	}
    private static String getStackMsg(Throwable e) {         
        StringBuffer sb = new StringBuffer();    
        StackTraceElement[] stackArray = e.getStackTrace();    
        for (int i = 0; i < stackArray.length; i++) {    
            StackTraceElement element = stackArray[i];    
            sb.append(element.toString() + "\n	");    
        }    
        return sb.toString();    
    }  
}
