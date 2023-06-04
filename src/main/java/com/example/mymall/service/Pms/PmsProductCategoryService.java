package com.example.mymall.service.Pms;

import com.example.mymall.mbg.model.PmsProductCategory;

import java.util.List;

public interface PmsProductCategoryService {
	List<PmsProductCategory> listAllCategory();

	List<PmsProductCategory> listFirstLevelCategory();

	List<PmsProductCategory> listSecondLevelCategoryById(Long parentId);

	int deleteCategory (Long id);

	int createCategory (PmsProductCategory pmsProductCategory);

	int updateCategory (Long id, PmsProductCategory pmsProductCategory);

	PmsProductCategory getCategory (Long id);

	List<PmsProductCategory> listCateGory(int pageNum, int pageSize);
}
