/**
 * @describe 
 * @date 2016年9月21日
 * @author Msun
 * @version 1.0
 * @class com.msun.AspectJ.AspectMain.java
 */
package com.msun.AspectJ;

import org.apache.log4j.Logger;

public class AspectMain {
	
	private Logger logger = Logger.getLogger(getClass());
	
	public void test(){
		logger.info("test.....");
	}
	
	public static void main(String[] args) {
		RecordLogger record = new RecordLogger();
		record.reload("reload", 1, 5);
	}

}
