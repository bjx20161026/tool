package simpleTest;

public class C {
	C(){
		System.out.println("C");
	}
	static {
		System.out.println("A");
	}
	{
	    System.out.println("E");
	}
    void printLine(){
    	System.out.println("---------");
    }
}
