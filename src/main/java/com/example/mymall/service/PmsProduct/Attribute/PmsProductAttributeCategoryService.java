package com.example.mymall.service.PmsProduct.Attribute;

import com.example.mymall.mbg.model.PmsProductAttributeCategory;

import java.util.List;

/**
 * @program: MyMall
 * @description: 商品属性分类service
 * @author: Max Wu
 * @create: 2023-04-27 17:10
 **/
public interface PmsProductAttributeCategoryService {
	List<PmsProductAttributeCategory> listAllAttributeCategory();

	int createAttributeCategory(String name);

	int updateAttributeCategory(Long id, PmsProductAttributeCategory pmsProductAttribute);

	int deleteAttributeCategory(Long id);

	List<PmsProductAttributeCategory> listAttributeCategory(int pageNum, int pageSize);

	PmsProductAttributeCategory getAttributeCategory(Long id);
}
