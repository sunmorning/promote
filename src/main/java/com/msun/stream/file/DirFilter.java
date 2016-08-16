/**
 * @describe 
 * @date 2016年8月5日
 * @author msun
 * @version 1.0
 * @class com.msun.stream.file.DirFilter.java
 */
package com.msun.stream.file;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

public class DirFilter implements FilenameFilter{
	
	private Pattern pattern;
	
	public DirFilter(String regex){
		pattern = Pattern.compile(regex);
	}
	
	public boolean accept(File dir, String name) {
		return pattern.matcher(name).matches(); 
	}

}
