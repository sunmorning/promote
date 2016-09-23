package com.msun.annotation.retention;

import java.lang.annotation.Annotation;

import org.testng.annotations.Test;

public class RetentionAnnotationTest {

	@Test
	public void describe() {
		Class<RetentionAnnotationApp> clazz = RetentionAnnotationApp.class;
		Annotation[] anno = clazz.getAnnotations();
		for(Annotation _anno : anno){	
			System.out.println(_anno.toString());
		}
	}
	
	@Test
	public void compare(){
		Integer t1 = null;
		Integer t2 = 1;
		System.out.println(t1 == t2);
		
		boolean b1 = true;
		boolean b2 = true;
		System.out.println(b1 == b2);
	}
}
