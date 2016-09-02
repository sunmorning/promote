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
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import com.msun.utils.StringUtil;

public class BufferedInputFile {
	
	public String read(File file){
		StringBuffer sb = new StringBuffer();
		
		if(file.isFile()){
			try {
				BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
				String s;
				while(StringUtil.hasText(s = in.readLine())){
					if(StringUtil.hasText(sb)){
						sb.append("\n");
					}
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
	
	public String read(String path){
		if(StringUtil.hasText(path)){
			return read(new File(path));
		}else{
			return "";
		}
	}
	
	public void memoryInput(){
		StringReader reader = new StringReader(new BufferedInputFile().read("./src/main/java/com/msun/stream/reader/BufferedInputFile.java"));
		int c;
		try {
			while((c = reader.read()) != -1){
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
