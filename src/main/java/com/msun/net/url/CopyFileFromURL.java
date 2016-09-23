/**
 * @describe 
 * @date 2016年9月7日
 * @author Msun
 * @version 1.0
 * @class com.msun.net.url.CopyFileFromURL.java
 */
package com.msun.net.url;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

public class CopyFileFromURL {
	
	public CopyFileFromURL(){
		
	}
	public boolean isURL(String url){
		String check = "(ht|f)tp(s?)\\:\\/\\/[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z])*(:(0-9)*)*(\\/?)([a-zA-Z0-9\\-\\.\\?\\,\\'\\/\\\\+&amp;%\\$#_]*)?";
		Pattern pattern = Pattern.compile(check);
		Matcher match = pattern.matcher(url);
		return match.matches();
	}
	
	public void copyFile(String url, String savePath){
		try {
			URL httpUrl = new URL(url);
			String fileName = "test.gif";
			File f = new File(savePath + "/" + fileName);
			FileUtils.copyURLToFile(httpUrl, f);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void getFileName(String url){
	    String suffixes="avi|mpeg|3gp|mp3|mp4|wav|jpeg|gif|jpg|png|apk|exe|txt|html|zip|java|doc";  
        Pattern pat=Pattern.compile("[\\w]+[\\.]("+suffixes+")");//正则判断  
        Matcher mc=pat.matcher(url);//条件匹配  
		while (mc.find()) {
			String substring = mc.group();// 截取文件名后缀名
			System.out.println(substring);
		}
	}
	
	public static void main(String[] args){
		CopyFileFromURL copy = new CopyFileFromURL();
		String url = "https://secure-ds.serving-sys.com/BurstingRes/Site-6220/Type-0/d99b3757-c23e-4e18-978d-87e5d49f06dc.gif";
		String path = "D:\\workspace\\code files\\java\\develop\\promote\\src\\main\\java\\com\\msun\\upload";
		copy.copyFile(url, path);
		/*copy.getFileName(url);
		System.out.println(copy.isURL(url));*/
		
		/*try {
			URL uri = new URL(url);
			System.out.println(uri.getContent());
			System.out.println(uri.getFile());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		
	}
}
