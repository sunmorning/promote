/**
 * @describe 字符串匹配算法
 * @date 2016年7月25日
 * @author msun
 * @version 1.0
 * @class com.msun.algorithms.string.StringMatching.java
 */
package com.msun.algorithms.string;

import java.util.HashMap;
import java.util.Map;

import com.msun.utils.Constant;


public class StringMatching {
	
	/**
	 * describe 在用于查找子字符串的算法当中，BM（Boyer-Moore）算法是目前被认为最高效的字符串搜索算法，它由Bob Boyer和J Strother Moore设计于1977年。<br/>
	 * <a href = "http://blog.jobbole.com/52830/"></a>
	 * <p>假设文本串text长度为n，模式串pattern长度为m，BM算法的主要特征为：</p>
	 * <ul>
	 * 	<li>从右往左进行比较匹配（一般的字符串搜索算法如KMP都是从从左往右进行匹配）；</li>
	 * 	<li>算法分为两个阶段：预处理阶段和搜索阶段；</li>
	 * 	<li>预处理阶段时间和空间复杂度都是是O(m+)，是字符集大小，一般为256；</li>
	 *  <li>搜索阶段时间复杂度是O(mn)；</li>
	 *  <li>当模式串是非周期性的，在最坏的情况下算法需要进行3n次字符比较操作；</li>
	 *  <li>算法在最好的情况下达到O(n/m)，比如在文本串b中搜索模式串ab ，只需要n/m次比较。</li>
	 * </ul>
	 * @param text 文本串text
	 * @param pattern 模式串pattern
	 * @date 2016年7月25日
	 * @author msun
	 */
	public void boyerMoore(String text, String pattern){
		
		if(text != null && !text.isEmpty() && pattern != null && !pattern.isEmpty()){
			if(pattern.length() < text.length()){
				
				int _patternLength = pattern.length();
				Map<String, Integer> _badCharater = new HashMap<String, Integer>();
				
				//计算坏字符串
				for(int i = _patternLength - Constant.TWO; i >= Constant.ZERO; i--){
					char _pattern = pattern.charAt(i);
					if(!_badCharater.containsKey(String.valueOf(_pattern))){
						_badCharater.put(String.valueOf(_pattern), _patternLength - i - Constant.ONE);
					}
				}
				
				//计算好后缀
				int[] _goodSuffix = new int[_patternLength];
				char[] _pattern = pattern.toCharArray();
				
				_goodSuffix[_patternLength - Constant.ONE] = _patternLength;
				for(int i = _patternLength - Constant.TWO; i >= Constant.ZERO; i--){
					int _move = i;
					while(_move >= Constant.ZERO && _pattern[_move] == _pattern[_patternLength - Constant.ONE - i + _move]){
						_move--;
					}
					_goodSuffix[i] = i - _move;
				}
				
				int[] _goodPostfix = new int[_patternLength];
				// 1. 模式串中没有子串匹配上好后缀，也找不到一个最大前缀
				for(int i = Constant.ZERO; i < _patternLength; i++){
					_goodPostfix[i] = _patternLength;
				}
				//2. 模式串中没有子串匹配上好后缀，但找到一个最大前缀
				for(int i = _patternLength - Constant.ONE; i >= Constant.ZERO; i--){
					if(_goodSuffix[i] == i + Constant.ONE){
						for(int j = Constant.ZERO; j < _patternLength - Constant.ONE - i; j++){
							if(_goodPostfix[j] == _patternLength){
								_goodPostfix[j] = _patternLength - Constant.ONE - i;
							}
						}
					}
				}
				//3.模式串中有子串匹配上好后缀
				for(int i = Constant.ZERO; i < _patternLength - Constant.ONE; i++){
					_goodPostfix[_patternLength - Constant.ONE - _goodSuffix[i]] = _patternLength - Constant.ONE - i;
				}
				
				//按照上述两个规则查找字符串
				int _textLength = text.length();
				int _move = Constant.ZERO;
				while(_move <= _textLength - _patternLength){
					int i = _patternLength - Constant.ONE;
					for(; i >= Constant.ZERO && text.charAt(i + _move) == pattern.charAt(i); i--){
					}
					if(i < Constant.ZERO){
						System.out.println("Find it, the position is : " + _move);
						_move += _goodPostfix[Constant.ZERO];
					}else{
						int _goodPostfixMove = _goodPostfix[i];
						int _badCharaterMove = (_badCharater.containsKey(String.valueOf(text.charAt(i + _move))) ? _badCharater.get(String.valueOf(text.charAt(i + _move))) : _patternLength) - _patternLength + i + Constant.ONE;
						_move += _goodPostfixMove > _badCharaterMove ? _goodPostfixMove : _badCharaterMove;
					}
				}
			}else{
				System.out.println("The result is: pattern length more than text length!");
			}
		}
	}
}
