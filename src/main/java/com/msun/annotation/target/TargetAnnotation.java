/**
 * @describe @Target 是Java的元注解（指修饰注解的注解）之一。用来指定注解修饰类的哪个成员。加大括号表示一个数组，指被修饰的注解能用于多个不同的类成员。<br/>
 * <ul>
 * 	<li>@Target(ElementType.TYPE) //接口、类、枚举、注解</li>
 * 	<li>@Target(ElementType.FIELD) //字段、枚举的常量 </li>
 *  <li>@Target(ElementType.METHOD) //方法 </li>
 *  <li>@Target(ElementType.PARAMETER) //方法参数 </li>
 *  <li>@Target(ElementType.CONSTRUCTOR) //构造函数 </li>
 *  <li>@Target(ElementType.LOCAL_VARIABLE)//局部变量  </li>
 *  <li>@Target(ElementType.ANNOTATION_TYPE)//注解 </li>
 *  <li>@Target(ElementType.package) ///包 </li>
 * </ul>
 * <h1>这里可以使用多个，比如:@Target({ElementType.TYPE,ElementType.METHOD})</h1>
 * @date 2016年9月7日
 * @author Msun
 * @version 1.0
 * @class com.msun.annotation.target.TargetAnnotation.java
 */
package com.msun.annotation.target;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TargetAnnotation {
	
}
