package com.muke.employee.domain;
/**
 * 分页封装的类
 * @author sean
 *
 */

import java.util.List;

public class PageBean<E> {

	private int currPage;//当前页数
	private int pageSize;//每夜显示的记录数
	private int totalCount;//总记录数
	private int totalPage;//总页数
	private List<E> list;//每夜显示的数据
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<E> getList() {
		return list;
	}
	public void setList(List<E> list) {
		this.list = list;
	}
}
