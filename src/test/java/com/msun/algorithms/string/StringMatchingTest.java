package com.msun.algorithms.string;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class StringMatchingTest {

	@Test
	public void boyerMoore() {
		String text = "Here is a simple example"; //abbadcababacab
		String pattern = "example"; //babac
		StringMatching match = new StringMatching();
		match.boyerMoore(text, pattern);
	}
	
	@Test
	public void suffix(){
		
		String pattern = "example";
		
		Map<String,Integer> bmBc = new HashMap<String, Integer>();
		
		for(int i = pattern.length() - 2; i >= 0; i--){
			char _pattern = pattern.charAt(i);
			if(!bmBc.containsKey(String.valueOf(_pattern))){
				bmBc.put(String.valueOf(_pattern), pattern.length() - i - 1);
			}
		}
		
		System.out.println(bmBc);
		
		//String pattern = "GCAGAGAG";
		int patLength = pattern.length();
		int[] suffix = new int[pattern.length()];
		
		suffix[patLength - 1] = patLength;
		int q = 0;
		for (int i = patLength - 2; i >= 0; i--) {
			q = i;
			while (q >= 0
					&& pattern.charAt(q) == pattern.charAt(patLength - 1 - i
							+ q)) {
				q--;
			}
			suffix[i] = i - q;
		}
		
		for(int i = 0; i < patLength; i++){
			System.out.print(suffix[i] + ",");
		}
		
		System.out.println();
		
		int i, j;
		int[] bmGs = new int[patLength];
		// 模式串中没有子串匹配上好后缀，也找不到一个最大前缀
		for (i = 0; i < patLength; i++) {
			bmGs[i] = patLength;
		}
		// 模式串中没有子串匹配上好后缀，但找到一个最大前缀
		j = 0;
		for (i = patLength - 1; i >= 0; i--) {
			if (suffix[i] == i + 1) {
				for (; j < patLength - 1 - i; j++) {
					if (bmGs[j] == patLength) {
						bmGs[j] = patLength - 1 - i;
					}
				}
			}
		}
		// 模式串中有子串匹配上好后缀
		for (i = 0; i < patLength - 1; i++) {
			bmGs[patLength - 1 - suffix[i]] = patLength - 1 - i;
		}
		System.out.print("bmGs:");
		for (i = 0; i < patLength; i++) {
			System.out.print(bmGs[i] + ",");
		}
	}
}
