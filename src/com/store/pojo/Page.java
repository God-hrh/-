package com.store.pojo;

/**
 * 分页对象
 * @author 付军
 *
 */
public class Page {

	//当前页
	private  int  pageNo=1;
	
	//每页显示的条数
	private  int  pageSize=5;
	
	
	//一共有多少条记录 
	
	private  int  allCount=1;
	
	//一共有多少页  需要计算的
	private  int totalPage=1;

	public int getPageNo() {
		//判断   
		if(pageNo<1) {
			pageNo=1;
		}
		
		
		
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getAllCount() {
		return allCount;
	}

	public void setAllCount(int allCount) {
		this.allCount = allCount;
	}

	public int getTotalPage() {
		//获取总页数 
		//        总条数 +每页显示的条数 -1  除以 每页显示的条数
		totalPage=(allCount+pageSize-1)/pageSize;
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
