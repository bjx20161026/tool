package com.common;

import java.lang.reflect.Method;

public class MyThread extends Thread {
	public String ClassName;
	public String methodName;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Method method = Class.forName(ClassName).getDeclaredMethod(methodName);
			method.invoke(Class.forName(ClassName).newInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getClassName() {
		return ClassName;
	}

	public void setClassName(String className) {
		ClassName = className;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
