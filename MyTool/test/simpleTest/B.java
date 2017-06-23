package simpleTest;

class A {
	A() {
		System.out.println("C");
	}

	static {
		System.out.println("A");
	}
	{
		System.out.println("E");
	}

	void printLine() {
		System.out.println("---------");
	}
}

public class B extends A {
	B() {
		System.out.println("D");
	}

	static {
		System.out.println("B");
	}
	{
		System.out.println("F");
	}

	public static void main(String[] args) {
		new B().printLine();
	}
}
