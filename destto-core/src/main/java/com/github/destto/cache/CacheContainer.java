package com.github.destto.cache;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since 2015年10月22日
 * @version 1.0
 */
public abstract class CacheContainer<K, V> {

	/**
	 * 
	 * @author casterrow@163.com, Stephen Lau
	 * @since 2015年10月22日
	 * @version 1.0
	 * @param key
	 * @return
	 */
	public abstract V getElement(K key);
	
	
	public void putElement(K key, V value) {
		
	}
	
	
	
}
