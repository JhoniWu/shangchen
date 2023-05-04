package com.example.mymall.dao;

import com.example.mymall.mbg.model.PmsSkuStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品库存管理自定义Dao
 * @author: Max Wu
 * @create: 2023-05-03 11:01
 **/
public interface PmsSkuStockDao {
	/**
	 * 批量插入操作
	 */
	int insertList(@Param("list") List<PmsSkuStock> skuStockList);

	/**
	 * 批量插入或替换操作
	 */
	int replaceList(@Param("list") List<PmsSkuStock> skuStockList);
}
