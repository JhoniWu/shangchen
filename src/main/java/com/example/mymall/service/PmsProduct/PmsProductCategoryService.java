package com.example.mymall.service.PmsProduct;

import com.example.mymall.mbg.model.PmsProductCategory;

import java.util.List;

public interface PmsProductCategoryService {
	List<PmsProductCategory> listAllCategory();

	int deleteCategory (Long id);

	int createCategory (PmsProductCategory pmsProductCategory);

	int updateCategory (Long id, PmsProductCategory pmsProductCategory);

	PmsProductCategory getCategory (Long id);

	List<PmsProductCategory> listCateGory(int pageNum, int pageSize);
}
