/**
 * @describe 
 * @date 2016年9月9日
 * @author Msun
 * @version 1.0
 * @class com.msun.designpattern.singleton.SingletonStudentTest.java
 */
package com.msun.designpattern.singleton;

import org.junit.Test;

public class SingletonStudentTest {

	@Test
	public void test() {
		SingletonStudent student1 = SingletonStudent.getSingletonStudent();
		SingletonStudent student2 = SingletonStudent.getSingletonStudent();
		System.out.println(student1 == student2);
	}

}
