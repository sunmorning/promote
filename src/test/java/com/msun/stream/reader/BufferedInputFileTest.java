package com.msun.stream.reader;

import java.io.File;

import org.testng.annotations.Test;

public class BufferedInputFileTest {

	@Test
	public void read() {
		String path = "./src/main/java/com/msun/stream/file/NewFile.xml";
		BufferedInputFile buffer = new BufferedInputFile();
		String result = buffer.read(new File(path));
		System.out.println(result);
	}
	
	@Test
	public void memoryInput(){
		new BufferedInputFile().memoryInput();
	}
	
	@Test
	public void test(){
		System.out.println(this.getClass().getResource("/"));
		System.out.println(this.getClass().getResource(""));
		System.out.println(new File("").getAbsolutePath());
	}
}
