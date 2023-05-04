package com.example.mymall.dao;

import com.example.mymall.mbg.model.PmsProductAttributeValue;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品参数/规格属性自定义Dao
 * @author: Max Wu
 * @create: 2023-05-03 16:59
 **/
public interface PmsProductAttributeValueDao {
	/**
	 * 批量创建
	 */
	int insertList(@Param("list") List<PmsProductAttributeValue> productAttributeValues);
}
