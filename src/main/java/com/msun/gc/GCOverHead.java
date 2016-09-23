/**
 * @describe 
 * <p>执行java -XX:+PrintGCDetails -XX:+UseGCOverheadLimit -Xmn5m -Xmx20m GCOverHead ，据说会报java.lang.OutOfMemoryError:GC over head limit exceeded，
 *    意思是不断在做Full GC，每次GC完后释放一点点内存，然后一下子就又满了，不断重复，当次数达到一定量，并且平均FULL GC时间达到一定比例时，就会报错；</p>
 * @date 2016年9月3日
 * @author Msun
 * @version 1.0
 * @class com.msun.gc.GCOverHead.java
 */
package com.msun.gc;

import java.util.ArrayList;
import java.util.List;

public class GCOverHead {
	public final static byte[] DEFAULT_BYTES = new byte[12 * 1024 * 1024]; 
	public static void main(String[] args) {
		 List<byte[]> temp = new ArrayList<byte[]>();  
         while(true) {  
			temp.add(new byte[1024 * 1024]);
			if (temp.size() > 10) {
				temp.clear();
			}
         } 
	}
}
 