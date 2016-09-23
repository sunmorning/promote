/**
 * @describe 
 * @date 2016Äê9ÔÂ21ÈÕ
 * @author Msun
 * @version 1.0
 * @class com.msun.aop.proxy.statics.GreetingUse.java
 */
package com.msun.aop.proxy.statics;

public class GreetingUse {
	
	public static void main(String[] args){
		Greeting greet = new GreetingImpl();
		greet.sayWelcome();
	}
}
