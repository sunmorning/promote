/**
 * @describe String common function
 * @date 2016年8月5日
 * @author msun
 * @version 1.0
 * @class com.msun.utils.StringUtil.java
 */
package com.msun.utils;

public class StringUtil {
	/**
	 * describe 字符串是否为空 
	 * @param str
	 * @return
	 * @date 2016年8月5日
	 * @author msun
	 */
	public static final boolean isEmpty(CharSequence str){
		return !hasLength(str);
	}
	
	/**
	 * describe 字符串是否有字符 
	 * @param str
	 * @return
	 * @date 2016年8月5日
	 * @author msun
	 */
	public static final boolean hasText(CharSequence str){
		if(str == null || str.length() == Constant.ZERO){
			return false;
		}
		
		int length = str.length();
		for(int i = 0; i < length; i++){
			if(!Character.isWhitespace(str.charAt(i))){
				return true;
			}
		}
		return false;
	}
	/**
	 * describe Check that the given CharSequence is neither <code>null</code> nor of length 0.
	 * @param str
	 * @return
	 * @date 2016年8月5日
	 * @author msun
	 */
	public static final boolean hasLength(CharSequence str){
		return str != null && str.length() > 0;
	}
}
