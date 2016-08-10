/**
 * @describe 
 * @date 2016年8月5日
 * @author msun
 * @version 1.0
 * @class com.msun.stream.file.DirList.java
 */
package com.msun.stream.file;

import java.io.File;
import java.util.Arrays;

import com.msun.utils.StringUtil;

public class DirList {
	public static void main(String[] arg0){
		File file = new File("./src/main/java/com/msun/stream/file");
		String[] list;
		String regex = "^.*?\\.(java)$";
		if(StringUtil.isEmpty(regex)){
			list = file.list();
		}else{
			list = file.list(new DirFilter(regex));
		}
		
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		
		for(String dirItem : list){
			System.out.println(dirItem);
		}
	}
}
