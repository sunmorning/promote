/**
 * @describe 遍历目录
 * @date 2016年8月8日
 * @author msun
 * @version 1.0
 * @class com.msun.stream.directory.Directory.java
 */
package com.msun.stream.directory;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import com.msun.utils.StringUtil;

public class Directory {
	
	public static class PPrint {
		public static String pformat(Collection<?> c) {
			if (c.size() == 0)
				return "[]";
			StringBuilder result = new StringBuilder("[");
			for (Object elem : c) {
				if (c.size() != 1)
					result.append("\n ");
				result.append(elem);
			}
			if (c.size() != 1)
				result.append("\n");
			result.append("]");
			return result.toString();
		}

		public static void pprint(Collection<?> c) {
			System.out.println(pformat(c));
		}

		public static void pprint(Object[] c) {
			System.out.println(pformat(Arrays.asList(c)));
		}
	}
	
	public static File[] local(File dir, final String regex){
		return dir.listFiles(new FilenameFilter(){
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				return pattern.matcher(new File(name).getName()).matches();
			}
		});
	}
	
	public static File[] local(String path, final String regex){
		return local(new File(path), regex);
	}
	
	public static class TreeInfo implements Iterable<File>{
		
		private List<File> files = new ArrayList<File>();
		private List<File> dirs = new ArrayList<File>();
		
		public List<File> getFiles() {
			return files;
		}

		public void setFiles(List<File> files) {
			this.files = files;
		}

		public List<File> getDirs() {
			return dirs;
		}

		public void setDirs(List<File> dirs) {
			this.dirs = dirs;
		}

		public Iterator<File> iterator() {
			return files.iterator();
		}
		
		public void addAll(TreeInfo other){
			if(other != null){
				files.addAll(other.files);
				dirs.addAll(other.dirs);
			}
		}
		
		public String toString(){
			return "dirs ：" + PPrint.pformat(dirs) + "\n\n files: " + PPrint.pformat(files);
		}
	}
	
	static TreeInfo recurseDirs(File start, String regex){
		TreeInfo result = new TreeInfo();
		
		if(start != null){
			for(File _f : start.listFiles()){
				if(_f.isDirectory()){
					result.dirs.add(_f);
					result.addAll(recurseDirs(_f , regex));
				}else{
					if(StringUtil.isEmpty(regex) || _f.getName().matches(regex)){
						result.files.add(_f);
					}
				}
			}
		}
		return result;
	}
	
	public static TreeInfo walk(String start, String regex){
		return recurseDirs(new File(start), regex);
	}
	
	public static TreeInfo walk(File start, String regex){
		return recurseDirs(start, regex);
	}
	
	public static TreeInfo walk(String start){
		return recurseDirs(new File(start), ".*");
	}
	
	public static TreeInfo walk(File start){
		return recurseDirs(start, ".*");
	}
	
	public static void main(String[] arg0){
		File file = new File(".");
		String regex = "";
		
		if(StringUtil.hasText(regex)){
			System.out.println(Directory.walk(file, regex).toString());
		}else{
			System.out.println(Directory.walk(file).toString());
		}
	}
}
