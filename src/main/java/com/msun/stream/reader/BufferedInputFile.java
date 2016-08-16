/**
 * @describe 
 * @date 2016年8月16日
 * @author Msun
 * @version 1.0
 * @class com.msun.stream.reader.BufferedInputFile.java
 */
package com.msun.stream.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.msun.utils.StringUtil;

public class BufferedInputFile {
	public String read(File file){
		StringBuffer sb = new StringBuffer();
		
		if(file.isFile()){
			try {
				BufferedReader in = new BufferedReader(new FileReader(file));
				String s;
				while(StringUtil.hasText(s = in.readLine())){
					sb.append(s);
				}
				in.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return sb.toString();
	}
}
