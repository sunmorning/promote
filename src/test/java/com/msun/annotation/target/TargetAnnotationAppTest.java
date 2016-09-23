package com.msun.annotation.target;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

import org.testng.annotations.Test;

public class TargetAnnotationAppTest {
	@Test
	public void f() {
		Class<TargetAnnotationApp> clazz = TargetAnnotationApp.class;
		Field[] field = clazz.getFields();
		
		for(Field _field : field){
			System.out.println(_field.getName() + " annotation are:  ");
			for(Annotation annotation :  _field.getAnnotations()){
				System.out.println(annotation.toString());
			}
			System.out.println();
		}
	}
}
