package com.msun.stream.classes;

import java.io.IOException;

import org.testng.annotations.Test;

public class FileClassTest {
	
	private FileClass fileclass = new FileClass();
	
	@Test
	public void showFields() {
		fileclass.showFields();
	}
	
	@Test
	public void judge() throws IOException{
		fileclass.judge();
	}
}
