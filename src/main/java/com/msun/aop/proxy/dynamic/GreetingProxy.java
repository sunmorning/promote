/**
 * @describe 
 * @date 2016Äê9ÔÂ21ÈÕ
 * @author Msun
 * @version 1.0
 * @class com.msun.aop.proxy.dynamic.GreetingProxy.java
 */
package com.msun.aop.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GreetingProxy implements InvocationHandler{
	
	private Object target;
	
	public GreetingProxy(){
	}
	
	public GreetingProxy(Object target){
		this.target = target;
	}

	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		before();
		result = method.invoke(target, args);
		after();
		return result;
	}
	
	public void before(){
		System.out.println("before welcome...");
	}
	
	public void after(){
		System.out.println("after welcome...");
	}



}
