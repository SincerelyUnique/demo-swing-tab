package com.example.utils;

import java.io.File;
import java.net.URL;
import java.util.HashMap;

/**
 * 本地磁盘资源文件缓存中心超类，子类可继承本类以实现磁盘资源的集中缓存.
 *
 * @param <T> the generic type
 * @author Jack Jiang(jb2011@163.com), 2010-09-11
 * @version 1.0
 */
public abstract class RawCacheRoot<T> {
	
	// 本地磁盘资源缓存中心（key=path,value=image对象）
	private HashMap<String,T> rawCache = new HashMap<String,T>();
	
	/**
	 * 本地磁盘资源（如果缓存中已存在，则从中取之，否则从磁盘读取并缓存之）。.
	 *
	 * @param path 本地磁盘资源相对于baseClass类的相对路径，比如它如果在/res/imgs/pic/下，baseClass在
	 * /res下，则本地磁盘资源此处传过来的相对路径应该是/imgs/pic/some.png
	 * @param baseClass 基准类，指定此类则获取本地磁盘资源时会以此类为基准取本地磁盘资源的相对物理目录
	 * @return T
	 */
	public T getRaw(String path, String name ,Class baseClass) {
		T ic=null;
		
		String key = path + baseClass.getCanonicalName();
		if(rawCache.containsKey(key)){
			ic = rawCache.get(key);
		}else {
			try {
				// jar包中运行，URL直接使用相对路径；如果url为空，则取绝对路径
				URL url = baseClass.getResource(path);
				if ( null==url ){
					String clazzPath = this.getClass().getResource("/").getPath();
					path = "file://"+ clazzPath + path;
					url = new URL(path);
				}

				System.out.println("path="+path);
				System.out.println("name="+name);
				System.out.println("url="+url.getPath());

				ic = getResource(url);
				rawCache.put(key, ic);
			} catch (Exception e) {
				System.out.println("取本地磁盘资源文件出错,path="+key+","+e.getMessage());
				e.printStackTrace();
			}
		}
		return ic;
	}
	
	/**
	 * 本地资源获取方法实现.
	 *
	 * @param relativePath 相对路径
	 * @return the resource
	 */
	protected abstract T getResource(URL relativePath);

}
