/**
 * @describe 
 * @date 2016年9月7日
 * @author Msun
 * @version 1.0
 * @class com.msun.stream.input.BufferedInputSream.java
 */
package com.msun.stream.input;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputSreams {
	
	public void read() throws IOException{
		byte[] size = new byte[1024 * 5];
		File file = new File("D:\\workspace\\code files\\java\\develop\\promote\\src\\main\\java\\com\\msun\\upload\\test.gif");
		FileInputStream in = new FileInputStream(file);
		int n = 0;
		while(n > -1){
			n = in.read(size);
			System.out.println(n);
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedInputSreams in = new BufferedInputSreams();
		in.read();
	}
}
