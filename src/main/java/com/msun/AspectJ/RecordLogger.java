/**
 * @describe 
 * @date 2016年9月21日
 * @author Msun
 * @version 1.0
 * @class com.msun.AspectJ.RecordLogger.java
 */
package com.msun.AspectJ;

import com.jcabi.aspects.Loggable;

public class RecordLogger {
	public RecordLogger(){
		
	}
	@Loggable
	public void reload(String arg1, int start, int end){
		try {
			Thread.sleep(1000);
			System.out.println("This is reload methd.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
