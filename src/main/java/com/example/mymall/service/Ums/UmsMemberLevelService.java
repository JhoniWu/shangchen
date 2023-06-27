package com.example.mymall.service.Ums;

import com.example.mymall.mbg.model.UmsMemberLevel;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-27 15:34
 **/

public interface UmsMemberLevelService {
	/**
	 * 获取所有会员等级
	 */
	List<UmsMemberLevel> list(Integer defaultStatus);
}
