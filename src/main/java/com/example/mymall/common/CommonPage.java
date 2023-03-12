package com.example.mymall.common;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @program: MyMall
 * @description: 分页数据封装类
 * @author: Max Wu
 * @create: 2023-02-28 21:46
 **/
public class CommonPage<T> {
	private Integer pageNum;
	private Integer pageSize;
	private Integer totalPage;
	private Long total;
	private List<T> list;
	public static <T> CommonPage<T> restPage(List<T> list) {
		CommonPage<T> result = new CommonPage<T>();
		PageInfo<T> pageInfo = new PageInfo<T>(list);
		result.setTotalPage(pageInfo.getPages());
		result.setPageNum(pageInfo.getPageNum());
		result.setPageSize(pageInfo.getPageSize());
		result.setTotal(pageInfo.getTotal());
		result.setList(pageInfo.getList());
		return result;
	}

	public Integer getPageNum() {
		return pageNum;
	}

	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}
