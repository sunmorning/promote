/**
 * @describe 
 * @date 2016.9.23
 * @author Msun
 * @version 1.0
 * @class com.msun.AspectJ.MethodLogger.java
 */
package com.msun.AspectJ;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import com.jcabi.log.Logger;

@Aspect
public class MethodLogger {
	
	@Pointcut("execution(* *.*(..) && @annotation(Loggable))")
	public void aspectjMethod() {
		 
	}
	
	@Around("execution(* *(..) && @annotation(Loggable))")
	public Object around(ProceedingJoinPoint point){
		long start = System.currentTimeMillis();
		Object obj = null;
		try {
			obj = point.proceed();
			System.out.println("test....");
			Logger.info("#%s(%s): %s in %[msec]s", 
					  MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
				      point.getArgs(),
				      obj,
				      System.currentTimeMillis() - start);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return obj;
	}
}
