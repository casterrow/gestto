package com.github.destto;

/**
 * 分页封装。
 * @author casterrow@163.com, Stephen Lau
 * @since Oct 20, 2015
 * @version 1.0
 * @param <T> 要分页的对象
 */
public final class Page<T> {
	
	/**每页显示的大小，可配置，默认每页显示10条记录**/
	private int pageSize = 10;
	/**当前页，默认为第一页**/
	private int currentPage = 1;
	/**总页数，默认为0**/
	private int totalCount = 0;
	/**起始页，默认为从0开始**/
	private int startPage = 0;
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**起始页=当前页*每页大小**/
	public int getStartPage() {
		startPage = getCurrentPage() * getPageSize();
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	
	
}
