/**
 * @describe 
 * @date 2016��9��21��
 * @author Msun
 * @version 1.0
 * @class com.msun.aop.proxy.dynamic.GreetingDynamicMain.java
 */
package com.msun.aop.proxy.dynamic;

public class GreetingDynamicMain {
	
	public static void main(String[] args){
		GreetingDynamic greet = new GreetingProxy(new GreetingDynamicImpl()).getProxy();
		greet.sayWelcome();
	}
}
