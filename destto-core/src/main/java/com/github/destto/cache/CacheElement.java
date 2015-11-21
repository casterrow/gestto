package com.github.destto.cache;

/**
 * 
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 20, 2015
 * @version 1.0
 */
public class CacheElement {
	
	private Object objectValue;
    private Object objectKey;
    private int index;
    private int hitCount;
    
	public Object getObjectValue() {
		return objectValue;
	}
	public void setObjectValue(Object objectValue) {
		this.objectValue = objectValue;
	}
	public Object getObjectKey() {
		return objectKey;
	}
	public void setObjectKey(Object objectKey) {
		this.objectKey = objectKey;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
    
}
