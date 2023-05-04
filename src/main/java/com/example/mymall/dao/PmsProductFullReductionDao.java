package com.example.mymall.dao;

import com.example.mymall.mbg.model.PmsProductFullReduction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品满减自定义Dao
 * @author: Max Wu
 * @create: 2023-05-03 10:49
 **/
public interface PmsProductFullReductionDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<PmsProductFullReduction> productFullReductionList);
}
