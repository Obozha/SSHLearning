package cc.sms.dao;

import java.util.List;

import cc.sms.bean.Student;

public class Page {

	private List<Student> stuDataList;
	private int stuCount;

	private int totalPage;
	private int pageSize;
	private int currentPage;

	public Page(int stuCount, int currentPage, int totalPage, List<Student> stuDataList, int pageSize) {
		super();
		this.stuCount = stuCount;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
		this.stuDataList = stuDataList;
		this.pageSize = pageSize;
	}

	public int getStuCount() {
		return stuCount;
	}

	public void setStuCount(int stuCount) {
		this.stuCount = stuCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<Student> getStuDataList() {
		return stuDataList;
	}

	public void setStuDataList(List<Student> stuDataList) {
		this.stuDataList = stuDataList;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
