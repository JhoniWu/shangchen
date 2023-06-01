package com.example.mymall.dao;

import com.example.mymall.mbg.model.SmsCouponProductCategoryRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description:
 * @author: Max Wu
 * @create: 2023-06-01 16:37
 **/
public interface SmsCouponProductCategoryRelationDao {
	int insertList(@Param("list") List<SmsCouponProductCategoryRelation> productCategoryRelationList);
}
