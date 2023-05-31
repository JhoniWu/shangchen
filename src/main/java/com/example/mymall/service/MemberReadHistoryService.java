package com.example.mymall.service;

import com.example.mymall.nosql.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * @program: MyMall
 * @description: 会员商品浏览历史Service
 * @author: Max Wu
 * @create: 2023-05-08 15:57
 **/
public interface MemberReadHistoryService {
	/**
	 * 生成浏览记录
	 */
	int create(MemberReadHistory memberReadHistory);

	/**
	 * 批量删除浏览记录
	 */
	int delete(List<String> ids);

	/**
	 * 获取用户浏览历史记录
	 */
	List<MemberReadHistory> list(Long memberId);
}
