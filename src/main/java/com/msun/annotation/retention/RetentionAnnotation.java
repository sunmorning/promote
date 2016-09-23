/**
 * @describe @Retention: 定义注解的保留策略
 * <ul>
 * 	<li>@Retention(RetentionPolicy.SOURCE)   //注解仅存在于源码中，在class字节码文件中不包含;</li>
 * <li>@Retention(RetentionPolicy.CLASS)     // 默认的保留策略，注解会在class字节码文件中存在，但运行时无法获得;</li>
 * <li>@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到</li>
 * </ul>
 * @date 2016年9月7日
 * @author Msun
 * @version 1.0
 * @class com.msun.annotation.retention.RetentionAnnotation.java
 */
package com.msun.annotation.retention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.CLASS)
public @interface RetentionAnnotation {
	String describe();
}
