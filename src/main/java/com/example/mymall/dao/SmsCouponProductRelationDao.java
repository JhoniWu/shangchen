package com.example.mymall.dao;

import com.example.mymall.mbg.model.SmsCouponProductRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-01 16:38
 **/
public interface SmsCouponProductRelationDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<SmsCouponProductRelation> productRelationList);
}
