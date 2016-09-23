/**
 * @describe 
 * @date 2016年9月9日
 * @author Msun
 * @version 1.0
 * @class com.msun.designpattern.singleton.Student.java
 */
package com.msun.designpattern.singleton;

public class SingletonStudent {
	
	private static SingletonStudent singletonStudent = new SingletonStudent();
	
	private SingletonStudent(){
		System.out.println("this is singleton pattern.");
	}
	
	public static SingletonStudent getSingletonStudent(){
		return singletonStudent;
	}
}
