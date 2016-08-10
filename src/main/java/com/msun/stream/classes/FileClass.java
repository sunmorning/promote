/**
 * @describe 文件和目录路径名的抽象表示形式
 * @date 2016年8月8日
 * @author Msun
 * @version 1.0
 * @class com.msun.stream.file.FileMethod.java
 */
package com.msun.stream.classes;

import java.io.File;
import java.io.IOException;

public class FileClass {
	/**
	 * describe 字段摘要<br/>
	 * <ul>
	 * 	<li><a href="">pathSeparator</a> 与系统有关的路径分隔符，为了方便，它被表示为一个字符串;</li>
	 *  <li><a href="">pathSeparatorChar</a> 与系统有关的路径分隔符;</li>
	 *  <li><a href="">separator</a> 与系统有关的默认名称分隔符，为了方便，它被表示为一个字符串;</li>
	 *  <li><a href="">separatorChar</a> 与系统有关的默认名称分隔符;</li>
	 * <ul>
	 * @date 2016年8月8日
	 * @author Msun
	 */
	public void showFields(){
		System.out.println("pathSeparator: " + File.pathSeparator);
		System.out.println("pathSeparatorChar: " + File.pathSeparatorChar);
		System.out.println("separator: " + File.separator);
		System.out.println("separatorChar: " + File.separatorChar);
	}
	/**
	 * describe  
	 * 
	 * @date 2016年8月8日
	 * @author Msun
	 * @throws IOException 
	 */
	public void judge() throws IOException{
		File file = new File("./src/main/java/com/msun/stream/file/NewFile.xml");
		System.out.println("canExecute: " + file.canExecute());
		System.out.println("canWrite: " + file.canWrite());
		System.out.println("canRead: " + file.canRead());
		System.out.println("exists: " + file.exists());
		System.out.println("getName: " + file.getName());
		System.out.println("getAbsolutePath: " + file.getAbsolutePath());
		System.out.println("getCanonicalPath: " + file.getCanonicalPath());
		System.out.println("getPath: " + file.getPath());
		System.out.println("getParent: " + file.getParent());
		System.out.println("isAbsolute: " + file.isAbsolute());
		System.out.println("isDirectory: " + file.isDirectory());
		System.out.println("isFile: " + file.isFile());
		System.out.println("isHidden: " + file.isHidden());
		System.out.println("lastModified: " + file.lastModified());
	}
}
