/**
 * @describe 
 * @date 2016Äê9ÔÂ21ÈÕ
 * @author Msun
 * @version 1.0
 * @class com.msun.aop.proxy.statics.GreetingImpl.java
 */
package com.msun.aop.proxy.statics;

public class GreetingImpl implements Greeting{

	public void sayWelcome() {
		before();
		System.out.println("welcome...");
		after();
	}
	
	public void before(){
		System.out.println("before say welcome...");
	}
	
	public void after(){
		System.out.println("after say welcome...");
	}
}
